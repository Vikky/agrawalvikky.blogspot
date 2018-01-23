package trees;

import static java.util.Objects.nonNull;

/**
 * Created by viagrawal on 8/26/17.
 */
public class IsoMorphicTrees
{

	public static void main(String[] args)
	{
		IsoMorphicTrees trees = new IsoMorphicTrees();

		TreeNode root1 = new TreeNode(1);
		root1.insertLeft(root1, 2);
		root1.insertRight(root1, 3);

		root1.insertLeft(root1.left, 4);
		root1.insertRight(root1.left, 5);
		root1.insertLeft(root1.right, 6);

		root1.insertLeft(root1.left.right, 7);
		root1.insertRight(root1.left.right, 8);

		root1.printInOrder(root1);
		System.out.println();

		TreeNode root2 = new TreeNode(1);
		root2.insertLeft(root2, 3);
		root2.insertRight(root2, 2);

		root2.insertRight(root2.left, 6);
		root2.insertLeft(root2.right, 4);
		root2.insertRight(root2.right, 5);

		root2.insertLeft(root2.right.right, 8);
		root2.insertRight(root2.right.right, 7);

		root2.printInOrder(root2);
		System.out.println();

		System.out.println("Are trees isomorphic : " + trees.isIsoMorphic(root1, root2));

	}

	public boolean isIsoMorphic(TreeNode node1, TreeNode node2)
	{
		if (node1 == null && node2 == null)
			return true;

		if (node1 == null || node2 == null)
			return false;

		if (node1.data != node2.data)
			return false;

		return (isIsoMorphic(node1.left, node2.left) && isIsoMorphic(node1.right, node2.right)) || (
				isIsoMorphic(node1.left, node2.right) && isIsoMorphic(node1.right, node2.left));
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

		public void printInOrder(TreeNode root)
		{
			if (nonNull(root))
			{
				printInOrder(root.left);
				System.out.print(root.data + ", ");
				printInOrder(root.right);
			}
		}
	}

}
