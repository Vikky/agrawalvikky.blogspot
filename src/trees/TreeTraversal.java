package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.max;
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
		System.out.println("Building tree with root value " + root.data);
		for (int i = 0; i < 7; i++)
			this.insert(root, (int) (Math.random() * 100));

		//		System.out.println("Building tree with root value " + root.data);
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

		System.out.println("\n\nLevel order traversal: recursive  ");
		levelOrderTraverseRecursive(root);

		System.out.println("\n\nLevel order traversal: iterative   ");
		levelOrderTraverse(root);

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
			inorder(root.left);
			System.out.print(root.data + ", ");
			inorder(root.right);
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
			if (root.left == null)
			{
				System.out.print(root.data + ", ");
				root = root.right;
			}
			else
			{
				TreeNode ptr = root.left;

				while (ptr.right != null && ptr.right != root)
					ptr = ptr.right;

				if (ptr.right == null)
				{
					ptr.right = root;
					root = root.left;
				}

				else
				{
					ptr.right = null;
					System.out.print(root.data + ", ");
					root = root.right;
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
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + ", ");

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

			if (currentNode.left != null)
			{
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			else if (currentNode.right != null)
			{
				stack.push(currentNode);
				currentNode = currentNode.right;
			}
			else
			{
				System.out.print(currentNode.data + ", ");

				// iterate while either right != current node or right is not
				// null, and stack should not be empty
				while (!stack.isEmpty() && (stack.peek().right == currentNode || stack.peek().right == null))
				{
					currentNode = stack.pop();
					System.out.print(currentNode.data + ", ");
				}

				if (!stack.isEmpty())
				{
					currentNode = stack.peek().right;
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
			System.out.print(root.data + ", ");
			preOrder(root.left);
			preOrder(root.right);

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
				System.out.print(currentNode.data + ", ");
				stack.push(currentNode.right);
				currentNode = currentNode.left;
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
			reverseorder(root.right);
			System.out.println(root.data);
			reverseorder(root.left);
		}
	}

	/**
	 * Level order traversal of tree : iterative
	 */
	public void levelOrderTraverse(TreeNode root)
	{
		if (isNull(root))
			return;

		final Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode ptr;

		while (!queue.isEmpty())
		{
			ptr = queue.poll();
			System.out.print(ptr.data + ", ");
			pushIfNotNull(queue, ptr.left);
			pushIfNotNull(queue, ptr.right);
		}
	}

	/**
	 * Level order traversal : recursive
	 * http://www.geeksforgeeks.org/level-order-tree-traversal/
	 */
	public void levelOrderTraverseRecursive(TreeNode root)
	{
		for (int level = 0; level < getHeight(root); level++)
		{
			printNodesAtGivenLevel(root, level);
		}
	}

	private void printNodesAtGivenLevel(TreeNode root, int level)
	{
		if (isNull(root))
			return;

		if (level == 0)
		{
			System.out.print(root.data + ", ");
		}
		else
		{
			printNodesAtGivenLevel(root.left, level - 1);
			printNodesAtGivenLevel(root.right, level - 1);
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
		System.out.print(root.data + ",");
		pushIfNotNull(stack, root.right);
		pushIfNotNull(stack, root.left);
		boolean flag = false;

		while (!stack.isEmpty() && stack.size() > 1)
		{
			while (stack.peek() != root)
			{
				auxiliaryQueue.add(stack.pop());
			}
			while (!auxiliaryQueue.isEmpty())
			{
				TreeNode ptr = auxiliaryQueue.poll();
				System.out.print(ptr.data + ", ");
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

	/**
	 * http://www.techiedelight.com/print-nodes-binary-tree-specific-order/
	 * bottom up tree print
	 */
	//TODO
	public void printTreeBottomUp(TreeNode root, Stack<TreeNode> left, Stack<TreeNode> right)
	{
		if (isNull(root))
			return;

		final Stack<TreeNode> stack = new Stack<>();
		final Queue<TreeNode> auxiliaryQueue = new LinkedList<>();
		TreeNode ptr = root;
		stack.push(ptr);
	}

	private void pushIfNotNull(final Stack<TreeNode> stack, final TreeNode node)
	{
		if (nonNull(node))
		{
			stack.push(node);
		}
	}

	private void pushIfNotNull(final Queue<TreeNode> queue, final TreeNode node)
	{
		if (nonNull(node))
		{
			queue.add(node);
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

		Queue<TreeNode> queue = new java.util.LinkedList<>();
		queue.add(root);
		System.out.print(root.data + " , ");
		while (!queue.isEmpty())
		{

			TreeNode node = queue.poll();
			if (node.left != null)
			{
				System.out.print(node.left.data + " , ");
				queue.add(node.left);
			}
			if (node.right != null)
			{
				System.out.print(node.right.data + " , ");
				queue.add(node.right);
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
			System.out.print(node.data + " , ");
			pushIfNotNull(stack, node.right);
			pushIfNotNull(stack, node.left);
		}
	}

	//Height of binary tree
	private int getHeight(TreeNode root)
	{
		if (root == null)
			return 0;

		return 1 + max(getHeight(root.left), getHeight(root.right));
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
			if (val < root.data)
			{
				if (root.left == null)
				{
					System.out.println("inserting left to :" + root.data + " val : " + val);
					root.left = new TreeNode(val);
				}
				else
				{
					insert(root.left, val);
				}
			}
			else
			{
				if (root.right == null)
				{
					System.out.println("inserting right to :" + root.data + " val : " + val);
					root.right = new TreeNode(val);
				}
				else
				{
					insert(root.right, val);
				}
			}
		}
	}

	//DS for tree
	private static class TreeNode
	{
		private int data;
		private TreeNode left,right;

		TreeNode(int data)
		{
			this.data = data;
		}

	}

}
