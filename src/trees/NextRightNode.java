package trees;

/**
 * Given a Binary tree and a key in the binary tree, find the node right to the given key.
 * If there is no node on right side, then return NULL.
 * Expected time complexity is O(n) where n is the number of nodes in the given binary tree.
 * <p>
 * <p>
 * Approach 1:
 * Using level order traversal return next node in queue at any level,
 * if there is no element in queue return null
 * <p>
 * Approach 2:
 * Do preorder traversal and set counter when node is encountered with given key.
 * While backtracking return first node with counter value.
 * <p>
 * Created by viagrawal on 3/30/18.
 */
public class NextRightNode
{

	private int current_level = -1;

	public static void main(String[] args)
	{

		NextRightNode nextRightNode = new NextRightNode();

		Node root = new Node(4);
		root.left = new Node(5);
		root.right = new Node(2);

		root.left.left = new Node(8);
		root.left.right = new Node(9);
		root.right.left = new Node(3);
		root.right.right = new Node(1);

		root.right.left.left = new Node(6);
		root.right.left.right = new Node(7);

		for (int i = 1; i < 10; i++)
		{
			nextRightNode.current_level = -1;
			Node node = nextRightNode.preOrder(root, 0, i);
			System.out.print("Right key of " + i + " :");
			if (node != null)
				System.out.println(node.data);
			else
				System.out.println("null");
		}

	}

	private Node preOrder(Node root, int level, int key)
	{
		if (root == null)
			return null;

		if (root.data == key)
		{
			current_level = level;
			return null;
		}

		//if current_level set and level is equal to current level, we found next node.
		if (current_level != -1 && level == current_level)
			return root;

		Node ptr = preOrder(root.left, level + 1, key);

		if (ptr != null)
			return ptr;

		return preOrder(root.right, level + 1, key);
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