package array;

import java.util.stream.IntStream;

/**
 * Created by viagrawal on 3/28/18.
 */
public class EquilibriumIndex
{

	/**
	 * O(n) solution, idea is to keep adding and subtracting current from left and right sum. No extra space required.
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{
		int nums[] = { 0, -3, 5, -4, -2, 3, 1, 0 };
		eqIndex(nums);
	}

	public static void eqIndex(int[] arr)
	{
		int sum = IntStream.of(arr).sum();

		int rightSum = 0;
		int len = arr.length;

		for (int i = len - 1; i >= 0; i--)
		{
			int leftSum = sum - (arr[i] + rightSum);

			if (rightSum == leftSum)
			{
				System.out.println("Eq index at :" + i);
			}
			rightSum += arr[i];
		}
	}

}