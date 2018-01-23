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

		for (int i : arr)
			System.out.println(obj.binarySearch(arr, i, 0, arr.length - 1));

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
