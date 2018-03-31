package trees;

/**
 * Created by viagrawal on 3/30/18.
 */
public class SumTree
{

	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		SumTree object = new SumTree();
		object.convertSumTree(root);
		//		object.printPreOrder(root);

		object.printInorder(root);

		/* Constructing tree  */
		Node tree = new Node(10);
		tree.left = new Node(-2);
		tree.right = new Node(6);
		tree.left.left = new Node(8);
		tree.left.right = new Node(-4);
		tree.right.left = new Node(7);
		tree.right.right = new Node(5);

		object.convertSumTree(tree);

		// Print inorder traversal of the converted tree to test result
		System.out.println("Inorder Traversal of the resultant tree is:");
		object.printInorder(tree);

	}

	private int convertSumTree(Node root)
	{
		if (root == null)
			return 0;

		int old = root.data;
		root.data = convertSumTree(root.left) + convertSumTree(root.right);
		return root.data + old;
	}

	private void printPreOrder(Node root)
	{
		if (root != null)
		{
			System.out.println(root.data);
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	// A utility function to print inorder traversal of a Binary Tree
	void printInorder(Node node)
	{
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	//DS for tree
	private static class Node
	{
		private int data;
		private Node right, left;

		Node(int data)
		{
			this.data = data;
		}
	}
}