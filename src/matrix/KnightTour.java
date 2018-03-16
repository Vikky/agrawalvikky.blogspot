package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a square chessboard of N x N size, the position of Knight and
 * position of a target is given.
 * We need to find out minimum steps a Knight will take to reach the target position
 * BFS is used to identify min distance between 2 nodes.
 * <p>
 * A knight can move in max 8 possible directions
 * (row-1, col+2) (row+1, col+2) (row+2, col-1) (row-2, col-1)
 * (row-1, col-2) (row+1, col-2) (row+2, col+1) (row-2, col+1)
 * <p>
 * 1.Create an empty queue and enqueue source cell having distance 0 from source (itself)
 * 2. do till queue is not empty
 * a) Pop next unvisited node from queue
 * b) If the popped node is destination node, return its distance
 * c) else we mark current node as visited and for each of 8 possible
 * movements for a knight, we enqueue each valid movement into the queue with +1 distance
 * (min distance of given node from source= min distance of parent from source + 1)
 * <p>
 * <p>
 * Created by viagrawal on 3/15/18.
 */
public class KnightTour
{
	private int size;

	KnightTour(int size)
	{
		this.size = size;
	}

	public static void main(String[] args)
	{

		KnightTour knightTour = new KnightTour(6);
		Node source = new Node(4, 5);
		Node target = new Node(1, 1);

		System.out.println("Min distance from " + source + " to destination " + target + " : " +
				knightTour.getMinDistance(source, target));

	}

	private int getMinDistance(Node source, Node target)
	{
		if (source == null || target == null)
			return -1;
		if (!isValid(source.row, source.column) || !isValid(target.row, target.column))
			return -1;

		Queue<Node> queue = new LinkedList<>();
		source.visited = true;
		queue.add(source);

		while (!queue.isEmpty())
		{
			Node ptr = queue.poll();
			Queue<Node> possibleMoves = getPossibleMoves(ptr, ptr.distance + 1);

			while (!possibleMoves.isEmpty())
			{
				Node temp = possibleMoves.poll();
				if (!temp.visited)
				{
					if (equals(temp, target))
					{
						return temp.distance;
					}
					queue.add(temp);
				}
			}
		}
		System.out.println("not possible ?");
		return -1;
	}

	private boolean equals(final Node temp, final Node target)
	{
		return (temp.row == target.row) && (temp.column == target.column);
	}

	private Queue<Node> getPossibleMoves(Node ptr, final int distance)
	{
		int row = ptr.row;
		int col = ptr.column;

		Queue<Node> queue = new LinkedList<>();

		putIfPossible(queue, row - 1, col + 2, distance);
		putIfPossible(queue, row - 1, col - 2, distance);

		putIfPossible(queue, row + 1, col + 2, distance);
		putIfPossible(queue, row + 1, col - 2, distance);

		putIfPossible(queue, row + 2, col - 1, distance);
		putIfPossible(queue, row + 2, col + 1, distance);

		putIfPossible(queue, row - 2, col - 1, distance);
		putIfPossible(queue, row - 2, col + 1, distance);

		return queue;
	}

	private void putIfPossible(final Queue<Node> queue, final int row, final int column, int distance)
	{
		if (isValid(row, column))
		{
			Node node = new Node(row, column, distance);
//			System.out.println("Adding node " + node + " with distance " + distance);
			queue.add(node);
		}
	}

	private boolean isValid(final int row, final int column)
	{
		if (row >= 0 && column >= 0 && row < size && column < size)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	private static class Node
	{
		int row, column, distance;
		boolean visited;

		Node(int row, int column)
		{
			this.row = row;
			this.column = column;
		}

		Node(int row, int column, int distance)
		{
			this.row = row;
			this.column = column;
			this.distance = distance;
		}

		@Override
		public String toString()
		{
			return "(" + row + "," + column + ")";
		}
	}
}

