package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Algo:
 * Add root to queue
 * while queue is not empty
 * 	Peek from queue and print (Top of the queue will always be left most node)
 * 	Poll the nodes and add their childs to queue(left then right)
 */
public class TreeLeftView
{
	public static void main(String[] args)
	{

		Node root = new Node(4);
		root.left = new Node(5);
		root.right = new Node(2);
		root.right.left = new Node(3);
		root.right.right = new Node(1);
		root.right.left.left = new Node(6);
		root.right.left.right = new Node(7);

		TreeLeftView obj = new TreeLeftView();
		obj.printLeftView(root);


	}

	private void printLeftView(Node root)
	{
		if (root == null)
		{
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty())
		{
			System.out.println(queue.peek().data);
			int size = queue.size();

			for (int i = 0; i < size; i++)
			{
				Node ptr = queue.poll();
				addIfNotNull(ptr.left, queue);
				addIfNotNull(ptr.right,queue);
			}
		}
	}

	private void addIfNotNull(final Node ptr, final Queue<Node> queue)
	{
		if (ptr != null)
		{
			queue.add(ptr);
		}
	}

	private static class Node
	{
		Node left, right;
		int data;

		Node(int data)
		{
			this.data = data;
		}
	}

}
