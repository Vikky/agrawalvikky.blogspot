import java.util.Stack;

/**
 * @author Vikky.Agrawal
 * 
 */
public class TreeTraversal {

	private TreeNode root = new TreeNode(49);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeTraversal treeTraverse = new TreeTraversal();
		treeTraverse.traverse();

	}

	public void traverse() {
		System.out.println("Building tree with root value " + root.getData());
		for (int i = 0; i < 10; i++)
			this.insert(root, (int) (Math.random() * 100));

		
		/*System.out.println("Building tree with root value " + root.getData());
		insert(root, 1);
		insert(root, 8);
		insert(root, 6);
		insert(root, 3);
		insert(root, 9);
		*/
		
		/*System.out.println("recursive in-order traversal: ");
		this.inorder(root);

		System.out.println("Iterative in order traversal: ");
		this.iterativeInOrder(root);
		
		 System.out.println("Recursive post order traversal");
		 this.postOrder(root);
		 System.out.println("Iterative post order traversal: ");
		 this.iterativePostOrder(root);*/
		 
		 System.out.println("Recursive pre order traversal");
		 this.preOrder(root);
		 
		 System.out.println("Iterative pre order traversal: ");
		 this.iterativePreOrder(root);
		 
	}

	
	//BST insertion
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
		
		/* alternate solution
		 * //the criteria to decide when we stop the loop is when current points to null and no nodes in stack
		while(currentNode!=null || !stack.isEmpty())
		{
			//firstly if currentNode is not null, we push currentNode to stack and shift focus to its left sub-tree
			if(currentNode!=null)
			{
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			}
			else//we need pop out nodes from the stack and at that time we shift focus to its right sub-tree
			{
				currentNode = stack.pop();
				System.out.print(currentNode.getData()+", ");//print out as visiting it
				currentNode = currentNode.getRight();
			}
		}
		 */
		
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
				
				//iterate while either right != current node or right is not null, and stack should not be empty
				while(!stack.isEmpty() && (stack.peek().getRight()==currentNode || stack.peek().getRight()==null)){				
					currentNode=stack.pop();
					System.out.println(currentNode.getData());
				}						
				
				if(!stack.isEmpty() ){
					currentNode=stack.peek().getRight();
				}else{
					break;
				}
			
			}
		}
	}
	
	/*
	 * Pre order traversal
	 * Root- left-right
	 */
	
	public void preOrder(TreeNode root){
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

		while(currentNode!=null || !stack.isEmpty())
		{
			//firstly we keep print out each value, store its right sub-tree to stack and shift focus to left sub-tree
			if(currentNode!=null)
			{
				System.out.print(currentNode.getData()+", ");
				stack.push(currentNode.getRight());
				currentNode=currentNode.getLeft();
			}
			else//t==null
			{
				currentNode = stack.pop();
			}
		}

	}
	
	
	
	
	
	/* Reverse order traversal
	 * Right -root -left
	 */
	public void reverseorder(TreeNode root) {
		if (root != null) {
			reverseorder(root.getRight());
			System.out.println(root.getData());
			reverseorder(root.getLeft());
		}
	}
	

}
