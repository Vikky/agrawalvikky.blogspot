package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author vikky.agrawal
 *         Implementation of various tree traversals.
 */
public class TreeTraversal
{

	private TreeNode root;

	public TreeTraversal()
	{
		root = new TreeNode(49);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TreeTraversal treeTraverse = new TreeTraversal();
		treeTraverse.traverse();

	}

	public void traverse()
	{
		System.out.println("Building tree with root value " + root.getData());
		for (int i = 0; i < 7; i++)
			this.insert(root, (int) (Math.random() * 100));

		//		System.out.println("Building tree with root value " + root.getData());
		//		insert(root, 1);
		//		insert(root, 8);
		//		insert(root, 6);
		//		insert(root, 3);
		//		insert(root, 9);

		System.out.println("\nRecursive in-order traversal: ");
		this.inorder(root);

		System.out.println("\nIterative in-order traversal:  ");
		iterativeInOrder(root);

		System.out.println("\nIterative in-order traversal: using morris traversal :");
		morrisTraverse(root);

		System.out.println("\n\nRecursive post order traversal");
		this.postOrder(root);

		System.out.println("\nIterative post-order traversal:   ");
		this.iterativePostOrder(root);

		System.out.println("\n\nRecursive pre order traversal");
		this.preOrder(root);

		System.out.println("\nIterative pre-order traversal: ");
		this.iterativePreOrder(root);

		System.out.println("\n\nIterative reverse-order traversal:   ");
		iterativeReverseOrder(root);

		System.out.println("\n\nSpiral order traversal :");
		spiralTraversal(root);

		/** Graph traversals **/
		System.out.println("\n\nBFS traversal : ");
		this.BFS(root);

		System.out.println("\nDFS traversal :");
		this.DFS(root);
	}

	/*
	 * Recursive in-order traversal
	 */
	public void inorder(TreeNode root)
	{
		if (root != null)
		{
			inorder(root.getLeft());
			System.out.print(root.getData() + ", ");
			inorder(root.getRight());
		}
	}

	/**
	 * Iterative in-order traversal using stack
	 */
	public void iterativeInOrder(TreeNode root)
	{
		if (isNull(root))
		{
			return;
		}

		final Stack<TreeNode> stack = new Stack<>();
		final TreeNode dummy = new TreeNode(-1);
		stack.push(dummy);
		TreeNode ptr = root;
		while (!stack.isEmpty())
		{
			while (ptr != null)
			{
				stack.push(ptr);
				ptr = ptr.left;
			}
			ptr = stack.pop();
			if (ptr == dummy)
				break;
			System.out.print(ptr.data + ", ");
			ptr = ptr.right;
		}
	}

	/**
	 * Traversing reverse order of tree using {@link Stack}
	 *
	 * @param root
	 */
	public void iterativeReverseOrder(TreeNode root)
	{
		if (isNull(root))
			return;

		//initialize
		Stack<TreeNode> stack = new Stack<>();
		final TreeNode dummy = new TreeNode(-1);
		stack.push(dummy);
		TreeNode ptr = root;
		while (!stack.isEmpty())
		{
			while (ptr != null)
			{
				stack.push(ptr);
				ptr = ptr.right;
			}
			ptr = stack.pop();
			if (ptr == dummy)
				break;
			System.out.print(ptr.data + ", ");
			ptr = ptr.left;
		}
	}

	/**
	 * Morris traversal in Java:
	 * Inorder tree traversal without recursion.
	 */
	public void morrisTraverse(TreeNode root)
	{

		while (root != null)
		{
			if (root.getLeft() == null)
			{
				System.out.print(root.getData() + ", ");
				root = root.getRight();
			}
			else
			{
				TreeNode ptr = root.getLeft();

				while (ptr.getRight() != null && ptr.getRight() != root)
					ptr = ptr.getRight();

				if (ptr.getRight() == null)
				{
					ptr.setRight(root);
					root = root.getLeft();
				}

				else
				{
					ptr.setRight(null);
					System.out.print(root.getData() + ", ");
					root = root.getRight();
				}
			}
		}
	}

	/**
	 * Recursive post order traversal
	 */

	public void postOrder(TreeNode root)
	{
		if (root != null)
		{
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData() + ", ");

		}
	}

	/**
	 * Iterative post order traversal
	 */
	public void iterativePostOrder(TreeNode root)
	{
		if (root == null)
		{
			return;
		}

		final Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = root;

		while (currentNode != null)
		{

			if (currentNode.getLeft() != null)
			{
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			}
			else if (currentNode.getRight() != null)
			{
				stack.push(currentNode);
				currentNode = currentNode.getRight();
			}
			else
			{
				System.out.print(currentNode.getData() + ", ");

				// iterate while either right != current node or right is not
				// null, and stack should not be empty
				while (!stack.isEmpty() && (stack.peek().getRight() == currentNode || stack.peek().getRight() == null))
				{
					currentNode = stack.pop();
					System.out.print(currentNode.getData() + ", ");
				}

				if (!stack.isEmpty())
				{
					currentNode = stack.peek().getRight();
				}
				else
				{
					break;
				}
			}
		}
	}

	/**
	 * Pre order traversal Root- left-right
	 */

	public void preOrder(TreeNode root)
	{
		if (root != null)
		{
			System.out.print(root.getData() + ", ");
			preOrder(root.getLeft());
			preOrder(root.getRight());

		}
	}

	/**
	 * Iterative Pre order traversal
	 */

	public void iterativePreOrder(TreeNode root)
	{
		if (root == null)
		{
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = root;

		while (currentNode != null || !stack.isEmpty())
		{
			// firstly we keep print out each value, store its right sub-tree to
			// stack and shift focus to left sub-tree
			if (currentNode != null)
			{
				System.out.print(currentNode.getData() + ", ");
				stack.push(currentNode.getRight());
				currentNode = currentNode.getLeft();
			}
			else
			{
				currentNode = stack.pop();
			}
		}

	}

	/**
	 * Reverse order traversal Right -root -left
	 */
	public void reverseorder(TreeNode root)
	{
		if (root != null)
		{
			reverseorder(root.getRight());
			System.out.println(root.getData());
			reverseorder(root.getLeft());
		}
	}

	/**
	 * Spiral traversal of BT
	 */

	public void spiralTraversal(TreeNode root)
	{
		if (isNull(root))
			return;

		final Stack<TreeNode> stack = new Stack<>();
		final Queue<TreeNode> auxiliaryQueue = new LinkedList<>();

		stack.push(root);
		System.out.print(root.data+",");
		pushIfNotNull(stack, root.right);
		pushIfNotNull(stack, root.left);
		boolean flag = false;

		while (!stack.isEmpty() && stack.size()>1)
		{
			while (stack.peek() != root)
			{
				auxiliaryQueue.add(stack.pop());
			}
			while (!auxiliaryQueue.isEmpty())
			{
				TreeNode ptr = auxiliaryQueue.poll();
				System.out.print(ptr.data+", ");
				if (flag)
				{
					pushIfNotNull(stack, ptr.right);
					pushIfNotNull(stack, ptr.left);
				}
				else
				{
					pushIfNotNull(stack, ptr.left);
					pushIfNotNull(stack, ptr.right);
				}
			}
			flag = flag ? false : true;
		}

	}

	private void pushIfNotNull(final Stack<TreeNode> stack, final TreeNode node)
	{
		if (nonNull(node))
		{
			stack.push(node);
		}
	}

	/**
	 * Breadth first search tree traversal -- implementation for trees.BST/BT
	 * V= no of vertices, e=no of edges
	 * O(v+e)
	 * if e=v^2 then complexity will be O(v^2)
	 */
	public void BFS(TreeNode root)
	{
		if (root == null)
		{
			return;
		}

		Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
		queue.add(root);
		System.out.print(root.getData() + " , ");
		while (!queue.isEmpty())
		{

			TreeNode node = queue.poll();
			if (node.getLeft() != null)
			{
				System.out.print(node.getLeft().getData() + " , ");
				queue.add(node.getLeft());
			}
			if (node.getRight() != null)
			{
				System.out.print(node.getRight().getData() + " , ");
				queue.add(node.getRight());
			}
		}
	}

	/**
	 * Depth first search tree traversal(GraphTraversals) -- implementation for trees.BST/BT
	 * V= no of vertices, e=no of edges
	 * O(v+e)
	 * if e=v^2 then complexity will be O(v^2)
	 */

	public void DFS(TreeNode root)
	{
		if (root == null)
		{
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);

		while (!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			System.out.print(node.getData() + " , ");
			if (node.getRight() != null)
			{
				stack.push(node.getRight());
			}
			if (node.getLeft() != null)
			{
				stack.push(node.getLeft());
			}
		}
	}

	// trees.BST insertion
	public void insert(TreeNode root, int val)
	{
		if (root == null)
		{
			root = new TreeNode(val);
			return;
		}
		else
		{
			if (val < root.getData())
			{
				if (root.getLeft() == null)
				{
					System.out.println("inserting left to :" + root.getData() + " val : " + val);
					root.setLeft(new TreeNode(val));
				}
				else
				{
					insert(root.getLeft(), val);
				}
			}
			else
			{
				if (root.getRight() == null)
				{
					System.out.println("inserting right to :" + root.getData() + " val : " + val);
					root.setRight(new TreeNode(val));
				}
				else
				{
					insert(root.getRight(), val);
				}
			}
		}
	}

	//DS for tree
	private static class TreeNode
	{

		private int data;
		private TreeNode right;
		private TreeNode left;

		TreeNode(int data)
		{
			this.setData(data);
			this.setLeft(null);
			this.setRight(null);
		}

		public int getData()
		{
			return this.data;
		}

		public TreeNode getRight()
		{
			return this.right;
		}

		public TreeNode getLeft()
		{
			return this.left;
		}

		public void setData(int data)
		{
			this.data = data;
		}

		public void setRight(TreeNode right)
		{
			this.right = right;
		}

		public void setLeft(TreeNode left)
		{
			this.left = left;
		}
	}

}
