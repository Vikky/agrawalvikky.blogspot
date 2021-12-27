package trees.bst;

/**
 * @author vikky.agrawal
 */

public class VerifyBST
{
	private TreeNode root;

	public VerifyBST()
	{
		root = new TreeNode(4);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		VerifyBST obj = new VerifyBST();
		obj.operate();
	}

	public void operate()
	{

		// let's construct a random binary tree
		// 4
		// 2 6
		// 1 3 5 7
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(6));
		root.getLeft().setLeft(new TreeNode(1));
		root.getLeft().setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(5));
		root.getRight().setRight(new TreeNode(7));

		// test by changing values
		root.getLeft().setRight(new TreeNode(6));

		inorder(root);
		System.out.println("Whether this tree is trees.BST? :  " + checkIfBST(root, null, null));
	}

	// Duplicates are not handled in given function.
	public boolean checkIfBST(TreeNode root, Integer min, Integer max)
	{
		if (root == null)
			return true;

		if(min!=null && root.data<=min || max!=null && root.data >=max)
			return false;

		return  checkIfBST(root.getLeft(), min, root.getData())
				&& checkIfBST(root.getRight(), root.getData(), max);
	}

	// Helper functions for tree

	/**
	 * Recursive in-order traversal
	 */
	public void inorder(TreeNode root)
	{
		if (root != null)
		{
			inorder(root.getLeft());
			System.out.println(root.getData());
			inorder(root.getRight());
		}
	}

	// DS for tree
	static class TreeNode
	{

		private int data;
		private TreeNode right;
		private TreeNode left;

		TreeNode()
		{
		}

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
