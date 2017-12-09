package com.db;



import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pojo.DisplayDynamoInformationPojo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class DisplayInformation 
{
     public ArrayList<DisplayDynamoInformationPojo> getDetails(String email) 
     {
         System.out.println("Email:"+email);
         
          ArrayList<DisplayDynamoInformationPojo> arrayList=null;
         try
         {
         
         
        Map<String, String> mapOfString = new HashMap<String, String>();
       

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
// This client will default to US West (Oregon)
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                 .withCredentials(provider)
                .withRegion(Regions.US_EAST_1)
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

//Table table = dynamoDB.getTable("medicine");
        ScanRequest scanRequest = new ScanRequest()
                .withTableName("AppointmentSchedule");
        ScanResult result = client.scan(scanRequest);
        Object[] ks;// = new String[10];
        DisplayDynamoInformationPojo pojo;
        arrayList =new ArrayList<DisplayDynamoInformationPojo>();
        
        System.out.println(result);
        
for (Map<String, AttributeValue> item : result.getItems()) 
        {
            
            System.out.println("for 1st");
            //  System.out.println("item: "+item);
            ks = item.keySet().toArray();
            
            System.out.println("ks:"+ks);
            
            for (int i = 0; i < ks.length; i++) 
            {
                
                System.out.println("for 2nd");
                pojo=new DisplayDynamoInformationPojo();

                if (item.get(ks[i]).toString().contains(email)) 
                {
                    
                    System.out.println("email is:"+email);
                    
                    for (int j = 0; j < ks.length; j++) 
                    {
                       
                       
                        System.out.println("for 3rd");
                        
                       System.out.println(ks[j].toString());
                      
                        
                        if(ks[j].toString().contains("Email"))
                        {
                           
                           System.out.println("if Email"); 
                           String s1=item.get(ks[j]).toString();
                           String s2=s1.substring(s1.indexOf(":")+1,s1.indexOf(",") );
                           System.out.println("emailId "+s2);
                           if(s2!=null)
                           pojo.setEmail(s2);
                        }
                       if(ks[j].toString().contains("Time"))
                        {
                            System.out.println("if Time");
                           String s1=item.get(ks[j]).toString();
                           String s2=s1.substring(s1.indexOf(":")+1,s1.indexOf(",") );
                           System.out.println("Time "+s2);
                           if(s2!=null)
                           pojo.setTime(s2);
                        }
                        if(ks[j].toString().contains("Date"))
                        {
                            System.out.println("if Date");
                           String s1=item.get(ks[j]).toString();
                           String s2=s1.substring(s1.indexOf(":")+1,s1.indexOf(",") );
                           System.out.println("Date "+s2);
                           
                           if(s2!=null)
                           pojo.setDate(s2);   
                           
                           
                           
                        }
                        
                        if(pojo.count==3)
                        {
                         arrayList.add(pojo);
                        }
                        
                       
                    }
                }
                
            }
    
        }
        
        
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         
         System.out.println("arrayList:"+arrayList.size());
         
         return arrayList;
     }

}
