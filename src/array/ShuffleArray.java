package array;

import java.util.Random;

/**
 * Shuffle a given array of elements (Fisher–Yates shuffle)
 * — To shuffle an array a of n elements :
 * for i from n-1 downto 1 do
 * j = random integer such that 0 <= j <= i
 * exchange a[j] and a[i]
 * <p>
 * Created by viagrawal on 3/19/18.
 */
public class ShuffleArray
{

	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		for (int i = arr.length - 1; i >= 0; i--)
		{
			int j = new Random().nextInt(i + 1); // (max – min) + 1) + min?; min is 0
			swap(arr, i, j);
		}

		for (int a : arr)
			System.out.print(a + " ");
	}

	private static void swap(final int[] arr, final int i, final int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}