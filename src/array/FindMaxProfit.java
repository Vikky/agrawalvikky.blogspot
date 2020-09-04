package array;

/**
 * Created by viagrawal on 4/21/17.
 */
public class FindMaxProfit
{

	public static void main(String[] args)
	{
		int arr[] = { 100, 80, 260, 310, 40, 535, 695 };
		printMaxProfitPairs(arr);

		int[] anotherArr = { 1, 5, 2, 3, 7, 6, 4, 5 };
		printMaxProfitPairs(anotherArr);

		System.out.println("Max profit : " + maxProfit(anotherArr));

	}

	private static void printMaxProfitPairs(int[] arr)
	{
		final int length = arr.length;
		if (length <= 1)
		{
			System.out.println("Not enough elements to process");
			return;
		}

		int totalProfit = 0;
		for (int i = 0; i < length; )
		{
			int maxSoFar = arr[i];
			int min = arr[i];
			while (++i < length && arr[i] > maxSoFar)
			{
				maxSoFar = arr[i];
			}

			totalProfit += (maxSoFar - min);
			System.out.println("Max profit by buying at : " + min + " And selling at : " + maxSoFar);
		}
		System.out.println("Total profit :" + totalProfit);
	}

	private static int maxProfit(int[] prices)
	{

		int length = prices.length;
		int profit = 0;

		if (length == 0 || length == 1)
			return profit;

		int min = prices[0];
		int max = prices[0];

		for (int i = 1; i < length; i++)
		{
			if (prices[i] > max)
			{
				max = prices[i];
			}
			else
			{
				profit += max - min;
				min = prices[i];
				max = prices[i];
			}
			if (i == length - 1)
			{
				profit += max - min;
			}
		}
		return profit;
	}
}
