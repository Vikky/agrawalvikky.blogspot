package trees;

import static java.lang.Math.max;
import static java.util.Objects.isNull;

/**
 * http://www.techiedelight.com/check-given-binary-tree-is-height-balanced-not/
 * <p>
 * Created by viagrawal on 6/24/17.
 */
public class BinaryTreeHeight
{

	public static void main(String[] args)
	{
		BinaryTreeHeight object = new BinaryTreeHeight();

		final TreeNode root = new TreeNode(1);
		root.insertLeft(root, 2);
		root.insertRight(root, 3);

		root.insertRight(root.left, 4);
		root.insertLeft(root.right, 5);
		root.insertRight(root.right, 6);

		root.insertLeft(root.right.left, 7);
		root.insertRight(root.right.left, 8);

		//		root.insertLeft(root.right.left.left, 9);

		System.out.println("isBalanced : " + object.isBalanced(root));
	}

	public boolean isBalanced(final TreeNode node)
	{
		if (isNull(node))
			return true;

		if (getHeight(node.left) - getHeight(node.right) > 1)
			return false;

		return isBalanced(node.left) && isBalanced(node.right);
	}

	private int getHeight(final TreeNode node)
	{
		if (isNull(node))
			return 0;

		return 1 + max(getHeight(node.left), getHeight(node.right));
	}

	private static class TreeNode
	{
		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data)
		{
			this.data = data;
		}

		public void insertLeft(TreeNode root, int data)
		{
			root.left = new TreeNode(data);
		}

		public void insertRight(TreeNode root, int data)
		{
			root.right = new TreeNode(data);
		}
	}

}
