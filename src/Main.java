import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author vikky.agrawal
 *
 */
public class Main {

	public static void main(String ar[])throws Exception{
		new MainTest();//.print();
		
		String s1="abc";
		String s2="abc";
		
		System.out.println(s1==s2);
		
		
		String s3= new String("abc");
		
		System.out.println(s1==s3);
		
		
		//to check how singleton implemented with Runtime java class
		Runtime.getRuntime();
		
		
		//Integer.valueOf(s3);
		
		
		
		int ii=1/2;
		System.out.println(ii);
		
			Pattern newspattern = Pattern.compile("([-]+)");
	        Matcher matcher = newspattern.matcher("abc---adasd--dsadbsj--fwfwf");
	        StringBuffer str=new StringBuffer();	     
	        
	       while(matcher.find()){
	    	   matcher.appendReplacement(str, "-");
	       }
	       matcher.appendTail(str); 	
	       System.out.println("After conversion : "+str.toString());
	        
	        
	       String url="abc---adasd--dsadbsj--fwfwf";
	        StringBuffer string =new StringBuffer();
	        String [] arry=url.split("([-]+)");
	        
	        for(int i=0;i<arry.length;i++){
	        	string.append(arry[i]);
	        	if(i+1 < arry.length){
	        		string.append("-");
	        	}
	        }
	        
		System.out.println("after conversion : "+string);
		
		
	}
	
}



class MainTest{	
	
	MainTest(){
		
		System.out.println("inside constructor");
		
	}
	
	static{		
		System.out.println("static block executing");
	}
	
	public void print(){
		System.out.println("insid hello");
	}
	
	
	
	
	
	
	
	
	
}