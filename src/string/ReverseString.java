package string;

/**
 * Created by viagrawal on 3/12/18.
 */
public class ReverseString
{
	public static void main(String[] args)
	{
		char[] arr = "abcd".toCharArray();
		ReverseString object = new ReverseString();

		object.reverseRecursive(arr, 0, arr.length - 1);
		object.print(arr);

		object.reverseIterative(arr);
		object.print(arr);
	}

	private void reverseIterative(char[] arr)
	{
		for (int i = 0, j = arr.length - 1; i <= j; i++, j--)
			swap(arr, i, j);
	}

	private void reverseRecursive(char[] arr, int i, int j)
	{
		if (i <= j)
		{
			swap(arr, i, j);
			i++;
			j--;
			reverseRecursive(arr, i, j);
		}
	}

	private void swap(final char[] arr, final int i, final int j)
	{
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void print(final char[] arr)
	{
		for (char c : arr)
			System.out.print(c + " ");
	}
}
