package array;

import java.util.Arrays;

/**
 * Created by viagrawal on 3/10/18.
 */
public class NextGreaterNumber
{
	public static void main(String[] args)
	{
		int arr[] = new int[] { 1,9,1,7,0 };

		for (int i = arr.length - 1; i >= 0; i--)
		{
			int j = i - 1;
			while (j >= 0 && arr[j] > arr[i])
				j--;
			if (i == 0 && j == -1)
			{
				System.out.println("Not possible");
				break;
			}
			if (j == -1)
				continue;
			swap(arr, findNextGreaterIndex(arr, j, arr[j], arr[i]), j);
			Arrays.sort(arr, j + 1, arr.length);
			break;
		}
		for (int a : arr)
			System.out.println(a);
	}

	/**
	 *
	 * @param arr
	 * @param index
	 * @param element
	 * @param min
	 * @return
	 */
	private static int findNextGreaterIndex(final int[] arr, final int index, final int element, int min)
	{
		for (int j = index + 1; j < arr.length; j++)
		{
			if (arr[j] > element && arr[j] <= min)
				return j;
		}
		return -1; //will never come here
	}

	private static void swap(final int[] arr, final int nextGreater, final int index)
	{
		int temp = arr[index];
		arr[index] = arr[nextGreater];
		arr[nextGreater] = temp;
	}
}