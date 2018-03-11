package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.max;
import static java.util.Objects.isNull;

/**
 * Created by viagrawal on 3/11/18.
 */
public class PrintSpiral
{

	public static void main(String[] args)
	{

		PrintSpiral object = new PrintSpiral();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.left.right.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);

		object.printSpiral(root);

		object.levelOrderTraverseRecursive(root);

	}

	private void printSpiral(TreeNode root)
	{
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<>();
		boolean left = true;
		System.out.print(root.data + " ");
		stack.push(root);

		while (!stack.isEmpty())
		{
			while (!stack.isEmpty())
			{
				queue.add(stack.pop());
			}

			while (queue.peek() != null)
			{
				TreeNode ptr = queue.poll();
				if (left)
				{
					addIfNotNull(ptr.left, stack);
					addIfNotNull(ptr.right, stack);
				}
				else
				{
					addIfNotNull(ptr.right, stack);
					addIfNotNull(ptr.left, stack);
				}
			}
			left = !left;
		}
	}

	private void addIfNotNull(final TreeNode node, final Stack<TreeNode> stack)
	{
		if (node != null)
		{
			System.out.print(node.data + " ");
			stack.push(node);
		}
	}

	/**
	 * Level order traversal : recursive
	 * http://www.geeksforgeeks.org/level-order-tree-traversal/
	 * <p>
	 * This is O(n^2) solution.
	 */
	public void levelOrderTraverseRecursive(TreeNode root)
	{
		boolean alternate = true;
		for (int level = 0; level < getHeight(root); level++)
		{
			printNodesAtGivenLevel(root, level, alternate);
			alternate = !alternate;
		}
	}

	private void printNodesAtGivenLevel(TreeNode root, int level, boolean alternate)
	{
		if (isNull(root))
			return;

		if (level == 0)
		{
			System.out.print(root.data + ", ");
		}
		else
		{
			if (alternate)
			{
				printNodesAtGivenLevel(root.left, level - 1, alternate);
				printNodesAtGivenLevel(root.right, level - 1, alternate);
			}
			else
			{
				printNodesAtGivenLevel(root.right, level - 1, alternate);
				printNodesAtGivenLevel(root.left, level - 1, alternate);
			}
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
		TreeNode left, right;
		int data;

		TreeNode(int data)
		{
			this.data = data;
		}
	}
}