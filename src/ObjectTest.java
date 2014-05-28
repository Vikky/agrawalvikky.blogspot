
/**
 * @author vikky.agrawal
 *
 */
public class ObjectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		User user=new User();
		User user1 = new User();
		user.fun(user1);
		System.out.println(user1.i);
		
		
	}

}


class User{
	
	int i=0;
	
	User(){
		
	}
	
	
	public void fun(User user){
		user.i=10;
		
	}
	
	
	
	
}


