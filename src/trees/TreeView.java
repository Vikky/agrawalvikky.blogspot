package trees;

import java.util.*;

/**
 * Print left most node and discard other nodes
 * Created by viagrawal on 3/10/18.
 */
public class TreeView
{

	private static int max_level = 0;
	private static int max_level_right = 0;

	public static void main(String[] args)
	{
		TreeView object = new TreeView();

		Node root = new Node(4);
		root.left = new Node(5);
		root.right = new Node(2);
		root.right.left = new Node(3);
		root.right.right = new Node(1);
		root.right.left.left = new Node(6);
		root.right.left.right = new Node(7);

		Node tree = new Node(12);
		tree.left = new Node(10);
		tree.right = new Node(30);
		tree.right.left = new Node(25);
		tree.right.right = new Node(40);

		System.out.println("left view iterative");
		object.printLeftView(root);

		System.out.println("\nleft view rec");
		object.printLeftViewRecursive(root, 1);

		System.out.println("\nRight view rec");
		object.printRightViewRecursive(tree, 1);

		System.out.println("\nVertical view");
		object.printVerticalView(getVerticalTree());

		System.out.println("\nTop view");
		object.printTopView(getTopViewTree());

		System.out.println("\nBottom view");
		object.printBottomView(getBottomViewTree());
	}

	public void printLeftView(Node root)
	{
		if (root == null)
			return;

		final Queue<Node> queue = new LinkedList<>();
		final Queue<Node> helperQueue = new LinkedList<>();

		queue.add(root);

		while (queue.peek() != null)
		{
			Node ptr = queue.poll();
			System.out.print(ptr.data + " ");
			helperQueue.add(ptr);
			processNodes(queue, helperQueue);
		}
	}

	private void printLeftViewRecursive(Node root, int level)
	{
		if (root == null)
			return;

		if (max_level < level)
		{
			System.out.print(root.data + " ");
			max_level = level;
		}

		printLeftViewRecursive(root.left, level + 1);
		printLeftViewRecursive(root.right, level + 1);
	}

	private void printRightViewRecursive(Node root, int level)
	{
		if (root == null)
			return;

		if (max_level_right < level)
		{
			System.out.print(root.data + " ");
			max_level_right = level;
		}

		printRightViewRecursive(root.right, level + 1);
		printRightViewRecursive(root.left, level + 1);
	}

	/**
	 * Level order traversal with maintaining level for each node
	 * Store same level nodes in map.
	 *
	 * @param root
	 */
	private void printVerticalView(Node root)
	{
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		Map<Integer, ArrayList<Node>> map = new HashMap<>();
		root.level = 0;
		queue.add(root);

		int min = 0;
		int max = 0;

		while (!queue.isEmpty())
		{
			Node ptr = queue.poll();
			int ptrLevel = ptr.level;
			addIfNotNull(queue, ptr.left, ptrLevel - 1);
			addIfNotNull(queue, ptr.right, ptrLevel + 1);

			if (map.get(ptrLevel) != null)
			{
				map.get(ptrLevel).add(ptr);
			}
			else
			{
				ArrayList<Node> list = new ArrayList<>();
				list.add(ptr);
				map.put(ptrLevel, list);
			}
			min = min > ptrLevel ? ptrLevel : min;
			max = max < ptrLevel ? ptrLevel : max;
		}

		for (int i = min; i <= max; i++)
		{
			map.get(i).forEach(data -> System.out.print(data.data + " "));
		}
	}

	/**
	 * Idea is to do level order traversal with maintaining level for each node
	 * And print the first node at each level.
	 *
	 * @param root
	 */
	private void printTopView(Node root)
	{
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		Map<Integer, Queue<Node>> map = new HashMap<>();
		root.level = 0;
		queue.add(root);

		int min = 0;
		int max = 0;

		while (!queue.isEmpty())
		{
			Node ptr = queue.poll();
			int ptrLevel = ptr.level;
			addIfNotNull(queue, ptr.left, ptrLevel - 1);
			addIfNotNull(queue, ptr.right, ptrLevel + 1);

			if (map.get(ptrLevel) != null)
			{
				map.get(ptrLevel).add(ptr);
			}
			else
			{
				Queue<Node> list = new LinkedList<>();
				list.add(ptr);
				map.put(ptrLevel, list);
			}
			min = min > ptrLevel ? ptrLevel : min;
			max = max < ptrLevel ? ptrLevel : max;
		}

		for (int i = min; i <= max; i++)
		{
			if (!map.get(i).isEmpty())
				System.out.print(map.get(i).poll().data + " ");
		}
	}

	/**
	 * Idea is to do level order traversal with maintaining level for each node
	 * And print the last node at each level.
	 *
	 * @param root
	 */
	private void printBottomView(Node root)
	{
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		root.level = 0;
		queue.add(root);

		int min = 0;
		int max = 0;

		while (!queue.isEmpty())
		{
			Node ptr = queue.poll();
			int ptrLevel = ptr.level;
			addIfNotNull(queue, ptr.left, ptrLevel - 1);
			addIfNotNull(queue, ptr.right, ptrLevel + 1);

			//replace the last node for bottom most

			map.put(ptrLevel, ptr.data);
			min = min > ptrLevel ? ptrLevel : min;
			max = max < ptrLevel ? ptrLevel : max;
		}

		for (int i = min; i <= max; i++)
		{
			System.out.print(map.get(i) + " ");
		}
	}

	private void addIfNotNull(final Queue<Node> queue, final Node node, final int level)
	{
		if (node != null)
		{
			node.level = level;
			queue.add(node);
		}
	}

	private void processNodes(final Queue<Node> queue, final Queue<Node> helperQueue)
	{
		while (queue.peek() != null)
		{
			helperQueue.add(queue.poll());
		}
		while (helperQueue.peek() != null)
		{
			Node ptr = helperQueue.poll();
			addIfNotNull(queue, ptr.left);
			addIfNotNull(queue, ptr.right);
		}
	}

	private void addIfNotNull(final Queue<Node> queue, final Node node)
	{
		if (node != null)
			queue.add(node);
	}

	private static Node getVerticalTree()
	{
		Node tree = new Node(1);
		tree.left = new Node(2);
		tree.right = new Node(3);

		tree.left.left = new Node(4);
		tree.left.right = new Node(5);

		tree.right.left = new Node(6);
		tree.right.right = new Node(7);

		tree.right.left.right = new Node(8);
		tree.right.right.right = new Node(9);

		return tree;
	}

	private static Node getTopViewTree()
	{
		Node tree = new Node(1);
		tree.left = new Node(2);
		tree.right = new Node(3);

		tree.left.right = new Node(4);
		tree.left.right.right = new Node(5);
		tree.left.right.right.right = new Node(6);

		return tree;
	}

	private static Node getBottomViewTree()
	{
		Node tree = new Node(20);
		tree.left = new Node(8);
		tree.right = new Node(22);
		tree.left.left = new Node(5);
		tree.left.right = new Node(3);
		tree.right.left = new Node(4);
		tree.right.right = new Node(25);
		tree.left.right.left = new Node(10);
		tree.left.right.right = new Node(14);

		return tree;
	}

	//DS for tree
	private static class Node
	{
		private int data;
		private Node right, left;
		private int level;

		Node(int data)
		{
			this.data = data;
		}
	}
}