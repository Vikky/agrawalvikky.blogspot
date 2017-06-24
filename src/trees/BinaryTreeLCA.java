package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Binary Tree LCA
 * Distance between 2 nodes in Binary tree
 * Find Path from root in binary tree
 * <p>
 * Created by viagrawal on 6/23/17.
 */
public class BinaryTreeLCA
{

	boolean v1, v2 = false;

	public static void main(String[] args)
	{

		final BinaryTreeLCA object = new BinaryTreeLCA();

		TreeNode root = new TreeNode(1);
		root.insertLeft(root, 2);
		root.insertRight(root, 3);

		root.insertLeft(root.left, 4);
		root.insertRight(root.left, 5);
		root.insertLeft(root.right, 6);
		root.insertRight(root.right, 7);

		root.insertLeft(root.left.left, 8);
		root.insertRight(root.left.left, 9);
		root.insertLeft(root.left.right, 10);
		root.insertRight(root.left.right, 11);

		root.insertLeft(root.right.left, 12);
		root.insertRight(root.right.left, 13);
		root.insertLeft(root.right.right, 14);
		root.insertRight(root.right.right, 15);

		root.printInOrder(root);
		System.out.println();

		int min = 1, max = 15;
		for (int i = 0; i < 10; i++)
		{
			int firstRandom = ThreadLocalRandom.current().nextInt(min, max + 1);
			int secondRandom = ThreadLocalRandom.current().nextInt(min, max + 1);
			final TreeNode first = new TreeNode(firstRandom), second = new TreeNode(secondRandom);
			final TreeNode lca = object.findLCA(root, first, second);
			if (nonNull(lca))
				System.out.println("LCA of " + first.data + " and " + second.data + " is : " + lca.data);

			object.v1= false;
			object.v2 = false;
			final TreeNode lcaNode = object.findLCAUtil(root, firstRandom, secondRandom);
			if (nonNull(lcaNode) && object.v1 && object.v2)
			{
				System.out.println("LCA of " + firstRandom + " and " + secondRandom + " is : " + lcaNode.data);
			}

			System.out.println("Distance b/w " + first.data + " and " + second.data + " : " + object
					.findDistance(root, first, second));
		}

		//Print path from root to node
		final List<TreeNode> path = new ArrayList<>();
		final int node = 14;
		object.findPathFromRoot(root, node, path);
		System.out.println("\nPath from root to node : " + node);
		object.printPath(path);

	}

	public int findDistance(final TreeNode root, final TreeNode firstNode, final TreeNode secondNode)
	{
		if (isNull(root) || isNull(firstNode) || isNull(secondNode))
			return -1;

		final List<TreeNode> firstPath = new ArrayList<>();
		final List<TreeNode> secondPath = new ArrayList<>();
		final List<TreeNode> lcaPath = new ArrayList<>();

		findPathFromRoot(root, firstNode.data, firstPath);
		findPathFromRoot(root, secondNode.data, secondPath);

		int index = 0;
		for (; index < firstPath.size() && index < secondPath.size(); index++)
		{
			if (firstPath.get(index).data != secondPath.get(index).data)
				break;
		}
		final TreeNode lca = firstPath.get(index - 1);
		findPathFromRoot(root, lca.data, lcaPath);

		final int distanceOfFirst = firstPath.size();
		final int distanceOfSecond = secondPath.size();
		final int distanceOfLca = lcaPath.size();

		return distanceOfFirst + distanceOfSecond - (2 * distanceOfLca);
	}

	public TreeNode findLCA(final TreeNode root, final TreeNode first, final TreeNode second)
	{
		if (isNull(root) || isNull(first) || isNull(second))
			return null;

		final List<TreeNode> firstPath = new ArrayList<>();
		final List<TreeNode> secondPath = new ArrayList<>();

		if (!findPathFromRoot(root, first.data, firstPath) || !findPathFromRoot(root, second.data, secondPath))
		{
			final String firstExists = firstPath.size() > 0 ? "exists" : "doesn't exists";
			final String secondExists = secondPath.size() > 0 ? "exists" : "doesn't exists";
			System.out.println("First : " + firstExists);
			System.out.println("Second  : " + secondExists);
			return null;
		}
		int index = 0;
		for (; index < firstPath.size() && index < secondPath.size(); index++)
		{
			if (firstPath.get(index).data != secondPath.get(index).data)
				break;
		}
		return firstPath.get(index - 1);
	}

	private boolean findPathFromRoot(final TreeNode root, final int data, final List<TreeNode> path)
	{
		if (isNull(root))
			return false;

		path.add(root);

		if (root.data == data)
			return true;

		if (nonNull(root.left) && findPathFromRoot(root.left, data, path))
			return true;

		if (nonNull(root.right) && findPathFromRoot(root.right, data, path))
			return true;

		path.remove(path.size() - 1);
		return false;
	}

	TreeNode findLCAUtil(TreeNode node, int n1, int n2)
	{
		// Base case
		if (node == null)
			return null;

		// If either n1 or n2 matches with root's key, report the presence
		// by setting v1 or v2 as true and return root (Note that if a key
		// is ancestor of other, then the ancestor key becomes LCA)
		if (node.data == n1)
		{
			v1 = true;
			return node;
		}
		if (node.data == n2)
		{
			v2 = true;
			return node;
		}

		// Look for keys in left and right subtrees
		TreeNode left_lca = findLCAUtil(node.left, n1, n2);
		TreeNode right_lca = findLCAUtil(node.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (nonNull(left_lca) && nonNull(right_lca))
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (nonNull(left_lca)) ? left_lca : right_lca;
	}

	private void printPath(final List<TreeNode> path)
	{
		path.stream().forEach(node -> System.out.print(node.data + "->"));
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
