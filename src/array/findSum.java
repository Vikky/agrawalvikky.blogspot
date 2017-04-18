package array;

/**
 * Program to find whether sum of 2 numbers equals to a given no in an
 * array
 *
 * @author vikky.agrawal
 */
public class findSum
{

	public static void main(String arg[])
	{
		findSum obj = new findSum();
		int sum = 108;
		System.out.println("whether sum: " + sum + " exists :" + obj
				.find(new int[] { 1, 3, 6, 8, 9, 10, 19, 31, 34, 42, 56, 76, 89, 99 }, 108));
		sum = 18;
		System.out.println("\nPrinting all pairs for given sum : " + sum);
		obj.printAllPairs(new int[] { 1, 7, 8, 9, 10, 10, 11, 11, 11, 13, 17 }, sum);

		System.out.println("\nPrinting all pairs for given sum using set : " + sum);
		obj.findPairsUsingSet(new int[] { 13, 7, 9, 8, 11, 10, 17, 11, 13, 1, 17 }, sum);

	}

	/**
	 * O(n) solution to check whether sum of 2 numbers equals to any given
	 * number
	 */

	public boolean find(int arr[], int givenSum)
	{
		int len = arr.length;

		for (int i = 0, j = len - 1; i <= j; )
		{
			if (arr[i] + arr[j] == givenSum)
			{
				System.out.println(
						"Given no : " + givenSum + " found at index : " + i + " value :" + arr[i] + " and index : " + j
								+ " value : " + arr[j]);
				return true;
			}
			else if (arr[i] + arr[j] < givenSum)
			{
				// Rather than blind increment
				// Smartly checks whether middle is a viable index if yes then
				// point to that index+1
				if (arr[(i + j) / 2] + arr[j] < givenSum)
				{
					i = ((i + j) / 2) + 1;
				}
				else
				{
					// otherwise increment pointer
					i++;
				}
			}
			else if (arr[i] + arr[j] > givenSum)
			{
				// Decrement; same as above
				if (arr[i] + arr[(i + j) / 2] > givenSum)
				{
					j = ((i + j) / 2) - 1;
				}
				else
				{
					j--;
				}
			}
		}
		return false;
	}

	/**
	 * Prints all pairs(unique) which equate to given sum
	 */
	public void printAllPairs(int[] arr, int givenSum)
	{
		int len = arr.length;

		for (int i = 0, j = len - 1; i < j; )
		{
			int tempSum = arr[i] + arr[j];
			if (tempSum == givenSum)
			{
				System.out.println("Pair is : " + arr[i] + " , " + arr[j]);
			}
			if (tempSum < givenSum)
			{
				i++;
			}
			else
			{
				j--;
			}
		}
	}

	public void findPairsUsingSet(int[] arr, int givenSum)
	{

		int length = arr.length;
		if (length <= 1)
		{
			System.out.println("Required more than 2 elements for pair");
			return;
		}
		final int maxCapacity = 100;
		boolean[] pairSet = new boolean[maxCapacity];

		for (int i = 0; i < length; i++)
		{
			final int pair = givenSum - arr[i];

			if (pair >= 0 && pairSet[pair])
			{
				System.out.println("Pair is : " + arr[i] + " , " + pair);
			}

			pairSet[arr[i]] = true; // marking the pair in set
		}
	}

}
