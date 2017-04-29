package backtrack;

/**
 * @author vikky.agrawal on 4/22/17.
 */
public class QueenProblem
{

	private static final int numberOfQueens = 4;

	public static void main(String[] args)
	{
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (checkNQueen(board, 0) == false)
		{
			System.out.print("Solution does not exist");
		}
		else
		{
			printSolution(board);
		}
	}

	private static boolean isSafe(int[][] board, int row, int column)
	{
		//Check Row entries before this column
		for (int i = 0; i < column; i++)
		{
			if (board[row][i] == 1)
				return false;
		}

		//check upper diagonal entries
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--)
		{
			if (board[i][j] == 1)
				return false;
		}

		//check lower diagonal entries
		for (int i = column, j = row; i >= 0 && j < column; i--, j++)
		{
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}

	private static boolean checkNQueen(int[][] board, int col)
	{
		//placed queens in columns
		if (col >= numberOfQueens)
			return true;

		for (int i = 0; i < numberOfQueens; i++)
		{
			if (isSafe(board, i, col))
			{
				board[i][col] = 1;

				//Check whether solution exists for next queens
				if (checkNQueen(board, col + 1))
				{
					return true;
				}

				//If no solution exists then backtrack and place in other square.
				board[i][col] = 0;
			}
		}
		/* If queen can not be place in any row in
		   this column, then return false */
		return false;
	}

	private static void printSolution(int board[][])
	{
		for (int i = 0; i < numberOfQueens; i++)
		{
			for (int j = 0; j < numberOfQueens; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}
}
