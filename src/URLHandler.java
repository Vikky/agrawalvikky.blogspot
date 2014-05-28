/*import java.io.BufferedReader;
import java.io.InputStreamReader;*/
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
//import java.net.HttpURLConnection;
import java.util.Map;


public class URLHandler {

	
	private static String retrieveCookies(URL url) throws IOException, URISyntaxException 
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
	
	public static void main()throws Exception{
		
		URL til = new URL("https://github.com/");
		String str=retrieveCookies(til);
		System.out.println(str);
		
		
	}
	
	
	public static void main(String arg[])throws Exception{
		
		
		for(int i=0;i<10;i++){
			int var=23511221;			
			var=var-(i*10);
			URL til = new URL("http://timesofindia.indiatimes.com/articleshow/"+var+".cms");
		        URLConnection uc = til.openConnection();
		       		   	        
		        String myCookie = "UserName=vikky.agrawal@indiatimes.co.in;" +
		        		"email:vikky.agrawal@indiatimes.co.in;" +
		        		"_ibeat_session:qz7u3czv64asi7b9;" +
		        		"TicketId:9d7ecbf497474a1f9ae356cb37b01fe0;" +
		        		"MSCSAuth:5dcf5076af07447d8ff2379101745bb17928c5edcd0dd50a";
		        
		       String MSCSAuth="5dcf5076af07447d8ff2379101745bb17928c5edcd0dd50a";
		       
		       String MSCSAuthDetail="DOB=null~Gender=M~Country=null~Email=vikky.agrawal@indiatimes.co.in~FirstName=Vikky~LastName=Agrawal~City=Gurgaon";
		      String MSCSAuthId="7owrpx14qfa4ov3vjvh6h1jem";
		       String UserName="vikky.agrawal@indiatimes.co.in";
		       String email="vikky.agrawal@indiatimes.co.in";
		       String CommLogU="vikky.agrawal@indiatimes.co.in";
		       
		        String cookie=UserName+";"+email+";"+MSCSAuth+";"+MSCSAuthId+";"+MSCSAuthDetail;
		      uc.setRequestProperty("Cookie", cookie); 
		      /*uc.setRequestProperty("UserName", UserName);
		      uc.setRequestProperty("MSCSAuthDetail", MSCSAuthDetail);
		      uc.setRequestProperty("MSCSAuthId", MSCSAuthId);
		      uc.setRequestProperty("email", email);
		      uc.setRequestProperty("CommLogU", CommLogU);*/
		      
		      
		        uc.connect();
		        
		        Runtime rt=Runtime.getRuntime();
		       rt.exec("rundll32 url.dll,FileProtocolHandler " + til);

		        System.out.println("complete");
		}
	
	}
}
