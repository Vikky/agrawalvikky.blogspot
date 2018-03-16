package search;

/**
 * Created by viagrawal on 9/2/17.
 */
public class BinarySearch
{

	public static void main(String[] args)
	{
		BinarySearch obj = new BinarySearch();
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] rotatedArray = { 2, 3, 4, 6, 8, 1 };

		for (int i : rotatedArray)
		{
			//			System.out.println(obj.binarySearch(arr, i, 0, arr.length - 1));
			System.out.print(obj.binarySearchRotated(rotatedArray, i, 0, rotatedArray.length - 1) + " ");
		}

	}

	/**
	 * Search in circularly rotated array, since array is sorted use binary search functionality
	 *
	 * @param arr
	 * @param data
	 * @param low
	 * @param high
	 * @return
	 */
	private int binarySearchRotated(int[] arr, int data, int low, int high)
	{
		int left = arr[low];
		int right = arr[high];
		if (data == left)
			return low;
		if (data == right)
			return high;

		if ((data < left && data < right) || (data > left && data > right))
		{
			int mid = (low + high) / 2;
			if (data == arr[mid])
				return mid;
			if (data < arr[mid])
				return binarySearchRotated(arr, data, low, mid - 1);
			else
				return binarySearchRotated(arr, data, mid + 1, high);
		}
		else
			return binarySearch(arr, data, low, high);
	}

	public int binarySearch(int[] arr, int data, int p, int r)
	{
		if (p <= r)
		{
			int mid = (p + r) / 2;
			if (data == arr[mid])
				return mid;
			if (data < arr[mid])
				return binarySearch(arr, data, p, mid - 1);
			else
				return binarySearch(arr, data, mid + 1, r);
		}
		return -1;
	}

}
