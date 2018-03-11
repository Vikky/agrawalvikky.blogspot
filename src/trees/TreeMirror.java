package trees;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by viagrawal on 3/10/18.
 */
public class TreeMirror
{
	public static void main(String[] args)
	{
		TreeMirror object = new TreeMirror();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(4);

		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);

		System.out.println(object.checkIfMirror(root, tree));
	}

	public boolean checkIfMirror(TreeNode first, TreeNode second)
	{
		if (first == null && second == null)
			return TRUE;

		if (first == null || second == null)
			return FALSE;

		return first.data == second.data &&
				checkIfMirror(first.left, second.right) &&
				checkIfMirror(first.right, second.left);
	}

	//DS for tree
	private static class TreeNode
	{
		private int data;
		private TreeNode left, right;

		TreeNode(int data)
		{
			this.data = data;
		}
	}
}