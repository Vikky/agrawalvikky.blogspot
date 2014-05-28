
public class Tree {

	public static void main(String[] args) {
	    new Tree().run();
	  }
	 
	  static class Node {
	    Node left;
	    Node right;
	    int value;
	 
	    public Node(int value) {
	      this.value = value;
	    }
	  }
	 
	  public void run() {
	    // build the simple tree from chapter 11.
	    Node root = new Node(5);
	    System.out.println("Binary Tree Example");
	    System.out.println("Building tree with root value " + root.value);
	    insert(root, 1);
	    insert(root, 8);
	    insert(root, 6);
	    insert(root, 3);
	    insert(root, 9);
	    System.out.println("Traversing tree in order");
	    printInOrder(root);
	    System.out.println("root = "+root.value);
	   System.out.println("LCA : "+LCA(root,1,3) );
	  }
	 
	  public void insert(Node node, int value) {
	    if (value < node.value) {
	      if (node.left != null) {
	        insert(node.left, value);
	      } else {
	        System.out.println("  Inserted " + value + " to left of "
	            + node.value);
	        node.left = new Node(value);
	      }
	    } else if (value > node.value) {
	      if (node.right != null) {
	        insert(node.right, value);
	      } else {
	        System.out.println("  Inserted " + value + " to right of "
	            + node.value);
	        node.right = new Node(value);
	      }
	    }
	  }
	 
	  public void printInOrder(Node node) {
	    if (node != null) {
	      printInOrder(node.left);
	      System.out.println("  Traversed " + node.value);
	      printInOrder(node.right);
	    }
	  }
	  
	  
	  public int findMaxInTree(Node node){
		 Node ptr=node;
		  
		  if(node == null){
			  return -1;
		  }
		  while(ptr.right != null){
			  ptr=ptr.right;
		  }
		  return ptr.value;
		  
	  }
	  
	  public int findMinInTree(Node node){
			 Node ptr=node;
			  
			  if(node == null){
				  return -1;
			  }
			  while(ptr.left != null){
				  ptr=ptr.left;
			  }
			  return ptr.value;
			  
		  }
	  
	  
	  
	  public int LCA(Node node,int a,int b){
		  
		  if(  (node== null )  || ( a < this.findMinInTree(node) ) ||  (b> this.findMaxInTree(node)) ){
			  return -1;
		  }else{
			  return this.LCAutil(node,a,b);
		  }
	 
	  }
	  
	  
	  public int LCAutil(Node node,int a,int b){
		  if(node == null){
			  System.out.println("root is coming as null");
			  return -1;
		  }
		  
		  if( (node.value >= a && node.value <= b ) ){
			  if( findNodes(node, a) && findNodes(node, b) ){
				  return node.value;
			  }
			  else{
				  return -1;
			  }
		  }
		
		  if(node.value > a && node.value > b){
			  System.out.println("traverse left");
			  return LCA(node.left,a,b);
		  }else{
			  System.out.println("traverse right");
			  return LCA(node.right,a,b);
		  }
		   
	  }
	  
	  public boolean findNodes(Node node,int a){
		  if(node ==null){
			  //System.out.println("null node return false");
			  return false;
		  }
		  System.out.println(node.value);
		  if(node.value == a){
			  return true;
		  }else{
			  if(node.value < a){
				  return findNodes(node.left, a);
			  }else{
				  return findNodes(node.right, a);
			  }
				  
		  } 
		 
	  }

	public void add(Tree tree, int i) {
		// TODO Auto-generated method stub
		
	}
	
}
