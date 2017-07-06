package matrix;

/**
 * Created by viagrawal on 6/24/17.
 */
public class MatrixSpiral
{

	public static void main(String[] args)
	{
		int row = 3;
		int col = 6;
		int arr[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		spiralPrint(row, col, arr);
	}

	public static void spiralPrint(int row, int col, int[][] arr)
	{

		int i, rowCounter = 0, columnCounter = 0;
		/*  rowCounter - starting row index
			row - ending row index
        	columnCounter - starting column index
        	col - ending column index
        	i - iterator
        */

		while (rowCounter < row && columnCounter < col)
		{
			//print row
			for (i = columnCounter; i < col; i++)
			{
				System.out.print(arr[rowCounter][i] + " ");
			}
			rowCounter++; //increment row counter

			//print column
			for (i = rowCounter; i < row; i++)
			{
				System.out.print(arr[i][col - 1] + " ");
			}
			col--; //decrement column

			// Print the last row from the remaining rows */
			if (rowCounter < row)
			{
				for (i = col - 1; i >= columnCounter; i--)
				{
					System.out.print(arr[row - 1][i] + " ");
				}
				row--; //remove row
			}

			// Print the first column from the remaining columns */
			if (columnCounter < col)
			{
				for (i = row - 1; i >= rowCounter; i--)
				{
					System.out.print(arr[i][columnCounter] + " ");
				}
				columnCounter++;
			}
		}
	}
}