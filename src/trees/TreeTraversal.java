package trees;

import java.util.Queue;
import java.util.Stack;

/**
 * @author vikky.agrawal
 * Implementation of various tree traversals.
 * 
 */
public class TreeTraversal {

	private TreeNode root ;

	public TreeTraversal() {
		root = new TreeNode(49);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeTraversal treeTraverse = new TreeTraversal();
		treeTraverse.traverse();

	}

	public void traverse() {
		System.out.println("Building tree with root value " + root.getData());
		for (int i = 0; i < 7; i++)
			this.insert(root, (int) (Math.random() * 100));

		
		/* System.out.println("Building tree with root value " +root.getData()); 
		 insert(root, 1);
		 insert(root, 8); 
		 insert(root, 6);
		 insert(root, 3); 
		 insert(root, 9);
		 */

		/*
		 System.out.println("recursive in-order traversal: ");
		 this.inorder(root);
		  
		  System.out.println("Iterative in order traversal: ");
		  this.iterativeInOrder(root);
		  
		  System.out.println("Recursive post order traversal");
		  this.postOrder(root);
		  System.out.println("Iterative post order traversal: ");
		  this.iterativePostOrder(root);
		 */

		/*System.out.println("Recursive pre order traversal");
		this.preOrder(root);

		System.out.println("Iterative pre order traversal: ");
		this.iterativePreOrder(root);*/
		
		 System.out.println("BFS traversal : ");
		 this.BFS(root);
		 
		 System.out.println("\nGraphTraversals traversal :");
		 this.DFS(root);
	}

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
	 * Iterative in-order traversal
	 */
	public void iterativeInOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = root;
		while (currentNode != null) {

			if (currentNode.getLeft() != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				System.out.println(currentNode.getData());

				while (currentNode.getRight() == null && !stack.isEmpty()) {
					currentNode = stack.pop();
					System.out.println(currentNode.getData());
				}
				currentNode = currentNode.getRight();
			}
		}

		/*
		 * alternate solution //the criteria to decide when we stop the loop is
		 * when current points to null and no nodes in stack
		  while(currentNode!=null || !stack.isEmpty()) { 
		  //firstly if  currentNode is not null, we push currentNode to stack and shift focus to its left sub-tree 
		  if(currentNode!=null) { stack.push(currentNode);
		  currentNode = currentNode.getLeft(); } 
		  else//we need pop out nodes from the stack and at that time we shift focus to its right sub-tree
		 { currentNode = stack.pop();
		  System.out.print(currentNode.getData()+", ");//print out as visiting it 
		  currentNode = currentNode.getRight(); } 
		  }
		 */

	}

	/*
	 * Morris traversal in Java: 
	 * Inorder tree traversal without recursion.
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

	/*
	 * Recursive post order traversal
	 */

	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.println(root.getData());

		}
	}

	/*
	 * Iterative post order traversal
	 */
	public void iterativePostOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = root;

		while (currentNode != null) {

			if (currentNode.getLeft() != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else if (currentNode.getRight() != null) {
				stack.push(currentNode);
				currentNode = currentNode.getRight();
			} else {
				System.out.println(currentNode.getData());

				// iterate while either right != current node or right is not
				// null, and stack should not be empty
				while (!stack.isEmpty()
						&& (stack.peek().getRight() == currentNode || stack
								.peek().getRight() == null)) {
					currentNode = stack.pop();
					System.out.println(currentNode.getData());
				}

				if (!stack.isEmpty()) {
					currentNode = stack.peek().getRight();
				} else {
					break;
				}

			}
		}
	}

	/*
	 * Pre order traversal Root- left-right
	 */

	public void preOrder(TreeNode root) {
		if (root != null) {
			System.out.println(root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());

		}
	}

	/*
	 * Iterative Pre order traversal
	 */

	public void iterativePreOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = root;

		while (currentNode != null || !stack.isEmpty()) {
			// firstly we keep print out each value, store its right sub-tree to
			// stack and shift focus to left sub-tree
			if (currentNode != null) {
				System.out.print(currentNode.getData() + ", ");
				stack.push(currentNode.getRight());
				currentNode = currentNode.getLeft();
			} else {
				currentNode = stack.pop();
			}
		}

	}

	/*
	 * Reverse order traversal Right -root -left
	 */
	public void reverseorder(TreeNode root) {
		if (root != null) {
			reverseorder(root.getRight());
			System.out.println(root.getData());
			reverseorder(root.getLeft());
		}
	}

	
	/*
	 * Breadth first search tree traversal -- implementation for trees.BST/BT
	 * V= no of vertices, e=no of edges
	 * O(v+e)
	 * if e=v^2 then complexity will be O(v^2) 
	 */
	public void BFS(TreeNode root){
		if(root==null){
			return;
		}
		
		Queue<TreeNode> queue=new java.util.LinkedList<TreeNode>();
		queue.add(root);
		System.out.print(root.getData()+" , ");
		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();
			if (node.getLeft() != null) {
				System.out.print(node.getLeft().getData() + " , ");
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				System.out.print(node.getRight().getData() + " , ");
				queue.add(node.getRight());
			}
		}
	}
	
	
	/*
	 * Depth first search tree traversal(GraphTraversals) -- implementation for trees.BST/BT
	 * V= no of vertices, e=no of edges
	 * O(v+e)
	 * if e=v^2 then complexity will be O(v^2) 
	 */
	
	public void DFS(TreeNode root){
		if(root == null){
			return;
		}
		
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.add(root);		
		
		while(!stack.isEmpty()){
			TreeNode node=stack.pop();
			System.out.print(node.getData()+" , ");
			if(node.getRight()!=null){
				stack.push(node.getRight());
			}
			if(node.getLeft()!=null){
				stack.push(node.getLeft());
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
