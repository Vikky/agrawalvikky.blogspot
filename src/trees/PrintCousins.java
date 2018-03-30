package trees;

/**
 * Created by viagrawal on 3/30/18.
 */
public class PrintCousins
{
	private int currentLevel = 0;

	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);

		root.right.left.left = new Node(12);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);

		PrintCousins object = new PrintCousins();
		Node ptr = new Node(8);
		object.currentLevel = object.getLevel(root, ptr, 0);
		System.out.println("current level of Node " + ptr.data + " : " + object.currentLevel);

		System.out.println("Cousins of Node " + ptr.data + " : ");
		object.printCousins(root, 0, ptr);

	}

	private int getLevel(Node root, Node ptr, int level)
	{
		if (root == null)
			return 0;

		if (root.data == ptr.data)
			return level;

		int leftLevel = getLevel(root.left, ptr, level + 1);
		if (leftLevel != 0)
			return leftLevel;
		return getLevel(root.right, ptr, level + 1);
	}

	private void printCousins(Node root, int level, Node ptr)
	{

		if (root == null)
			return;

		if (level > currentLevel)
			return;

		if (level == currentLevel - 1)
		{
			if (!isNodeParentToPtr(root, ptr))
			{
				printIfNotNull(root.left);
				printIfNotNull(root.right);
			}
		}
		printCousins(root.left, level + 1, ptr);
		printCousins(root.right, level + 1, ptr);
	}

	private void printIfNotNull(final Node node)
	{
		if (node != null)
			System.out.println(node.data);
	}

	private boolean isNodeParentToPtr(final Node root, final Node ptr)
	{
		if (root.left != null && root.left.data == ptr.data)
			return true;

		if (root.right != null && root.right.data == ptr.data)
			return true;
		return false;
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