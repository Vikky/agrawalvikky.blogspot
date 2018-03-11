package array;

/**
 * Sort a binary array in O(n).
 * <p>
 * Created by viagrawal on 3/11/18.
 */
public class BinaryArray
{
	public static void main(String[] args)
	{
		int arr[] = { 0, 0, 01, 1, 0, 1 };
		int length = arr.length;
		int count = 0;

		for (int i = 0; i < length; i++)
		{
			if (arr[i] == 0)
				arr[count++] = arr[i];
		}

		for (int i = count; i < length; i++)
			arr[count++] = 1;

		for (int a : arr)
			System.out.print(a + " ");
	}
}