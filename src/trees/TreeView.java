package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print left most node and discard other nodes
 * Created by viagrawal on 3/10/18.
 */
public class TreeView
{

	private static int max_level = 0;

	public static void main(String[] args)
	{
		TreeView object = new TreeView();

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(1);
		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(7);

		TreeNode tree = new TreeNode(12);
		tree.left = new TreeNode(10);
		tree.right = new TreeNode(30);
		tree.right.left = new TreeNode(25);
		tree.right.right = new TreeNode(40);

		object.printLeftView(root);
		object.printLeftViewRecursive(root, 1);
	}

	public void printLeftView(TreeNode root)
	{
		if (root == null)
			return;

		final Queue<TreeNode> queue = new LinkedList<>();
		final Queue<TreeNode> helperQueue = new LinkedList<>();

		queue.add(root);

		while (queue.peek() != null)
		{
			TreeNode ptr = queue.poll();
			System.out.println(ptr.data);
			helperQueue.add(ptr);
			processNodes(queue, helperQueue);
		}
	}

	private void printLeftViewRecursive(TreeNode root, int level)
	{
		if (root == null)
			return;

		if (max_level < level)
		{
			System.out.println(root.data);
			max_level = level;
		}

		printLeftViewRecursive(root.left, level + 1);
		printLeftViewRecursive(root.right, level + 1);
	}

	private void processNodes(final Queue<TreeNode> queue, final Queue<TreeNode> helperQueue)
	{
		while (queue.peek() != null)
		{
			helperQueue.add(queue.poll());
		}
		while (helperQueue.peek() != null)
		{
			TreeNode ptr = helperQueue.poll();
			addIfNotNull(queue, ptr.left);
			addIfNotNull(queue, ptr.right);
		}
	}

	private void addIfNotNull(final Queue<TreeNode> queue, final TreeNode node)
	{
		if (node != null)
			queue.add(node);
	}

	//DS for tree
	private static class TreeNode
	{
		private int data;
		private TreeNode right, left;

		TreeNode(int data)
		{
			this.data = data;
		}
	}
}