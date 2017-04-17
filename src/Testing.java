import java.util.Queue;
import java.util.Stack;

/**
 * @author Vikky.Agrawal
 * Implementation of various tree traversals.
 * 
 */
public class Testing {

	private TreeNode root ;

	public Testing() {
		root = new TreeNode(49);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Testing treeTraverse = new Testing();
		treeTraverse.traverse();

	}

	public void traverse() {
		System.out.println("Building tree with root value " + root.getData());
		for (int i = 0; i < 7; i++)
			this.insert(root, (int) (Math.random() * 100));
		
		/*
		 //these lines could be used to build a custom tree while testing.	
		 System.out.println("Building tree with root value " +root.getData()); 
		 insert(root, 1);
		 insert(root, 8); 
		 insert(root, 6);
		 insert(root, 3); 
		 insert(root, 9);
		 */
		 
		 System.out.println("recursive in-order traversal: ");
		 this.inorder(root);
		  
		 System.out.println("Iterative in order traversal: ");
		 this.morrisTraverse(root); 

	}

	
	/*
	 * Recursive in-order traversal
	 */
	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.getLeft());
			System.out.println(root.getData());
			inorder(root.getRight());
		}
	}

	/*
	 * Morris traversal in Java: 
	 * Inorder tree traversal without recursion | Stack.
	 */

	public void morrisTraverse(TreeNode root) {

		while (root != null) {
			if (root.getLeft() == null) {
				System.out.println(root.getData());
				root = root.getRight();
			} else {
				TreeNode ptr = root.getLeft();

				while (ptr.getRight() != null && ptr.getRight() != root)
					ptr = ptr.getRight();

				if (ptr.getRight() == null) {
					ptr.setRight(root);
					root = root.getLeft();
				}

				else {
					ptr.setRight(null);
					System.out.println(root.getData());
					root = root.getRight();
				}
			}
		}
	}
	

	
	//Helper functions for trees.Tree.
	// trees.BST insertion
	public void insert(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
			return;
		} else {
			if (val < root.getData()) {
				if (root.getLeft() == null) {
					System.out.println("inserting left to :" + root.getData()
							+ " val : " + val);
					root.setLeft(new TreeNode(val));
				} else {
					insert(root.getLeft(), val);
				}
			} else {
				if (root.getRight() == null) {
					System.out.println("inserting right to :" + root.getData()
							+ " val : " + val);
					root.setRight(new TreeNode(val));
				} else {
					insert(root.getRight(), val);
				}
			}
		}
	}

	
	//DS for tree
	private static class TreeNode {
    
    private int data;
    private TreeNode right;
    private TreeNode left;   
    
    TreeNode(){}
    
    TreeNode(int data){
        this.setData(data);
        this.setLeft(null);
        this.setRight(null);
    }
    
    public int getData(){
        return this.data;
    }
    
    public TreeNode getRight(){
        return this.right;
    }
    
    public TreeNode getLeft(){
        return this.left;
    }
    
    public void setData(int data){
        this.data=data;
    }
    
    public void setRight(TreeNode right){
        this.right=right;
    }
    
    public void setLeft(TreeNode left){
        this.left=left;
    }  
}
	
	
}
