package matrix;

/**
 * Given a matrix of integers , make the entire row and column zero when you encounter a zero.
 * https://www.geeksforgeeks.org/a-boolean-matrix-question/
 * <p>
 * Created by viagrawal on 3/10/18.
 */
public class ModifyMatrix
{

	public static void main(String[] args)
	{
		int[][] arr = { { 1, 0, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };
		ModifyMatrix object = new ModifyMatrix();

		System.out.println("Array b4 modification");
		object.printMatrix(arr);

		object.modifyMatrix(arr);

		System.out.println("Array after modification");
		object.printMatrix(arr);

	}

	public void modifyMatrix(int[][] arr)
	{
		boolean row_flag = false;
		boolean col_flag = false;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				if (i == 0 && arr[i][j] == 0)
					row_flag = true;
				if (j == 0 && arr[i][j] == 0)
					col_flag = true;

				if (arr[i][j] == 0)
				{
					arr[0][j] = 0; //first row set to 0
					arr[i][0] = 0; //column
				}
			}
		}

		for (int i = 1; i < arr.length; i++)
		{
			for (int j = 1; j < arr[0].length; j++)
			{
				if (arr[0][j] == 0 || arr[i][0] == 0)
				{
					arr[i][j] = 0;
				}
			}
		}

		if (row_flag)
		{
			for (int i = 0; i < arr[0].length; i++)
			{
				arr[0][i] = 0;
			}
		}
		if (col_flag)
		{
			for (int i = 0; i < arr[0].length; i++)
			{
				arr[i][0] = 0;
			}
		}
	}

	public void printMatrix(int[][] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
}