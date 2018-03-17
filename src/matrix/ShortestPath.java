package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by viagrawal on 6/17/17.
 * Given a maze in the form of the binary rectangular matrix,
 * find length of the shortest path in a maze from given source to given destination.
 * Moves are possibles if index element is 1
 * <p>
 * Shortest path in a Maze | Lee algorithm
 */
public class ShortestPath
{

	private int ROW;
	private int COLUMN;
	private static final int[][] maze =
			{ { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
					{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
					{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

	ShortestPath()
	{
		this.ROW = maze.length;
		this.COLUMN = maze[0].length;
	}

	public static void main(String[] args)
	{
		ShortestPath object = new ShortestPath();

		Node source = new Node(0, 0);
		Node target = new Node(3, 4);

		System.out.println("Min distance from " + source + " to destination " + target + " : " +
				object.getShortestPath(source, target));

	}

	private int getShortestPath(Node source, Node target)
	{
		if (source == null || target == null)
			return -1;

		Queue<Node> queue = new LinkedList<>();
		queue.add(source);

		while (!queue.isEmpty())
		{
			final Node ptr = queue.poll();
			ptr.visited =true;
			final Queue<Node> possibleMoves = getPossibleMoves(ptr, ptr.distance + 1);
			while (!possibleMoves.isEmpty())
			{
				final Node temp = possibleMoves.poll();
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

		putIfPossible(queue, row + 1, col, distance);
		putIfPossible(queue, row - 1, col, distance);

		putIfPossible(queue, row, col + 1, distance);
		putIfPossible(queue, row, col - 1, distance);

		return queue;
	}

	private void putIfPossible(final Queue<Node> queue, final int row, final int column, int distance)
	{
		if (isValid(row, column))
		{
			Node node = new Node(row, column, distance);
			queue.add(node);
		}
	}

	private boolean isValid(final int row, final int column)
	{
		if (row >= 0 && column >= 0 && row < ROW && column < COLUMN && maze[row][column] == 1)
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
