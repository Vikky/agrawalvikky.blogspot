import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author vikky.agrawal
 *
 */
public class Main {

	public static void main(String ar[])throws Exception{
		/*try{
			new MainTest();//.print();
		}catch(Exception e){
			//can't catch exception in static initializer block.			
			System.out.println("first exception for static block");
		}
		new MainTest();*/
		
	//	new MainTest();

		System.out.println("timemillis : "+System.currentTimeMillis()/1000);

		boolean test = 3600 > System.currentTimeMillis()/1000;
		System.out.println("test : "+test);



		int num =8;

		int count=0;
		while(num%10>0)
		{
			count++;
			num = num/10;
		}
		System.out.print("Digits :"+count+" \\");


		System.out.println("5F:7C:83:AD:FB:FC:4F:6B:12:A5:3E:2A:73:2E:40:BE:27:87:D2:55".replaceAll(":"," "));

		
		String s1="abc";
		String s2="abc";

		int a = s1.charAt(0);
		System.out.println("charAt "+a);



		System.out.println(s1==s2);
		
		
		String s3= new String("abc");
		
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		/*
		//to check how singleton implemented with Runtime java class
		Runtime.getRuntime();
		
		
		//Integer.valueOf(s3);
		
		
		
		int ii=11/2;
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
	        
		System.out.println("after conversion : "+string);*/
		Integer b1 = new Integer(5); 
		int b2 = 5; 
		boolean b =compareObjects(b1, b2);
		System.out.println("B comes out to be :"+b);
		
		
		
		String typeData="{couponID:34,\"travelProductIDs\":[25],\"delete\":false}";
		
		System.out.println("String before conversion :"+typeData);
		
		//typeData=typeData.replaceFirst("[0-9]+", "123");
		
		
		int iterate = 2;
		Long id_EventData[] = new Long[iterate];
		Pattern pattern = Pattern.compile("[-?0-9]+");
		Matcher matcher = pattern.matcher(typeData);

		while (matcher.find() && iterate >0 ) {
			iterate--;
			try{
				id_EventData[iterate] = Long.parseLong(matcher.group());
			}catch(NumberFormatException nfe){
				System.out.println("number format exception occured");
			}
						
		}
		
		for(Long split : id_EventData){
			System.out.println("spliittteedd : "+split);
		}
		
		
		System.out.println("String after conversion : "+typeData);
		
		
	}
	
	
	private static  boolean compareObjects(Object str1, Object str2){
		if ((str1 != null && str2 != null) && (!str1.equals(str2))) {
			return true;
		} else if ((str1 != null && str2 == null)
				|| (str1 == null && str2 != null)) {
			return true;
		}
		return false;
	}
	
	
	
}



class MainTest {	
	
	MainTest()throws Exception{
		
		System.out.println("inside constructor");
		try{
			print();
		}catch(IndexOutOfBoundsException ioe){
			System.out.println("Index exception ");
		}catch(Exception e){
			System.out.println("exception e");
		}
	}
	
	static{		
		System.out.println("static block executing");
		int i=1/0;
	}
	
	public void print()throws Exception{
		System.out.println("insid hello");
		
		
		try{
			throw new Exception();
		}catch(Exception e){
			
			throw new Exception();
			
		}finally{
			
			System.out.println("executing finally?");
			throw new IndexOutOfBoundsException();
			
		}
	
		
	}
	
	
	
}


class A{
	
	public void f1(){
		f2();
	}
	
	public void f2(){
		System.out.println("executing super ");
	}
	
	
}

class B extends A{
	
	public void f2(){
		System.out.println("executing sub class ");
	}
	
	
	
	
}




