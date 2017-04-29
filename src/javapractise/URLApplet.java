package javapractise;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class URLApplet extends Applet implements ActionListener {

	 public void paint (Graphics g)
	 {
		 
		 try{
			 g.drawString ("Hello World", 25, 50);
			 
			 Button b=new Button("Open connection");
			 b.addActionListener(this);
			 this.add(b);
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	 
	 
	 
	 public void actionPerformed(ActionEvent e) {
		 for(int i=0;i<10;i++){
				
				URL til;
				  URLConnection uc =null;
				try {
					til = new URL("http://timesofindia.indiatimes.com");
					 uc= til.openConnection();
					 
					 String str=retrieveCookies(til);
					 System.out.println(str);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			     
					
			        
			       String MSCSAuth="5dcf5076af07447d8ff2379101745bb17928c5edcd0dd50a";
			       
			       String MSCSAuthDetail="DOB=null~Gender=M~Country=null~Email=vikky.agrawal@indiatimes.co.in~FirstName=Vikky~LastName=Agrawal~City=Gurgaon";
			      String MSCSAuthId="7owrpx14qfa4ov3vjvh6h1jem";
			       String UserName="vikky.agrawal@indiatimes.co.in";
			       String email="vikky.agrawal@indiatimes.co.in";
			       String CommLogU="vikky.agrawal@indiatimes.co.in";
			       
			        String cookie=UserName+";"+email+";"+MSCSAuth+";"+MSCSAuthId+";"+MSCSAuthDetail;
			    
			      /*uc.setRequestProperty("UserName", UserName);
			      uc.setRequestProperty("MSCSAuthDetail", MSCSAuthDetail);
			      uc.setRequestProperty("MSCSAuthId", MSCSAuthId);
			      uc.setRequestProperty("email", email);
			      uc.setRequestProperty("CommLogU", CommLogU);*/
			      
			      
			        try {  
			        	uc.setRequestProperty("Cookie", cookie); 			        	
						uc.connect();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			        
			        
			        try {
			            AppletContext a = getAppletContext();
			            URL url = new URL("http://timesofindia.indiatimes.com");
			            a.showDocument(url,"_blank");
			         }
			         catch (MalformedURLException e1){
			            System.out.println(e1.getMessage());
			         }
			        
			        
			        
			        Runtime rt=Runtime.getRuntime();
					//rt.exec("rundll32 url.dll,FileProtocolHandler " + til);
			        
			        
			        
			        System.out.println("complete");
		 }	
		 
	 }
	 
	 private  String retrieveCookies(URL url) throws IOException, URISyntaxException 
		{ 
		     String cookieValue = null;

		     CookieHandler handler = CookieHandler.getDefault();
		     if (handler != null)    {
		          Map<String, List<String>> headers = handler.get(url.toURI(), new HashMap<String, List<String>>());

		          List<String> cookiesList = headers.get("Cookie");
		          if (cookiesList != null)
		          {
		              for (String v : cookiesList) {
		                  if (cookieValue == null) 
		                      cookieValue = v; 
		                  else
		                      cookieValue = cookieValue + ";" + v; 
		              }
		          }
		     } 
		     return cookieValue; 
		}
	 
	 
	
}
