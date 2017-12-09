/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mediworld;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ScheduleServlet extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try
        {
    
            
    AWSCredentials awsCredentials = new BasicAWSCredentials("", "");
    final AmazonSNSClient client = new AmazonSNSClient(awsCredentials);
    client.setRegion(Region.getRegion(Regions.US_WEST_1));

    AmazonSNSClient snsClient = new AmazonSNSClient(awsCredentials);
    UserInformation information=new UserInformation();
    
    String userName=null;
    String medicine=null;
    
    String message = "Your reminder for medicine "+medicine+" has been scheduled.You will receive reminder on every 3 hours";
    
    medicine=information.getMedicine(message);
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
    
   /* public static void subscribeToTopic(AmazonSNSClient snsClient, String topicArn, 
		String protocol, String endpoint) {	
        SubscribeRequest subscribe = new SubscribeRequest(topicArn, protocol,
                                                          endpoint);
        SubscribeResult subscribeResult = snsClient.subscribe(subscribe);
        System.out.println("Subscribe request: " + 
                snsClient.getCachedResponseMetadata(subscribe));
        System.out.println("Subscribe result: " + subscribeResult);
}*/
    
public static void sendSMSMessage(AmazonSNSClient snsClient, String message, 
		String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {
        PublishResult result = snsClient.publish(new PublishRequest()
                        .withMessage(message)
                        .withPhoneNumber(phoneNumber)
                        .withMessageAttributes(smsAttributes));
        System.out.println(result); // Prints the message ID.
}
  /*  public static String createSNSTopic(AmazonSNSClient snsClient) {
    CreateTopicRequest createTopic = new CreateTopicRequest("mySNSTopic");
    CreateTopicResult result = snsClient.createTopic(createTopic);
    System.out.println("Create topic request: " + 
        snsClient.getCachedResponseMetadata(createTopic));
    System.out.println("Create topic result: " + result);
    return result.getTopicArn();
}
    
    public static void sendSMSMessageToTopic(AmazonSNSClient snsClient, String topicArn, 
		String message, Map<String, MessageAttributeValue> smsAttributes) {
        PublishResult result = snsClient.publish(new PublishRequest()
                        .withTopicArn(topicArn)
                        .withMessage(message)
                        .withMessageAttributes(smsAttributes));
        System.out.println(result);
}*/
    
}
