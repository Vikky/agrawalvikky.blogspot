package array;

/**
 * Created by viagrawal on 4/21/17.
 */
public class FindMaxProfit
{

	public static void main(String[] args)
	{
		int arr[] = {100, 80, 260, 310, 40, 535, 695};
		printMaxProfitPairs(arr);

		int[] anotherArr = {1, 5, 2, 3, 7, 6, 4, 5};
		printMaxProfitPairs(anotherArr);

	}

	private static void printMaxProfitPairs(int[] arr)
	{
		final int length = arr.length;
		if (length <= 1)
		{
			System.out.println("Not enough elements to process");
			return;
		}

		int totalProfit =0 ;
		for (int i = 0; i < length; )
		{
			int maxSoFar = arr[i];
			int min = arr[i];
			while (++i < length && arr[i] > maxSoFar){
				maxSoFar =arr[i];
			}

			totalProfit += (maxSoFar - min);
			System.out.println("Max profit by buying at : " + min + " And selling at : " + maxSoFar);
		}
		System.out.println("Total profit :"+totalProfit);
	}
}
