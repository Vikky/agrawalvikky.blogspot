package dynamicprog;

import static java.util.Objects.isNull;

/**
 * Longest common sub-sequence
 * <p>
 * Created by vikky.agrawal on 6/28/17.
 */
public class LCS
{
	public static void main(String[] args)
	{
		final LCS object = new LCS();
		object.findLCS("abcdef", "aced");
	}

	//			a b c
	//		  0 0 0 0
	//		a[0 1 1 1 ]
	//		b[0	1 2 2 ]
	public void findLCS(final String first, final String second)
	{
		if (isNull(first) || isNull(second))
			return;

		final char[] firstArray = first.toCharArray();
		final char[] secondArray = second.toCharArray();
		final int colLength = firstArray.length + 1;
		final int rowLength = secondArray.length + 1;

		final int[][] arr = new int[rowLength][colLength];

		for (int row = 1; row < rowLength; row++)
		{
			final char ch1 = secondArray[row - 1];
			for (int col = 1; col < colLength; col++)
			{
				final char ch2 = firstArray[col - 1];
				if (ch1 == ch2)
				{
					arr[row][col] = arr[row - 1][col - 1] + 1;
				}
				else
				{
					arr[row][col] = maxOfTwo(arr[row - 1][col], arr[row][col - 1]);
				}
			}
		}
		printMatrix(arr, rowLength, colLength);
		System.out.println("Longest common sub sequence length : " + arr[rowLength - 1][colLength - 1]);
	}

	public int maxOfTwo(int a, int b)
	{
		return a > b ? a : b;
	}

	//Helper functions:(square matrix)
	public void printMatrix(int[][] arr, int row, int col)
	{
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
}