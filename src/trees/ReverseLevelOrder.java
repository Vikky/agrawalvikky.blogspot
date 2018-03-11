package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 *
 * Created by viagrawal on 3/11/18.
 */
public class ReverseLevelOrder
{
	private static final Stack<TreeNode> stack = new Stack<>();

	public static void main(String[] args)
	{
		final ReverseLevelOrder object = new ReverseLevelOrder();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		object.reverseLevelOrderTraverse(root);

		while (!stack.isEmpty())
			System.out.print(stack.pop().data + " ");
	}

	/**
	 * Reverse level order traversal of tree : iterative
	 */
	public void reverseLevelOrderTraverse(TreeNode root)
	{
		if (isNull(root))
			return;

		final Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty())
		{
			TreeNode ptr = queue.poll();
			stack.push(ptr);
			addIfNotNull(queue, ptr.right);
			addIfNotNull(queue, ptr.left);
		}
	}

	private void addIfNotNull(final Queue<TreeNode> queue, final TreeNode node)
	{
		if (nonNull(node))
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
