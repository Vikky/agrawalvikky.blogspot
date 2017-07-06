package dynamicprog;

/**
 * 0/1 knapsack problem
 * Created by vikky.agrawal on 6/28/17.
 */
public class KnapSack
{

	public static void main(String[] args)
	{
		final KnapSack knapSack = new KnapSack();

		final int totalWt = 7;
		final int[][] weights = new int[][] { { 1, 1 }, { 3, 4 }, { 4, 5 }, { 5, 7 } };

		//		  0 1
		//		0[1,1]
		//		1[3,4]
		//		2[4,5]
		//		3[5,7]

		knapSack.findWeights(7, weights);

	}

	public void findWeights(final int totalWt, final int[][] weights)
	{

		final int rowLength = weights.length + 1;
		final int colLength = totalWt + 1;
		final int[][] arr = new int[rowLength][colLength];
		for (int row = 1; row < rowLength; row++)
		{
			final int weight = weights[row - 1][0];
			final int value = weights[row - 1][1];

			for (int col = 1; col < colLength; col++)
			{
				if (col < weight)
				{
					arr[row][col] = arr[row - 1][col];
				}
				else
				{
					arr[row][col] = max(value + arr[row - 1][col - weight], arr[row - 1][col]);
				}
			}
		}
		printMatrix(arr, rowLength, colLength);
	}

	public int max(int a, int b)
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
