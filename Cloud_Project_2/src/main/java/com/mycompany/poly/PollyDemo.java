/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poly;


import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.model.DescribeVoicesRequest;
import com.amazonaws.services.polly.model.DescribeVoicesResult;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;
import com.amazonaws.services.polly.model.Voice;



public class PollyDemo 
{

    private final AmazonPollyClient polly;
    private final Voice voice;
    SynthesizeSpeechRequest synthReq; 
    
    public InputStream synthesize(String text, OutputFormat format) throws IOException {
		
               
                
               if(text.contains("<speak>"))
               {
                   synthReq = 
		new SynthesizeSpeechRequest().withTextType("ssml").withText(text).withVoiceId(voice.getId())
.withOutputFormat(format);
               }
               else
               {
                    synthReq = 
		new SynthesizeSpeechRequest().withText(text).withVoiceId(voice.getId())
.withOutputFormat(format);
               }
                SynthesizeSpeechResult synthRes = polly.synthesizeSpeech(synthReq);


		return synthRes.getAudioStream();
	}
    
    public PollyDemo(Region region)
    {
    
        
        // create an Amazon Polly client in a specific region
         AWSCredentials credentials = new BasicAWSCredentials(
				"", 
				"");
		polly = new AmazonPollyClient(credentials,new ClientConfiguration());
		polly.setRegion(region);
		// Create describe voices request.
		DescribeVoicesRequest describeVoicesRequest = new DescribeVoicesRequest();//en-IN

               // DescribeVoicesRequest describeVoicesRequestIndian = new DescribeVoicesRequest().withLanguageCode("en-IN");
		// Synchronously ask Amazon Polly to describe available TTS voices.
		DescribeVoicesResult describeVoicesResult = polly.describeVoices(describeVoicesRequest);
		
                
                voice = describeVoicesResult.getVoices().get(0);
                    
                
                
        
                
                
        
    }
    
}
