package misc;

/**
 * @author Vikky.Agrawal
 * Stack operations and solutions to few problems
 */


/*
 * 1. reverse stack in-place (using recursion/using pointers ?)
 * 2. Find min in a stack, if min popped then return 2nd min and so on.
 * 3. reverse stack using recursion --http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * 4  Implement Queue using Stacks -- 
 * 	 http://www.geeksforgeeks.org/the-stock-span-problem/
 */

public class StackImpl {

	Node top =null;	
	
	public static void main(String[] arg){	
		
		StackImpl stack=new StackImpl();
		stack.stackOperations();
		
		
		
		/*
		//Find min implementation
		
		misc.StackImpl stack1=new misc.StackImpl();
		misc.StackImpl stack2=new misc.StackImpl();
		
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
		stack1.printStack();
		stack2.printStack();
		
		//System.out.println("Min element right now is :"+stack2.peek());
		
		for (int i = 1; i < 5; i++) {
			
			int popped=stack1.pop().getData();
			
			System.out.println("Popped element is :"+popped);
			
			if(stack2.peek()== popped){
				stack2.pop();
			}
			
			System.out.println("Next Min element right now is :"+stack2.peek());
			
		}
		
		*/
		
		//Testing Queue functionality
		
		/*misc.QueueUsingStacks queue= new misc.QueueUsingStacks();
		
		for (int i = 1; i < 10; i++) {
			int data=(int) (Math.random() * 100);
			queue.enqueue(data);
		}
		
		System.out.println("Queue from front :");
		queue.printQueueFront(queue.stack1.top);
		
		System.out.println("\nQueue from rear :");
		queue.printQueueRear(queue.stack1.top);
		
		
		System.out.println("\n"+queue.dequeue());
		System.out.println(queue.dequeue());
				
		queue.printQueueRear(queue.stack1.top);
		*/
		
	}
	
	
	public void stackOperations(){
		

		for (int i = 1; i < 10; i++) {
			push((int) (Math.random() * 100));
		}
		
		printStack();
		
		top=this.reverseStack(top);
		System.out.println("Stack after reverse");
		printStack();
		
		
	}
	
	
	
	public Node reverseStack(Node tos){
		
		
		///base case
		if(tos==null || tos.getLink()==null){
			return tos;
		}
		
		
		//point temp to last node and then set link recursively.
		Node temp=reverseStack(tos.getLink());
		
		tos.getLink().setLink(tos);  //a->b->c->null , set b's backward link a<-b<-c;  and set b's forward link as null
		tos.setLink(null);
		
		return temp; //always last node, hence top of reversed Stack
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
		return top == null;
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


/*
 * Queue implementation using Stacks
 */


class QueueUsingStacks{
	
	StackImpl stack1=null;
	StackImpl stack2=null;
	
	QueueUsingStacks(){
		stack1=new StackImpl();
		stack2=new StackImpl();
	}
	
	
	
	public void enqueue(int data){
		stack1.push(data);
		//System.out.println("Enqueue : "+data);
	}
	
	
	public int dequeue(){
		
		if(stack1.top==null){
			System.out.println("Not enough elements");
			return -1;
		}
		
		
		while(stack1.top.getLink()!=null){
			stack2.push(stack1.pop());
		}
		
		int data= stack1.pop();
		

		while(stack2.top!=null){
			stack1.push(stack2.pop());
		}
		return data;
		
	}
	
	public void printQueueFront(StackImpl.Node tos){
		if(tos!=null){
			printQueueFront(tos.getLink());
			System.out.print(tos.getData()+" ");
		}
		
	}
	
	
	public void printQueueRear(StackImpl.Node tos){
		while(tos!=null){
			
			System.out.print(tos.getData()+"->");
			tos=tos.getLink();
		}
		
	}
	
	
}



