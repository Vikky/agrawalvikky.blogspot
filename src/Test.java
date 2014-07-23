/**
 * @author Vikky.Agrawal
 * write a min function for stack, min should return minimum of elements present at the moment in stack.
 * 
 */

public class Test {

	Node top =null;	
	
	public static void main(String[] arg){	
		
			
		//Find min implementation
		
		Test stack1=new Test();
		Test stack2=new Test();
		
		for (int i = 1; i < 10; i++) {
			int data=(int) (Math.random() * 100);
			stack1.push(data);
			
			if(stack2.top==null){
				stack2.push(data);
			}else{
				int temp=stack2.peek();
				if(temp>0 && temp>data){
					stack2.push(data);
				}
			}
			
		}
		System.out.println("Original stack :");
		stack1.printStack();
		
		System.out.println("Auxiliary stack : ");
		stack2.printStack();
		
		//System.out.println("Min element right now is :"+stack2.peek());
		
		for (int i = 1; i < 5; i++) {
			
			int popped=stack1.pop();
			
			System.out.println("Popped element is :"+popped);
			
			if(stack2.peek()== popped){
				stack2.pop();
			}
			
			System.out.println("Next Min element right now is :"+stack2.peek());
			
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
	
	public int pop(){
		if(top==null){
			return -1;
		}else{
			Node temp=top;
			top=top.getLink();
			return temp.getData();
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
		System.out.print("Top->\n");
		while(temp!=null){
			System.out.println(temp.getData()+"\n|");
			temp=temp.getLink();
		}
		System.out.println("/null");
	}
	
	/*
	 * static inner class to be used for Stack Data Structure
	 */
	 static class Node{
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


	
	

