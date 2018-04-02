package trees;

import static java.lang.Math.max;

/**
 * Let's calculate the depth of a node in the usual way:
 * max(depth of node.left, depth of node.right) + 1.
 * While we do, a path "through" this node uses 1 + (depth of node.left) + (depth of node.right) nodes.
 * Let's search each node and remember the highest number of nodes used in some path.
 * The desired length is 1 minus this number.
 * <p>
 * Created by viagrawal on 3/31/18.
 */
public class Diameter
{

	public static void main(String[] args)
	{
		Diameter diameter = new Diameter();
		Node tree = new Node(20);
		tree.left = new Node(8);
		tree.right = new Node(22);
		tree.left.left = new Node(5);
		tree.left.right = new Node(3);
		tree.right.left = new Node(4);
		tree.right.right = new Node(25);
		tree.left.right.left = new Node(10);
		tree.left.right.right = new Node(14);

		System.out.println(diameter.findDiameter(tree));
	}

	/**
	 * The diameter of a tree T is the largest of the following quantities:
	 * <p>
	 * the diameter of T’s left subtree
	 * the diameter of T’s right subtree
	 * the longest path between leaves that goes through the root of T
	 * (this can be computed from the heights of the subtrees of T)
	 */

	private int findDiameter(Node root)
	{
		if (root == null)
			return 0;

		int leftDiameter = findDiameter(root.left);
		int rightDiameter = findDiameter(root.right);

		int lh = getHeight(root.left);
		int rh = getHeight(root.right);

		return max(lh + rh + 1, max(leftDiameter, rightDiameter));

	}

	private int getHeight(Node root)
	{
		if (root == null)
			return 0;
		return 1 + max(getHeight(root.left), getHeight(root.right));
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