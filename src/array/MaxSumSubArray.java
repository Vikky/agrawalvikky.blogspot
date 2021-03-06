package array;

/**
 * @author Vikky.Agrawal
 */
public class MaxSumSubArray
{
	/**
	 * @param args
	 */

	int arr[];

	MaxSumSubArray()
	{
		arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		//{ -2, -1, -3, -4, -1, -2, -1, -5, -4 };
	}

	public static void main(String[] args)
	{
		new MaxSumSubArray().operate();
	}

	public void operate()
	{
		System.out.println("Max sum is " + findMaxSum(arr, 0, arr.length - 1));
		System.out.println("Max sum using kadane's algo :" + findMaxSumSubArray(arr));
		System.out.println("Alternate kadane's :" + findMaxSumKadane(arr));
	}

	public int findMaxSum(int arr[], int low, int high)
	{

		if (low == high)
		{
			return arr[low];
		}

		int mid = (low + high) / 2;
		return maxOfThree(findMaxSum(arr, low, mid), findMaxSum(arr, mid + 1, high), maxCrossSum(arr, low, mid, high));

	}

	public int maxCrossSum(int arr[], int low, int mid, int high)
	{

		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = mid; i >= low; i--)
		{
			sum = sum + arr[i];
			if (sum > leftSum)
			{
				leftSum = sum;
			}
		}

		sum = 0;

		for (int j = mid + 1; j <= high; j++)
		{
			sum += arr[j];
			if (sum > rightSum)
			{
				rightSum = sum;
			}
		}

		return leftSum + rightSum;

	}

	// refer : http://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane.27s_algorithm
	// Using Kadane's algorithm
	// will return negative if all elements are negative
	// Time complexity : O(n)
	public int findMaxSumSubArray(int[] arr)
	{
		int max_end = 0;
		int max = 0;
		int statIndex = 0;
		int endIndex = 0;

		for (int i = 0; i < arr.length; i++)
		{
			max_end += arr[i];

			if (max_end < 0)
			{
				max_end = 0;
				statIndex = i + 1;
			}

			if (max < max_end)
			{
				max = max_end;
				endIndex = i;
			}
		}

		System.out.println("Max is " + max);
		System.out.println("Largest sum subarray start index : " + statIndex + " End index : " + endIndex);

		return max;
	}

	//Another approach using Kadane's algorithm
	public int findMaxSumKadane(int arr[])
	{

		int length = arr.length;

		if (length == 0)
		{
			return Integer.MIN_VALUE;
		}

		//This will help with negative numbers.
		int max_ending_here = arr[0], max_so_far = arr[0];

		for (int j = 1; j < length; j++)
		{
			max_ending_here = maxOfTwo(max_ending_here + arr[j], arr[j]);
			max_so_far = maxOfTwo(max_so_far, max_ending_here);
		}

		return max_so_far;
	}

	// Helper functions
	public int maxOfTwo(int a, int b)
	{
		return a > b ? a : b;
	}

	public int maxOfThree(int a, int b, int c)
	{
		return maxOfTwo(maxOfTwo(a, b), c);
	}

}
