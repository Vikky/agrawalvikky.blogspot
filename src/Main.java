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