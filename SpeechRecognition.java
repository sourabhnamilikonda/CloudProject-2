/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poly;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.model.OutputFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/**
 *
 * @author pratik
 */
public class SpeechRecognition extends HttpServlet {


  
    PollyDemo pollyObject;
    InputStream speechStream;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
      String textToRead=request.getParameter("texttoread");
      
     pollyObject = new PollyDemo(Region.getRegion());
      
    welcomeUser(textToRead);
    fileUpload(textToRead);
    fileUpdated(textToRead);
    fileDelete(textToRead);
    fileDownload(textToRead);
    errorWithFileOperation(textToRead);
    reminderSet(textToRead); 
    logOutUser(textToRead);
       
        
        
     
    }
    public void welcomeUser(String user)
    {
        
        String welcome="Welcome "+user;
        
        
        
         try 
         {
             speechStream= pollyObject.synthesize(welcome, OutputFormat.Mp3);    
             
            AdvancedPlayer player = new AdvancedPlayer(speechStream,javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
          
            player.setPlayBackListener(new PlaybackListener() {
			@Override
			public void playbackStarted(PlaybackEvent evt) {
				System.out.println("Playback started");
				
			}
			
			@Override
			public void playbackFinished(PlaybackEvent evt) {
				System.out.println("Playback finished");
			}
		});
		
            
            player.play();
            
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(SpeechRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void fileUpload(String user)
    {
        String welcome="<speak>"+user+" Your files have been uploaded successfully<break time=\"500ms\"/>Please click view files to check your recently uploaded files</speak>";
         try 
         {
             speechStream= pollyObject.synthesize(welcome, OutputFormat.Mp3);    
             
            AdvancedPlayer player = new AdvancedPlayer(speechStream,javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
          
            player.setPlayBackListener(new PlaybackListener() {
			@Override
			public void playbackStarted(PlaybackEvent evt) {
				System.out.println("Playback started");
				
			}
			
			@Override
			public void playbackFinished(PlaybackEvent evt) {
				System.out.println("Playback finished");
			}
		});
		
            
            player.play();
            
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(SpeechRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fileDelete(String user)
    {
        String welcome="<speak>"+user+" Your files have been deleted successfully<break time=\"500ms\"/>Please click view files to check your remaining files</speak>";
         try 
         {
             speechStream= pollyObject.synthesize(welcome, OutputFormat.Mp3);    
             
            AdvancedPlayer player = new AdvancedPlayer(speechStream,javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
          
            player.setPlayBackListener(new PlaybackListener() {
			@Override
			public void playbackStarted(PlaybackEvent evt) {
				System.out.println("Playback started");
				
			}
			
			@Override
			public void playbackFinished(PlaybackEvent evt) {
				System.out.println("Playback finished");
			}
		});
		
            
            player.play();
            
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(SpeechRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fileUpdated(String user)
    {
        String welcome=user+" Your files have been updated successfully";
         try 
         {
             speechStream= pollyObject.synthesize(welcome, OutputFormat.Mp3);    
             
            AdvancedPlayer player = new AdvancedPlayer(speechStream,javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
          
            player.setPlayBackListener(new PlaybackListener() {
			@Override
			public void playbackStarted(PlaybackEvent evt) {
				System.out.println("Playback started");
				
			}
			
			@Override
			public void playbackFinished(PlaybackEvent evt) {
				System.out.println("Playback finished");
			}
		});
		
            
            player.play();
            
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(SpeechRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void fileDownload(String user)
    {
        String welcome=user+" Your files have been downloaded successfully";
         try 
         {
             speechStream= pollyObject.synthesize(welcome, OutputFormat.Mp3);    
             
            AdvancedPlayer player = new AdvancedPlayer(speechStream,javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
          
            player.setPlayBackListener(new PlaybackListener() {
			@Override
			public void playbackStarted(PlaybackEvent evt) {
				System.out.println("Playback started");
				
			}
			
			@Override
			public void playbackFinished(PlaybackEvent evt) {
				System.out.println("Playback finished");
			}
		});
		
            
            player.play();
            
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(SpeechRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    public void errorWithFileOperation(String user)
    {
        String welcome="<speak>"+user+"There is some issue with file operations<break time=\"500ms\"/>Please check this issue with customer care</speak>";
        
        
        
         try 
         {
              
             speechStream= pollyObject.synthesize(welcome, OutputFormat.Mp3);    
             
            AdvancedPlayer player = new AdvancedPlayer(speechStream,javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
          
            player.setPlayBackListener(new PlaybackListener() {
			@Override
			public void playbackStarted(PlaybackEvent evt) {
				System.out.println("Playback started");
				
			}
			
			@Override
			public void playbackFinished(PlaybackEvent evt) {
				System.out.println("Playback finished");
			}
		});
		
            
            player.play();
            
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(SpeechRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
     public void logOutUser(String user)
    {
        String welcome="<speak>Goodbye "+user+" <break time=\"400ms\"/> see you soon</speak>";
        
        
        
         try 
         {
              
             speechStream= pollyObject.synthesize(welcome, OutputFormat.Mp3);    
             
            AdvancedPlayer player = new AdvancedPlayer(speechStream,javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
          
            player.setPlayBackListener(new PlaybackListener() {
			@Override
			public void playbackStarted(PlaybackEvent evt) {
				System.out.println("Playback started");
				
			}
			
			@Override
			public void playbackFinished(PlaybackEvent evt) {
				System.out.println("Playback finished");
			}
		});
		
            
            player.play();
            
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(SpeechRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reminderSet(String user) 
    {
        
        String welcome="<speak>reminder has been set successfully</speak>";
        
        
        
         try 
         {
              
             speechStream= pollyObject.synthesize(welcome, OutputFormat.Mp3);    
             
            AdvancedPlayer player = new AdvancedPlayer(speechStream,javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
          
            player.setPlayBackListener(new PlaybackListener() {
			@Override
			public void playbackStarted(PlaybackEvent evt) {
				System.out.println("Playback started");
				
			}
			
			@Override
			public void playbackFinished(PlaybackEvent evt) {
				System.out.println("Playback finished");
			}
		});
		
            
            player.play();
            
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(SpeechRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
