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
import java.util.HashMap;
import java.util.Map;


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
    
}
