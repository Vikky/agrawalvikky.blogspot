package dynamicprog;

/**
 * Created by viagrawal on 4/6/18.
 */
public class RectangleSumArray
{

	int ROW = 4;
	int COL = 4;

	public static void main(String[] args)
	{
		RectangleSumArray rectangleSumArray = new RectangleSumArray();

		int matrix[][] = { { 2, 0, -3, 4 }, { 6, 3, 2, -1 }, { 5, 4, 7, 3 }, { 2, -6, 8, 1 } };

		int[][] sumMatrix = rectangleSumArray.buildSumMatrix(matrix);

		System.out.println("Rectangle sum :" + rectangleSumArray.sumQuery(1, 1, 2, 2, sumMatrix));

	}

	public int sumQuery(int row1, int col1, int row2, int col2, int[][] T)
	{
		row1++;
		col1++;
		row2++;
		col2++;
		return T[row2][col2] - T[row1 - 1][col2] - T[row2][col1 - 1] + T[row1 - 1][col1 - 1];
	}

	private int[][] buildSumMatrix(int[][] matrix)
	{
		int[][] T = new int[ROW + 1][COL + 1];

		for (int i = 1; i < ROW + 1; i++)
		{
			for (int j = 1; j < COL + 1; j++)
			{
				T[i][j] = T[i - 1][j] + T[i][j - 1] + matrix[i - 1][j - 1] - T[i - 1][j - 1];
			}
		}
		printMatrix(T, ROW + 1, COL + 1);
		return T;
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
