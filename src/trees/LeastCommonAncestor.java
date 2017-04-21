package trees;

/**
 * Lowest Common Ancestor in a Binary Search Tree.
 *
 * @author vikky.agrawal on 4/21/17.
 */
public class LeastCommonAncestor
{

	//1. Recurse/iterate on left/right sub tree based on root.value
	//2. store subtree till the first & second in array,
	// 		traverse the array and the last common node is LCA

	static class Node
	{
		Node left;
		Node right;
		int value;

		public Node(int value)
		{
			this.value = value;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args)
	{
		Node root = new Node(4);
		System.out.println("Building tree with root value " + root.value);
		insert(root, 2);
		insert(root, 1);
		insert(root, 3);
		insert(root, 6);
		insert(root, 5);
		insert(root, 7);
		insert(root, 8);

		findLCARecursive(root, 5, 8);
		findLCAIterative(root, 5, 8);

	}

	private static Node findLCARecursive(Node root, int first, int second)
	{
		if (root == null)
			return null;

		if (root.value > first && root.value > second)
			return findLCARecursive(root.left, first, second);

		if (root.value < first && root.value < second)
			return findLCARecursive(root.right, first, second);

		System.out.println("LCA is " + root.value);
		return root;
	}

	private static void findLCAIterative(Node root, int first, int second)
	{

		while (root != null)
		{
			if (root.value > first && root.value > second)
			{
				root = root.left;
			}
			else if (root.value < first && root.value < second)
			{
				root = root.right;
			}

			else
			{
				System.out.println("LCA is " + root.value);
				break;
			}
		}
	}

	public static void insert(Node node, int value) {
		if (value < node.value) {
			if (node.left != null) {
				insert(node.left, value);
			} else {
				node.left = new Node(value);
			}
		} else if (value > node.value) {
			if (node.right != null) {
				insert(node.right, value);
			} else {
				node.right = new Node(value);
			}
		}
	}

	public static void printInOrder(Node node)
	{
		if (node != null)
		{
			printInOrder(node.left);
			System.out.println("  Traversed " + node.value);
			printInOrder(node.right);
		}
	}

}
