package array;

/**
 * Find the maximum sequence of continuous 1’s that can be
 * formed by replacing at-most k zeroes by ones
 *
 * @Author vikky.agrawal on 4/21/17.
 */
public class MaxSequence
{
	public static void main(String[] args)
	{
		int arr[] = { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0 };
		findMaxSequence(arr, 3);
	}

	/**
	 * The idea is to maintain a window containing at-most k zeroes at any point.
	 * We add elements to the window from right until it becomes unstable.
	 * The window becomes unstable if number of zeros in it becomes more than k.
	 * Then we remove elements from its left side till it becomes stable again (by removing leftmost zero).
	 *
	 * @param arr
	 */
	private static void findMaxSequence(int[] arr, final int noOfZeros)
	{
		final int length = arr.length;
		int max_length = 0;
		int start_index = 0;
		int end_index = 0;
		for (int i = 0; i < length; i++)
		{
			int temp_length = 0;
			int temp_zero = 0;
			int temp_index = i;
			while (i < length)
			{
				if (arr[i] == 0)
				{
					temp_zero++;
				}
				if (temp_zero > noOfZeros)
					break;
				temp_length++;
				i++;
			}

			if (max_length < temp_length)
			{
				max_length = temp_length;
				start_index = temp_index;
				end_index = i - 1;
			}
			//reset index next to first zero encountered;
			while (i-- > 0 && arr[i] == 1)
				;
		}
		System.out.println(
				"Max length sequence found starting : " + start_index + " ending : " + end_index + " having length "
						+ max_length);
	}
}
