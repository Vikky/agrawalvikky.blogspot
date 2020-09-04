package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KingAndQueens
{

	public static void main(String[] args)
	{
		int[][] queenss =
				new int[][] { { 4, 7 }, { 7, 7 }, { 0, 7 }, { 5, 1 }, { 0, 3 }, { 4, 0 }, { 6, 7 }, { 2, 2 }, { 0, 4 },
						{ 6, 4 }, { 6, 5 }, { 3, 5 }, { 4, 6 }, { 6, 1 }, { 3, 1 }, { 0, 6 }, { 2, 0 }, { 4, 3 },
						{ 1, 7 }, { 5, 2 }};
		int[] king = new int[] { 2, 4 };
		queensAttacktheKing(queenss, king);
	}

	/**
	 * 1 <= queens.length <= 63 queens[0].length == 2 0 <= queens[i][j] < 8 king.length == 2 0 <= king[0], king[1] < 8
	 *
	 * @param queens
	 * @param king
	 * @return
	 */

	public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king)
	{

		List<List<Integer>> list = new ArrayList<>();
		int x = king[0];
		int y = king[1];

		int[][] arr = new int[8][8];

		for (int i = 0; i < queens.length; i++)
		{
			arr[queens[i][0]][queens[i][1]] = 1;
		}

		arr[x][y] = 2;
		printMatrix(arr);

		//diagonal
		for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--)
		{
			if (arr[i][j] == 1)
			{
				list.add(Arrays.asList(i, j));
				break;
			}
		}

		for (int i = x - 1; i >= 0; i--)
		{
			if (arr[i][y] == 1)
			{
				list.add(Arrays.asList(i, y));
				break;
			}
		}

		for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++)
		{
			if (arr[i][j] == 1)
			{
				list.add(Arrays.asList(i, j));
				break;
			}
		}

		for (int i = y + 1; i < 8; i++)
		{
			if (arr[x][i] == 1)
			{
				list.add(Arrays.asList(x, i));
				break;
			}
		}

		for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--)
		{
			if (arr[i][j] == 1)
			{
				list.add(Arrays.asList(i, j));
				break;
			}
		}

		for (int i = y - 1; i >= 0; i--)
		{
			if (arr[x][i] == 1)
			{
				list.add(Arrays.asList(x, i));
				break;
			}
		}

		for (int i = x + 1; i < 8; i++)
		{
			if (arr[i][y] == 1)
			{
				list.add(Arrays.asList(i, y));
				break;
			}
		}

		for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++)
		{
			if (arr[i][j] == 1)
			{
				list.add(Arrays.asList(i, j));
				break;
			}
		}

		//[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]

		list.forEach(queen -> {
			System.out.print("[");
			queen.forEach(item -> {
				System.out.print(item + " ");
			});
			System.out.print("]");
		});
		return list;
	}

	//Helper functions:(square matrix)
	private static void printMatrix(int[][] arr)
	{
		int m = arr.length;

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < m; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
}