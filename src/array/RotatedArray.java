package array;

/**
 * Created by viagrawal on 7/6/17.
 */
public class RotatedArray
{

	public static void main(String[] args)
	{

		int arr[] = new int[] { 5, 6, 7, 8, 9, 10, 1, 2, 3, 4 };
		findRotatedIndex(arr);
		for (int i = 1; i < 11; i++)
			findElementInRotatedArray(arr, i);
	}

	private static int findRotatedIndex(int arr[])
	{
		int length = arr.length;
		if (length == 0)
			return 0;

		for (int i = 0, j = length - 1; i < j; )
		{
			if (arr[i] > arr[i + 1])
			{
				System.out.println("Index rotated at " + i);
				return i;
			}
			if (arr[j] < arr[j - 1])
			{
				System.out.println("Index rotated at " + j);
				return j;
			}
			int index = (i + j) / 2;
			if (arr[index] > arr[i])
				i = index;
			else
				j = index;
		}
		System.out.println("Array not rotated");
		return -1;
	}

	private static void findElementInRotatedArray(int arr[], int element)
	{
		int length = arr.length;
		if (length == 0)
			return;

		int start = 0, end = length - 1;
		int rotated = findRotatedIndex(arr);
		if (rotated == -1)
			System.out.println("Element:  " + element + " found at index : " + binarySearch(arr, start, end, element));
		else
		{
			if (arr[rotated] < element && arr[end] < element)
				System.out.println(
						"Element: " + element + " found at index : " + binarySearch(arr, start, rotated - 1, element));
			else
				System.out
						.println("Element: " + element + " found at index : " + binarySearch(arr, rotated, end, element));
		}
	}

	private static int binarySearch(int arr[], int start, int end, int element)
	{
		if (start <= end)
		{
			int mid = (start + end) / 2;
			if (arr[start] == element)
				return start;
			if (arr[end] == element)
				return end;

			if (arr[mid] == element)
				return mid;

			if (element < arr[mid])
			{
				return binarySearch(arr, start, mid - 1, element);
			}
			else
				return binarySearch(arr, mid + 1, end, element);
		}
		return -1;
	}

}
