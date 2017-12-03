let http = require('https');
let medAPI = 'wsearch.nlm.nih.gov';
let AWS = require('aws-sdk');
AWS.config.loadFromPath(__dirname + '/config.json');
let doClient = new AWS.DynamoDB.DocumentClient({region:'us-east-1'});
let ses= new AWS.SES({region:'us-east-1'});
//**change here */
let fromemail='sourabh.namilikonda@sjsu.edu';


exports.handler = function(event, context, callback) {
  let intentName = event.result.metadata['intentName'];
  console.log(intentName);
  switch(intentName)
  {
    case 'MainFlow':
        let optionNumber = event.result.parameters['number'];
        console.log(optionNumber);
        let optionOrdinalNumber = event.result.parameters['ordinal'];
        console.log(optionOrdinalNumber);
        
        if(optionNumber==1 || optionOrdinalNumber==1)
        {
          callback(null, {"speech":"Please provide date for your appointment:"});
        }
        else if(optionNumber==2 || optionOrdinalNumber==2)
        {
          callback(null, {"speech": "Please enter the term you want to know about or the url of image."});
        }
        else
        {
            callback(null, {"speech":"Please provide your EmailId to verify:"});
        }
        break;
    case 'MedicineInformation':
		let medName = event.result.parameters['any'];
        console.log(medName);
        let medURL = event.result.parameters['url'];
        console.log(medURL);
        var medTerm='';
        if(medName!=='')
        {
          var body='';
          var url = "https://wsearch.nlm.nih.gov/ws/query?db=healthTopics&term="+ medName +"&rettype=brief&retmax=1";
          http.get(url, function(res) {
              res.setEncoding();
              res.on("data", function(chunk) {
                //console.log("BOY: " + chunk);
                body+=chunk;
              })
              res.on("end", function() {
                console.log("inside end");
                //console.log("body::" + body);
                var parseString = require("xml2js").parseString;
				parseString(body, function(error, result){
					if(error){
						console.log("Error" + error);
						return;
					}
					var s=JSON.stringify(result);
					var y= JSON.parse(s);
					var respo=y.nlmSearchResult.list[0].document[0].content.find((it)=>{return it.$.name==='FullSummary'});
					respo=respo._;
					respo=respo.replace(/<p\s*[\/]?>/gi, "\n");
					respo=respo.replace(/<p.*>/gi, "\n");
					respo=respo.replace(/<a.*href="(.*?)".*>(.*?)<\/a>/gi, " $2 (Link->$1) ");
					respo=respo.replace(/<(?:.|\s)*?>/g, "");
					callback(null, {"speech": respo});
					//callback(null, {"messages":[{"type":0, "speech":respo},{"type":0, "speech":"hi"}]});
				});
              });
          }).on('error', function(e) {
            console.log("Got error: " + e.message);
            context.done(null,'');
          });
          //callback(null, {"speech":"Medicine name " + medName});
        }
        if(medURL!=='')
        {
            let Vision = require('@google-cloud/vision');
            let vision = new Vision({
                    projectId: 'medibot-35205',
                    keyFilename: __dirname + '/MediBot-e71ac7693c45.json'
                });;
            
			//const fileName = __dirname+'/image.png';
            let request = {
                source: {
                //filename: fileName
                imageUri: medURL
                }
            };
            vision.textDetection(request)
                .then((results) => {
                    let detections = results[0].textAnnotations;
                    console.log('here reached now:'+ detections[0].description.replace(/\r?\n/g, ""));
                    medTerm=detections[0].description.replace(/\r?\n/g, "");
                    console.log('and here'+medTerm)
                    //detections.forEach((text) => 
                        //console.log(text.description)
                        //medTerm=text.description
                    //);
                    var body='';
                    var url = "https://wsearch.nlm.nih.gov/ws/query?db=healthTopics&term="+ medTerm +"&rettype=brief&retmax=1";
                    http.get(url, function(res) {
                        res.setEncoding();
                        res.on("data", function(chunk) {
                          //console.log("BOY: " + chunk);
                          body+=chunk;
                        })
                        res.on("end", function() {
                          console.log("inside end");
                          //console.log("body::" + body);
                          var parseString = require("xml2js").parseString;
                          parseString(body, function(error, result){
                              if(error){
                                  console.log("Error" + error);
                                  return;
                              }
                              var s=JSON.stringify(result);
                              var y= JSON.parse(s);
                              var respo=y.nlmSearchResult.list[0].document[0].content.find((it)=>{return it.$.name==='FullSummary'});
                              respo=respo._;
                              respo=respo.replace(/<p\s*[\/]?>/gi, "\n");
                              respo=respo.replace(/<p.*>/gi, "\n");
                              respo=respo.replace(/<a.*href="(.*?)".*>(.*?)<\/a>/gi, " $2 (Link->$1) ");
                              respo=respo.replace(/<(?:.|\s)*?>/g, "");
                              callback(null, {"speech": respo});
                              //callback(null, {"messages":[{"type":0, "speech":respo},{"type":0, "speech":"hi"}]});
                          });
                        });
                    }).on('error', function(e) {
                      console.log("Got error: " + e.message);
                      context.done(null,'');
                    });
                })
                .catch((err) => {
                    console.error('ERROR:', err);
                });
        }
        console.log('medTerm:' + medTerm);
        break;
    case "MainFlowAppointment":
        let appEmail = event.result.parameters['email'];
        console.log(appEmail);
        let appDate = event.result.parameters['date'];
        console.log(appDate);
        let appTime = event.result.parameters['time'];
        console.log(appTime);
        console.log(event.sessionId);
    
        //*check if email verified */
        ses.listVerifiedEmailAddresses(function(err, data) {
            if(err) {
                callback(null, {"speech": "Please verify your emailid before scheduling appointment."});
            } 
            else {
                let emailArr=data.VerifiedEmailAddresses;
                console.log(emailArr);
                if(emailArr.includes(appEmail))
                {
                    console.log("Email verified sending mail.");
                    let randomnum=Math.floor(100000 + Math.random() * 900000);
                    sendVerificationMail(appEmail, randomnum);
                    let parmas={
                        Item:{
                            SessionId:event.sessionId,
                            Email:appEmail,
                            Date:appDate,
                            Time:appTime,
                            Secret:randomnum
                        },
                        TableName:'AppointmentSchedule'
                    };
                    doClient.put(parmas, function(err, data){
                        if(err){
                            callback(null,{"speech":"some error"});
                        }
                        else{
                            callback(null, {"speech":"Email containing OTP has been sent. Please verify."});
                        }
                    });
                }
                else
                {
                    callback(null, {"speech": "Please verify your emailid before scheduling appointment."});
                }
            } 
        });
        break;	
    case "MainFlowAppointment - custom":
        let session = event.sessionId;
        let userEnteredSecret=event.result.parameters['number-integer'];
        var params={
            TableName:"AppointmentSchedule",
            Key:{
                "SessionId":session
            }
        };
        doClient.get(params, function(err, data){
            if(err)
            {
                console.log("error place 1");
                callback(null, {"speech":"Could not verify. Cannot schedule appointment now."});
            }
            else
            {
                console.log(data);
                if(Object.keys(data).length === 0 && data.constructor === Object)
                {
                    console.log("error place 3");
                    callback(null, {"speech":"Could not verify. Cannot schedule appointment now."});
                }
                else
                {
                    console.log(data.Item.Secret);
                    console.log(userEnteredSecret);
                    if(data.Item.Secret==userEnteredSecret)
                    {
                        callback(null, {"speech":"OTP confirmed. Appointment Scheduled."});
                    }
                    else
                    {
                        console.log("error place 2");
                        callback(null, {"speech":"Could not verify. Cannot schedule appointment now."});   
                    }
                }
            }
        });
        break;
    case "MainFlowEmailVerify":
        let appEmail1 = event.result.parameters['email'];
        console.log(appEmail1);
        verifyEmailAddress(appEmail1);
        callback(null, {"speech":"Please verify using the link sent to your mailid. Please press/say hi to start again."});
        break;    
    default:
        break;
  }
};

function verifyEmailAddress(email) {
    var params = {
        EmailAddress: email
    };
    
    ses.verifyEmailAddress(params, function(err, data) {
        if(err) {
            console.log(err);
        } 
        else {
            console.log("success verifying");
            console.log(data);
        } 
    });
}

function sendVerificationMail(email, randomnum) {
    var ses_mail = "From: 'Appointment OTP' <" + fromemail + ">\n";
    ses_mail = ses_mail + "To: " + email + "\n";
    ses_mail = ses_mail + "Subject: Confirmation OTP\n";
    ses_mail = ses_mail + "MIME-Version: 1.0\n";
    ses_mail = ses_mail + "Content-Type: multipart/mixed; boundary=\"NextPart\"\n\n";
    ses_mail = ses_mail + "--NextPart\n";
    ses_mail = ses_mail + "Content-Type: text/html; charset=us-ascii\n\n";
    ses_mail = ses_mail + "Please schedule appointment by entering this value in chat window.\n\n";
    ses_mail = ses_mail + "OTP: " + randomnum;
    
    var params = {
        RawMessage: { Data: new Buffer(ses_mail) },
        Destinations: [ email ],
        Source: "'Appointment OTP' <" + fromemail + ">'"
    };
    
    ses.sendRawEmail(params, function(err, data) {
        if(err) {
            console.log("speech:mail sending error");
            console.log(err);
        } 
        else {
            console.log("speech:mail sending success");
        }           
    });
}
/* 
function searchTermRequestOptions(medName) {
    return {
        host: medAPI,
        path:'/ws/query?db=healthTopics&term=asthma&rettype=brief',
        method: 'GET',
        headers:{
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Headers':'Origin, X-Requested-With, Content-Type, Accept'
        }
    };
}
 
function makeRequest(options, callback) {
    var request = http.request(options, 
    function(response) {
        var responseString = '';
        response.on('data', function(data) {
            console.log('hi');
            responseString += data;
        });
        //console.log(response);
         response.on('end', function() {
             //console.log(request);
            console.log(response); 
            //console.log(response);
            callback(responseString);
            //var responseJSON = JSON.parse(responseString);
            //callback(responseJSON, null);
        });
    });
    request.end();
}
*/