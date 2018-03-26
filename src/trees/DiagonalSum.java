package trees;

import java.util.*;

/**
 * Created by viagrawal on 3/23/18.
 */
public class DiagonalSum
{

	public static void main(String[] args)
	{
		DiagonalSum object = new DiagonalSum();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(9);
		root.left.right = new Node(6);
		root.right.left = new Node(4);
		root.right.right = new Node(5);

		root.right.left.right = new Node(7);
		root.right.left.left = new Node(12);
		root.left.right.left = new Node(11);
		root.left.left.right = new Node(10);

		object.printDiagonalSum(root);
	}

	private void printDiagonalSum(Node root)
	{
		if (root == null)
			return;

		Queue<Node> current = new LinkedList<>();
		Queue<Node> next = new LinkedList<>();
		Map<Integer, ArrayList<Node>> map = new HashMap<>();
		int level = 0;

		current.add(root);
		Node right =root;
		while (right.right!=null)
		{
			addIfNotNull(current,right.right);
			right=right.right;
		}


		while (!current.isEmpty())
		{
			Node ptr = current.poll();
			addIfNotNull(next, ptr.left);
			if (ptr.left != null)
				addIfNotNull(next, ptr.left.right);

			if (map.get(level) != null)
			{
				map.get(level).add(ptr);
			}
			else
			{
				ArrayList<Node> list = new ArrayList<>();
				list.add(ptr);
				map.put(level, list);
			}
			if (current.isEmpty())
			{
				level++;
				Queue<Node> temp = current;
				current = next;
				next = temp;
			}

		}
		for (int i = 0; i < level; i++)
		{
			if (!map.get(i).isEmpty())
			{
				int levelSum = 0;
				ArrayList<Node> list = map.get(i);
				for (Node node : list)
				{
					levelSum += node.data;
				}
				System.out.println("Sum at level " + i + " is : " + levelSum);
			}
		}

	}

	private void addIfNotNull(final Queue<Node> queue, final Node node)
	{
		if (node != null)
			queue.add(node);
	}

	//DS for tree
	private static class Node
	{
		private int data;
		private Node right, left;

		Node(int data)
		{
			this.data = data;
		}
	}

}
