package trees;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * http://www.techiedelight.com/find-maximum-sum-root-to-leaf-path-binary-tree/
 * <p>
 * Finding max sum in binary tree
 * Created by viagrawal on 6/24/17.
 */
public class BinaryTreeSum
{

	public static void main(String[] args)
	{
		final BinaryTreeSum object = new BinaryTreeSum();

		TreeNode root = new TreeNode(1);
		root.insertLeft(root, 2);
		root.insertRight(root, 3);

		root.insertLeft(root.left, 8);
		root.insertRight(root.left, 4);
		root.insertLeft(root.right, 5);
		root.insertRight(root.right, 6);

		root.insertLeft(root.left.right, 10);
		root.insertLeft(root.right.left, 7);
		root.insertRight(root.right.left, 9);
		root.insertLeft(root.right.right, 5);

		System.out.println("Max sum : " + object.maxSum(root));

		final List<Integer> path = new ArrayList<>();
		object.findPath(root, object.maxSum(root), path);
		System.out.print("Max sum path : ");
		object.printPath(path);
	}

	public int maxSum(final TreeNode node)
	{
		if (isNull(node))
			return 0;

		return node.data + maxOfTwo(maxSum(node.left), maxSum(node.right));
	}

	public boolean findPath(final TreeNode node, final int sum, final List<Integer> path)
	{
		if (isNull(node))
			return false;

		path.add(node.data);

		if (sum - node.data == 0)
			return true;

		if (nonNull(node.left) && findPath(node.left, sum - node.data, path))
			return true;
		if (nonNull(node.right) && findPath(node.right, sum - node.data, path))
			return true;

		path.remove(path.size() - 1);
		return false;

	}

	private int maxOfTwo(final int a, final int b)
	{
		return a > b ? a : b;
	}

	private void printPath(final List<Integer> path)
	{
		path.stream().forEach(node -> System.out.print(node + "->"));
		System.out.println();
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
