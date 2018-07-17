package trees;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Created by vikky.agrawal on 6/17/17.
 * <p>
 * Two nodes are cousins of each other if they are at same level and have different parents.
 * Algo:
 * check if same level :yes return true, else false
 * check if different parents : yes return true, else false
 * return true
 */
public class BinaryTreeCousins
{
	public static void main(String[] args)
	{
		BinaryTreeCousins binaryTreeCousins = new BinaryTreeCousins();

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
		root.insertRight(root.right.right, 13);
		root.insertLeft(root.right.right, 14);
		root.insertRight(root.right.right, 15);

		root.printInOrder(root);
		System.out.println();

		final int first = 8, second = 14;
		System.out.println("\nAre " + first + " and " + second + " Cousins ? : " + binaryTreeCousins
				.areCousins(root, first, second));

	}

	public boolean areCousins(final TreeNode root, final int first, final int second)
	{
		if (isNull(root) || (isNull(root.left) || isNull(root.right)))
			return false;

		final Queue<TreeNode> treeNodes = new LinkedList<>();
		putIfNotNull(treeNodes, root.left);
		putIfNotNull(treeNodes, root.right);

		for (int level = 1; level < getHeight(root); level++)
		{
			final Pair<Boolean, Boolean> pair = isCousinExists(treeNodes, first, second);
			if (pair.fst && pair.snd)
				return true;
			if (pair.fst && !pair.snd)
				return false;
			addChildNodes(treeNodes);
		}
		return false;
	}

	private Pair<Boolean, Boolean> isCousinExists(final Queue<TreeNode> queue, final int first, final int second)
	{
		final Queue<TreeNode> treeNodes = new LinkedList<>(queue);
		while (!treeNodes.isEmpty())
		{
			final TreeNode node = treeNodes.poll();
			final TreeNode childWithData = checkIfChildExistsWithData(node, first, second);
			if (nonNull(childWithData))
			{
				final int other = childWithData.data == first ? second : first;
				while (!treeNodes.isEmpty())
				{
					final TreeNode otherNode = checkIfChildExistsWithData(treeNodes.poll(), other, Integer.MAX_VALUE);
					if (nonNull(otherNode))
						return new Pair<>(Boolean.TRUE, Boolean.TRUE);
				}
				/**
				 * Optimizing, Assuming unique keys
				 * at a level if a node is found and second node not found then don't check on other levels.
				 * if not unique keys: then remove below line(the program should work)
				 */
				return new Pair<>(Boolean.TRUE, Boolean.FALSE);
			}
		}
		return new Pair<>(Boolean.FALSE, Boolean.FALSE);
	}

	private TreeNode checkIfChildExistsWithData(final TreeNode node, final int first, final int second)
	{
		if (nonNull(node.left) && (node.left.data == first || node.left.data == second))
			return node.left;
		if (nonNull(node.right) && (node.right.data == first || node.right.data == second))
			return node.right;
		return null;
	}

	private void addChildNodes(Queue<TreeNode> queue)
	{
		final Queue<TreeNode> treeNodeQueue = new LinkedList<>();
		while (!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			putIfNotNull(treeNodeQueue, node.left);
			putIfNotNull(treeNodeQueue, node.right);
		}
		queue.addAll(treeNodeQueue);
	}

	private void putIfNotNull(Queue<TreeNode> queue, TreeNode node)
	{
		if (nonNull(node))
		{
			queue.add(node);
		}
	}

	//Height of binary tree
	private int getHeight(TreeNode root)
	{
		if (root == null)
			return 0;

		return 1 + max(getHeight(root.left), getHeight(root.right));
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

	private static class Pair<A, B>
	{
		public final A fst;
		public final B snd;

		public Pair(A fst, B snd)
		{
			this.fst = fst;
			this.snd = snd;
		}
	}
}
