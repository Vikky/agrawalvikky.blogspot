package array;

import com.sun.tools.javac.util.Pair;

/**
 * If given number is 1234 then next greater number would be 1243. For the input 1243, next greater number would be
 * 1324. If the input is 6938652 then the output should be the number 6952368
 *
 * Algo:
 *
 * - Start from end of the array
 * - check if lesser digit than current one is present (repeat till index=0)
 * -	if yes return that digit with its index
 * -  	swap index with current digit
 * -  	Sort the next digits starting after the index
 * 		(break)
 *
 */
public class NextGreaterNumber_new
{
	public static void main(String[] args)
	{
		NextGreaterNumber_new obj = new NextGreaterNumber_new();
		obj.findNextGreater(new int[] { 6, 9, 3, 8, 6, 5, 2 });
		obj.findNextGreater(new int[] { 1, 2, 4, 3 });
		obj.findNextGreater(new int[] { 2, 1 });
	}

	void findNextGreater(int[] arr)
	{
		int len = arr.length;
		//preconfitions.

		boolean success = false;
		for (int i = len - 1; i > 0; i--)
		{
			Pair<Boolean, Integer> findNext = findNext(arr, i);
			if (findNext.fst)
			{
				int index = findNext.snd;
				swap(arr, i, index);
				sort(arr, index + 1);
				success = true;
				break;
			}
		}
		if (!success)
		{
			System.out.println("Next greater number not feasible.");
		}
		else
		{
			print(arr);
		}
	}

	Pair<Boolean, Integer> findNext(int[] arr, int index)
	{

		int num = arr[index];
		for (int j = index - 1; j >= 0; j--)
		{
			if (num > arr[j])
			{
				return Pair.of(true, j);
			}
		}

		return Pair.of(false, index);
	}

	void swap(int[] arr, int i, int index)
	{
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}

	void sort(int[] arr, int index)
	{
		int len = arr.length;
		if (index >= len)
		{
			return;
		}

		for (int i = index; i < len; i++)
		{
			for (int j = i + 1; j < len; j++)
			{
				if (arr[j] < arr[i])
				{
					swap(arr, i, j);
				}
			}
		}
	}

	void print(int[] arr)
	{
		for (int a : arr)
			System.out.print(a);
		System.out.println();
	}

}
