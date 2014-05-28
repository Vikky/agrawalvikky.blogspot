
public class LinkedList {

	LinkNode node=null;

	public static void main(String[] args) {
		
		LinkedList list=new LinkedList();
		
		list.node=new LinkNode(10);
		
		for(int i=1;i<6;i++){
			list.node.add(list.node, (int)(Math.random()*100));
		}
		
		System.out.println("Before reversal");
		list.node.print(list.node);
		
		list.node.printNthFromLast(list.node, 6);
		
		System.out.println("Print again");
		list.node.print(list.node);
		/*list.node.reverse(list.node);
		System.out.println("After reversal");
		list.node.print(list.node);*/
		
	}

}

class LinkNode{

	 private int data;
	 private LinkNode link;   
	    
	    LinkNode(){}
	    
	    LinkNode(int data){
	        this.setData(data);
	        this.setLink(null);       
	    }
	    
	    public int getData(){
	        return this.data;
	    }
	      
	    public LinkNode getLink(){
	        return this.link;
	    }
	    
	    public void setData(int data){
	        this.data=data;
	    }       
	    
	    public void setLink(LinkNode link){
	        this.link=link;
	    }  
	    
	    
	    public void add(LinkNode ptr, int data){
	    	System.out.println("Coming for addition : "+data);
	    	if(ptr == null){
	    		System.out.println("Always null");
	    		ptr=new LinkNode(data);
	      	}else{
	      		LinkNode newptr=ptr;
	      		while(newptr.link!=null){
	      			newptr=newptr.link;
	      		}
	      		newptr.link=new LinkNode(data);
	      		newptr.link.setLink(null);
	      	}
	    }
	    
	    public void print(LinkNode ptr){
	    	
	    	if(ptr == null){
	    		return;
	    	}
	    	LinkNode ptr1=ptr;
	    	System.out.println(ptr1.getData());
	    	while( (ptr1= ptr1.getLink() )!=null){
	    		System.out.println(ptr1.getData());	    		
	    	}
	    	
	    }
	    
	    
	    
		public int size(LinkNode ptr) {
	
			if (ptr == null) {
				return -1;
			}
			LinkNode ptr1 = ptr;
			int i=1;
			while ((ptr1 = ptr1.getLink()) != null) {
				i++;
			}
			return i;
		}
	    
	    public void reverse(LinkNode ptr){
	    
	    	if(ptr== null){
	    		System.out.println("List is empty:returning");
	    		return;
	    	}
	    	LinkNode ptr1=ptr;
	    	LinkNode ptr2=ptr;
	    	LinkNode ptr3=null;
	    	
	    	
	    	while(ptr1.getLink() != null) {
	    		ptr2=ptr1;
	    		ptr1=ptr1.getLink();
	    		ptr2.setLink(ptr3);
	    		ptr3=ptr2;
	    		
	    	}
	    	ptr1.setLink(ptr2);
	    	 	
	    	System.out.println("Reversed List :");
	    	this.print(ptr1);
	    }
	      
	    
	    public void printNthFromLast(LinkNode root, int n){
	    	
	    	int i=n;
	    	if(root== null ){
	    		return;
	    	}
	    	
	    	if( i > size(root) ){
	    		System.out.println("Not enough elements");
	    		return;
	    	}
	    	
	    	LinkNode node = root;
	    	LinkNode nodeback=root;
	    	
	    	while( (node.getLink() != null ) && (--i > 0)  ){
	    		node=node.getLink();
	    	}
	    	
	    	if(node.getLink() != null){
	    		while(node.getLink()!=null){
	    			nodeback=nodeback.getLink();
	    			node=node.getLink();
	    		}	    		
	    	}
	    		
	    	System.out.println("N = "+n+" element from last is :"+nodeback.getData());
	    	
	    	
	    }
	    
	    
	}
