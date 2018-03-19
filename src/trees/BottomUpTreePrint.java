package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static java.util.Objects.nonNull;

/**
 * http://www.techiedelight.com/print-nodes-binary-tree-specific-order/
 * <p>
 * Created by viagrawal on 3/17/18.
 */
public class BottomUpTreePrint
{

	public static void main(String[] args)
	{

		BottomUpTreePrint object = new BottomUpTreePrint();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);

		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);

		object.printBottomUp(root);

	}

	/**
	 * This function assumes tree to be perfect tree.
	 * Using 2 queues and recording nodes in specific order
	 * at every level in map
	 *
	 * O(n) with extra space O(n)
	 *
	 * @param root
	 */
	private void printBottomUp(Node root)
	{
		if (root == null)
			return;

		Map<Integer, Queue<Integer>> map = new HashMap<>();
		Queue<Node> left = new LinkedList<>();
		Queue<Node> right = new LinkedList<>();

		int level = 0;
		addToMap(map, level, root.data);
		left.add(root.left);
		right.add(root.right);

		while (!left.isEmpty())
		{
			level++;
			int n = left.size(); // it will work for perfect binary tree

			while (n-- > 0)
			{
				Node leftNode = left.poll();
				addToMap(map, level, leftNode.data);
				putIfNotNull(left, leftNode.left);
				putIfNotNull(left, leftNode.right);

				Node rightNode = right.poll();
				addToMap(map, level, rightNode.data);
				putIfNotNull(right, rightNode.right);
				putIfNotNull(right, rightNode.left);
			}
		}

		for (int i = map.size() - 1; i >= 0; i--)
			print(map.get(i));

	}

	private void print(Queue<Integer> queue)
	{
		queue.forEach(data -> System.out.print(data + " "));
	}

	private void putIfNotNull(Queue<Node> queue, Node node)
	{
		if (nonNull(node))
		{
			queue.add(node);
		}
	}

	private void addToMap(Map<Integer, Queue<Integer>> map, int level, int data)
	{
		Queue<Integer> queue;
		if (!map.containsKey(level))
		{
			queue = new LinkedList<>();
			queue.add(data);
			map.put(level, queue);
		}
		else
		{
			queue = map.get(level);
			queue.add(data);
		}
	}

	private static class Node
	{
		int data;
		Node left;
		Node right;

		public Node(final int data)
		{
			this.data = data;
		}
	}
}
