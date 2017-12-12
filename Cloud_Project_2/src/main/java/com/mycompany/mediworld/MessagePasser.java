/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mediworld;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudwatchevents.AmazonCloudWatchEvents;
import com.amazonaws.services.cloudwatchevents.AmazonCloudWatchEventsClientBuilder;
import com.amazonaws.services.cloudwatchevents.model.PutRuleRequest;
import com.amazonaws.services.cloudwatchevents.model.PutRuleResult;
import com.amazonaws.services.cloudwatchevents.model.PutTargetsRequest;
import com.amazonaws.services.cloudwatchevents.model.PutTargetsResult;
import com.amazonaws.services.cloudwatchevents.model.RuleState;
import com.amazonaws.services.cloudwatchevents.model.Target;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MessagePasser 
{
    public void sendMessage(String userName,String medicine)
    {
          try
        {
    
            
    AWSCredentials awsCredentials = new BasicAWSCredentials("", "");
    final AmazonSNSClient client = new AmazonSNSClient(awsCredentials);
    client.setRegion(Region.getRegion(Regions.US_WEST_1));

    AmazonSNSClient snsClient = new AmazonSNSClient(awsCredentials);
    UserInformation information=new UserInformation();
    
   
    
    String message = "Your reminder for medicine "+medicine+" has been scheduled.You will receive reminder on every 3 hours";
    
    String message2 = "Your reminder for medicine "+medicine+" has been scheduled.You will receive reminder on every 6 hours";
    
    String message3 = "Your reminder for medicine "+medicine+" has been scheduled.You will receive reminder on every 9 hours";
    
    String message4 = "Your reminder for medicine "+medicine+" has been scheduled.You will receive reminder on every 12 hours";
    
    
   
    String phone=information.getPhoneNo(userName);
 
    String phoneNumber = "+1"+phone;
    
  
    
    Map<String, MessageAttributeValue> smsAttributes = 
            new HashMap<String, MessageAttributeValue>();
    //<set SMS attributes>
    sendSMSMessage(snsClient, message, phoneNumber, smsAttributes);
    }
    catch(Exception e)
    {
        e.printStackTrace();
            
        }
    }
    
    public static void sendSMSMessage(AmazonSNSClient snsClient, String message, 
		String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {
        PublishResult result = snsClient.publish(new PublishRequest()
                        .withMessage(message)
                        .withPhoneNumber(phoneNumber)
                        .withMessageAttributes(smsAttributes));
        System.out.println(result); // Prints the message ID.
}
    
    public void createNewRoleAndTopic()
    {
        try
{
        AWSCredentialsProvider provider=new AWSCredentialsProvider() {
            @Override
            public AWSCredentials getCredentials() {
              AWSCredentials credentials = new BasicAWSCredentials(
                "",
                "");
              
              return credentials;
            }

            @Override
            public void refresh() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        
        final AmazonCloudWatchEvents cwe =AmazonCloudWatchEventsClientBuilder.standard().withCredentials(provider)
                .withRegion(Regions.US_EAST_1)
                .build();
        
        Random rd2=new Random();
   String rulePlus=String.valueOf(rd2.nextLong());

     String rule_name="Rule2"+rulePlus;
    
     
     Random rd=new Random();
   String target_id=String.valueOf(rd.nextLong());
        String role_arn="";
      
     PutRuleRequest request = new PutRuleRequest()
    .withName(rule_name)
    //.withRoleArn(role_arn)
    .withScheduleExpression("rate(5 minutes)")
    .withState(RuleState.ENABLED);
     
     
     
     
    

    PutRuleResult response = cwe.putRule(request);
    String function_arn="";
    Target target = new Target().withArn(function_arn).withId(target_id);
  
    
        System.out.println("response:"+response);

   PutTargetsRequest requestTarget = new PutTargetsRequest()
    .withTargets(target)
    .withRule(rule_name);
   
   
        System.out.println("requestTarget:"+requestTarget);
   
   PutTargetsResult responseTarget = cwe.putTargets(requestTarget);
   
        System.out.println("responseTarget"+responseTarget);
        
       
}
catch(Exception e)
{
    e.printStackTrace();
}
        
    }
    
     public static String createSNSTopic(AmazonSNSClient snsClient) 
 {
    CreateTopicRequest createTopic = new CreateTopicRequest("");
    CreateTopicResult result = snsClient.createTopic(createTopic);
    System.out.println("Create topic request: " + 
        snsClient.getCachedResponseMetadata(createTopic));
    System.out.println("Create topic result: " + result);
    return result.getTopicArn();
 }
 
  public static void subscribeToTopic(AmazonSNSClient snsClient, String topicArn, 
		String protocol, String endpoint) {	
        SubscribeRequest subscribe = new SubscribeRequest(topicArn, protocol,
                                                          endpoint);
        SubscribeResult subscribeResult = snsClient.subscribe(subscribe);
        System.out.println("Subscribe request: " + 
                snsClient.getCachedResponseMetadata(subscribe));
        System.out.println("Subscribe result: " + subscribeResult);
        
        
        
}
    
}
