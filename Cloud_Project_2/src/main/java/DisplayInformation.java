
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
                .withRegion(Regions.US_WEST_1)
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

//Table table = dynamoDB.getTable("medicine");
        ScanRequest scanRequest = new ScanRequest()
                .withTableName("appointschedule");
        ScanResult result = client.scan(scanRequest);
        Object[] ks;// = new String[10];
        
arrayList       =new ArrayList<DisplayDynamoInformationPojo>();
        for (Map<String, AttributeValue> item : result.getItems()) {
            System.out.println("new record");
            //  System.out.println("item: "+item);
            ks = item.keySet().toArray();
            
            System.err.println("");
            
            for (int i = 0; i < ks.length; i++) 
            {
               String s= item.get(ks[i]).toString();

                if (s.contains(email)) 
                {
                    for (int j = 0; j < ks.length; j++) 
                    {
                        DisplayDynamoInformationPojo pojo=new DisplayDynamoInformationPojo();
                       // System.out.println("ks " + ks[j]);
                       // System.out.println("ks val: " + item.get(ks[j]).toString());
                        System.out.println(ks[j].toString() + "\t" + item.get(ks[j]).toString());
                        
                        if(ks[j].toString().contains("emailId"))
                        {
                           String s1=item.get(ks[j]).toString();
                           String s2=s1.substring(s1.indexOf(":"),s1.indexOf(",") );
                           System.out.println("emailId "+s2);
                           pojo.setEmail(s2);
                        }
                        else if(ks[j].toString().contains("Time"))
                        {
                           String s1=item.get(ks[j]).toString();
                           String s2=s1.substring(s1.indexOf(":"),s1.indexOf(",") );
                           System.out.println("Time "+s2);
                           pojo.setTime(s2);
                        }
                        else if(ks[j].toString().contains("Date"))
                        {
                           String s1=item.get(ks[j]).toString();
                           String s2=s1.substring(s1.indexOf(":"),s1.indexOf(",") );
                           System.out.println("Date "+s2);
                           pojo.setDate(s2);    
                        }
                        arrayList.add(pojo);
                    }
                }
            }
       //     break;
            //  System.out.println("l: "+ks.length);
        }
        
        
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return arrayList;
     }

}
