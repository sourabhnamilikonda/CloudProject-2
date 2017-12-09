/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sns;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;


public class sns_implementation 
{
     public void setNotificationMethod() {
         try
         {
             System.out.println("in sns");
            AWSCredentials credentials = new BasicAWSCredentials("", "");
            //awsssn credentials
            
            AmazonSNSClient snsClient = new AmazonSNSClient(credentials);                                   
            snsClient.setRegion(Region.getRegion(Regions.US_WEST_1));
           
 
String topicArn = "";
String msgToSubscribers = "file has been downloaded from bucket";
PublishRequest publishRequest = new PublishRequest(topicArn, msgToSubscribers);
PublishResult publishResult = snsClient.publish(publishRequest);
System.out.println("MessageId of the message published to subscribers- " + publishResult.getMessageId());    
    }
    catch(Exception e)
    {
     e.printStackTrace();
    }
    }
    
}
