package trees;

/**
 * Created by viagrawal on 7/6/17.
 */
public class ConstructTree
{

	public static void main(String[] args)
	{

		final ConstructTree constructTree = new ConstructTree();

		int[] preorder = new int[] { 4, 2, 1, 3, 6, 5 };
		int[] inorder = new int[] { 1, 2, 3, 4, 5, 6 };

		int preEnd = preorder.length - 1;
		int inEnd = inorder.length - 1;

		final TreeNode root = constructTree.buildTree(preorder, inorder, 0, preEnd, 0, inEnd);

		System.out.println("Inorder : ");
		constructTree.inOrder(root);
		System.out.println("\nPostorder : ");
		constructTree.postOrder(root);

	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd)
	{
		if (preStart > preEnd || inStart > inEnd)
		{
			return null;
		}

		final int data = preorder[preStart];
		final TreeNode node = new TreeNode(data);

		final int inIndex = findIndex(inorder, data);

		node.left = buildTree(preorder, inorder, preStart + 1, preStart + inIndex - inStart, inStart, inIndex - 1);
		node.right = buildTree(preorder, inorder, (preStart + inIndex - inStart) + 1, preEnd, inIndex + 1, inEnd);
		return node;
	}

	private int findIndex(final int[] inorder, final int data)
	{
		for (int i = 0; i < inorder.length; i++)
		{
			if (inorder[i] == data)
				return i;
		}
		return -1;
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
	 * Recursive in order traversal
	 */

	public void inOrder(TreeNode root)
	{
		if (root != null)
		{
			inOrder(root.left);
			System.out.print(root.data + ", ");
			inOrder(root.right);
		}
	}

	private static class TreeNode
	{
		private TreeNode left;
		private TreeNode right;
		private int data;

		public TreeNode(int data)
		{
			this.data = data;
			left = right = null;
		}

	}

}
