package array;

/**
 * Find the maximum sequence of continuous 1’s that can be formed by replacing at-most k zeroes by ones
 *
 * @Author vikky.agrawal on 4/21/17.
 */
public class MaxSequence
{
	public static void main(String[] args)
	{
		int arr[] = { 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0 };
		findMaxSequence(arr, 3);
	}

	/**
	 * The idea is to maintain a window containing at-most k zeroes at any point. We add elements to the window from
	 * right until it becomes unstable. The window becomes unstable if number of zeros in it becomes more than k. Then
	 * we remove elements from its left side till it becomes stable again (by removing leftmost zero).
	 *
	 * @param arr
	 */
	private static void findMaxSequence(int[] arr, final int noOfZeros)
	{
		final int length = arr.length;
		if (arr.length < 0)
			return;

		int count = noOfZeros;
		int j = 0;
		int maxLength = 0;
		for (int i = 0; i < length; )
		{
			while (count >= 0 && j < length)
			{
				if (arr[j] == 0)
					count--;
				j++;
			}
			int tempLength = j - i;
			if (j >= length && arr[j - 1] == 0)
			{
				tempLength--;
			}

			maxLength = maxLength < (tempLength) ? (tempLength) : maxLength;
			System.out.println("i index : " + i + " j index : " + j + " length : " + maxLength);

			while (i < length && arr[i] != 0 && i < j)
			{
				i++;
			}
			i++;
			if (i < length && arr[i] == 0)
			{
				count++;
			}
		}
		System.out.println("max sequence : " + maxLength);

		find(arr, noOfZeros);

	}

	static void find(int[] arr, int num)
	{
		//preconditions

		int len = arr.length;
		int i = 0, j = 0, z = 0;
		int zeros = 0;
		int maxLength = 0;

		while (i < len)
		{
			while (++j < len)
			{
				if (arr[j] == 0)
				{
					zeros++;
					if (zeros > num)
					{
						break;
					}
				}
			}
			maxLength = maxLength < j - i + 1 ? (j - i + 1) : maxLength;

			//reset i and zeros

			while (i < len && arr[i] != 0)
			{
				i++;
			}
			i++;
			zeros--;

		}
		System.out.println("Maxlength :" + maxLength);
	}

}