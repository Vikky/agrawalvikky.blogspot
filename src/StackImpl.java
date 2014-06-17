/**
 * @author Vikky.Agrawal
 * Stack operations and solutions to few problems
 */


/*
 * 1. reverse stack in-place
 * 2. Find min in a stack, if min popped then return 2nd min and so on.
 * 3. reverse stack using recursion --http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * 4 Implement Queue using Stacks
 * 	 http://www.geeksforgeeks.org/the-stock-span-problem/
 */

public class StackImpl {

	Node top =null;	
	Node topmin=null;
	public static void main(String[] arg){	
		
		StackImpl stack=new StackImpl();
		stack.stackOperations();
		
	}
	
	
	public void stackOperations(){
		

		for (int i = 1; i < 10; i++) {
			push((int) (Math.random() * 100));
		}
		
		printStack();
		
	}
	
	
	
	/*
	 *  Find min in a stack, if min popped then return 2nd min and so on.
	 */
	
	
	public void findMin(){
		
		

		for (int i = 1; i < 10; i++) {
			push((int) (Math.random() * 100));
			
		}
		
		
		
		
	}
	
	
	
	/*
	 * Helper functions for stack operations
	 */
	
	public void push(int data){
		if(top==null){
			top=new Node(data);
		}else{
			Node temp=new Node(data);
			temp.setLink(top);
			top=temp;
		}
	}
	
	public Node pop(){
		if(top==null){
			return null;
		}else{
			Node temp=top;
			top=top.getLink();
			return temp;
		}
	}
	
	public int peek(){
		if(top!=null){
			return top.getData();
		}else{
			return -1;
		}
	}
	
	
	public boolean isEmpty(){
		if(top==null)
			return true;
		return false;
	}
	
	
	public int size(){
		int size=0;
		Node temp=top;
		
		while(temp!=null){
			size++;
			temp=temp.getLink();
		}
		return size;
	}
	
	public void printStack(){
		Node temp=top;
		
		while(temp!=null){
			System.out.println(temp.getData()+"\n|");
			temp=temp.getLink();
		}
		System.out.println("/null");
	}
	
	/*
	 * static inner class to be used for Stack Data Structure
	 */
	private static class Node{
		 private int data;
		 private Node link; 		 
		    
		    Node(){
		    	    	
		    }
		    
		    Node(int data){
		    	//mergedList=new Node();
		        this.setData(data);
		        this.setLink(null);       
		    }
		    
		    public int getData(){
		        return this.data;
		    }
		      
		    public Node getLink(){
		        return this.link;
		    }
		    
		    public void setData(int data){
		        this.data=data;
		    }       
		    
		    public void setLink(Node link){
		        this.link=link;
		    }  
	}
	
	
}

