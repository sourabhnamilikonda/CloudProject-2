let http = require('https');
let medAPI = 'wsearch.nlm.nih.gov';

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
          console.log('1 option selected');
        }
        else
        {
          callback(null, {"speech": "Please enter the term you want to know about or the url of image."});
        }
        break;
    case 'MedicineInformation':
		let medName = event.result.parameters['any'];
        console.log(medName);
        let medURL = event.result.parameters['url'];
        console.log(medURL);
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
            console.log('Medicine url ' + medURL);
        }
        break;
        default:
        break;
  }
};
 
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
