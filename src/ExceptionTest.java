
public class ExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try{
			new MyException("hello").fun();
			
		}catch(MyException e){
			e.printStackTrace();
		}

	}

}



class MyException extends Exception{
	
	
	MyException(String msg){
		super(msg);
	}
	
	public void fun()throws MyException{
		
		throw new MyException("Custom exception thrown");
		
	}
	
	
	
}
