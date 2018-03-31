package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary matrix Count the number of islands
 * 0 represents water, and 1 represents land
 * <p>
 * http://www.techiedelight.com/count-the-number-of-islands/
 * <p>
 * Created by viagrawal on 3/31/18.
 */
public class NoOfIslands
{

	int[][] board;

	public static void main(String[] args)
	{
		NoOfIslands nuOfIslands = new NoOfIslands();
		System.out.println("Total islands:" + nuOfIslands.findNumberOfIslands());
	}

	private int findNumberOfIslands()
	{
		board = new int[][] {
				{1, 1, 0, 0, 0},
				{0, 1, 0, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 0, 0, 0},
				{1, 0, 1, 0, 1}
		};
		boolean[][] visited = new boolean[board.length][board[0].length];

		int numberOfIslands = 0;

		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length; col++)
			{
				if (!visited[row][col] && board[row][col] == 1)
				{
					findConnectedNodes(visited, new Node(row, col));
					numberOfIslands++;
				}
			}
		}
		return numberOfIslands;
	}

	private void findConnectedNodes(boolean[][] visited, Node source)
	{
		Queue<Node> queue = new LinkedList<>();
		visited[source.x][source.y] = true;
		queue.add(source);

		while (!queue.isEmpty())
		{
			Node ptr = queue.poll();
			addValidNodes(queue, visited, ptr);
		}

	}

	private void addValidNodes(Queue<Node> queue, final boolean[][] visited, Node ptr)
	{
		int row = ptr.x;
		int col = ptr.y;

		addIfSafe(queue, visited, row, col - 1);
		addIfSafe(queue, visited, row, col + 1);

		addIfSafe(queue, visited, row - 1, col);
		addIfSafe(queue, visited, row - 1, col - 1);
		addIfSafe(queue, visited, row - 1, col + 1);

		addIfSafe(queue, visited, row + 1, col);
		addIfSafe(queue, visited, row + 1, col - 1);
		addIfSafe(queue, visited, row + 1, col + 1);
	}

	private void addIfSafe(final Queue<Node> queue, final boolean[][] visited, final int row, final int col)
	{

		if (isInsideBoard(row, col) && board[row][col] == 1 && !visited[row][col])
		{
			Node node = new Node(row, col);
			visited[row][col] = true;
			queue.add(node);
		}
	}

	private boolean isInsideBoard(final int row, final int col)
	{
		return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
	}

	private static class Node
	{
		int x;
		int y;

		Node(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString()
		{
			return "Node{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}

}
