package lists;

/**
 * @author Vikky.Agrawal
 * DS to use for Link List
 */
public class LinkNode {

	 private int data;
	 private LinkNode link; 
	 
	    
	    LinkNode(){
	    	    	
	    }
	    
	    LinkNode(int data){
	    	//mergedList=new lists.LinkNode();
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
	    	
}
