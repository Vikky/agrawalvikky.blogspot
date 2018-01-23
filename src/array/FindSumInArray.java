package array;

/**
 * Find minimum contiguous elements in given array whose sum equal to given value
 * <p>
 * Created by viagrawal on 8/26/17.
 */
public class FindSumInArray
{

	public static void main(String[] args)
	{
		FindSumInArray object = new FindSumInArray();
		int[] arr = { 1, 45, 1, 2, 7, 6, 4, 3, 8, 2, 9 };
		int value = 23;

		System.out.println("Min length : " + object.findLength(arr, value));
	}

	public int findLength(int[] arr, int sum)
	{
		int length = arr.length;
		if (length < 1)
			return 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < length; )
		{
			int j=i;
			int tempSum = 0;
			while (tempSum < sum && j < length)
			{
				tempSum += arr[j];
				if (tempSum >= sum)
					break;
				j++;
			}
			if (tempSum == sum)
			{
				System.out.println("Sum found from index : " + i + " to index : " + j);
				if ((j-i+1) < min)
					min = (j-i+1);
				i++;
			}
			if (j >= length)
				break;
			while (tempSum > sum && i < length)
			{
				tempSum -= arr[i];
				i++;
			}
		}
		return min;
	}

}
