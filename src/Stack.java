/**
 * 
 */

/**
 * @author vikky.agrawal
 *
 *
 */



class Student{
	
	
	
}
public class Stack {

	/**
	 * @param args
	 */
	
	
	private static int N=-1;
	private int[] arr;
	
	Stack(int size){
		this.arr =new int[size];
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		String str="abc";
		char chr[]=str.toCharArray();
		
		
		
		Stack stack=new Stack(20);
		
		for(int i=0;i<10;i++){
			stack.push((int)(Math.random()*100));
			System.out.println(stack.peek());
		}
		
		
		
		
		String sdtr="Ahssdafdbs";
		float f=10.2f;
		double d=10.2;
		System.out.println(f==d);
				
		System.out.println(20/10%2);
		
		
	}
	
	
	public void push(int data){
		
		if(N==arr.length){
			System.out.println("Not enough space");
			return;
		}
		
		arr[++N]= data;
		
		
	}
	
	
	public int pop(){
		if(N < 0){
			System.out.println("not enough elements");
		}
		
		return arr[N--];
	}
	
	public int peek(){
		return arr[N];
	}
	
	
	
	
	
	public int getNum(char a){
		int flag=0;
		
		switch(a){
			case 'A':
			case 'a':
				flag=1;
				break;
			case 'B':
			case 'b':
				flag=2;
				break;
				
		}
		return flag;
		}
	

}
