package sorting;

/**
 * @author Vikky.Agrawal
 */
public class QuickSort
{

	int[] arr;

	QuickSort()
	{
		arr = new int[] { 5, 3, 1, 2, 9, 8 };
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		QuickSort obj = new QuickSort();
		obj.operate();
	}

	public void operate()
	{

		System.out.println("Array before sortings: ");
		printArray();
		quickSort(arr, 0, 5);

		System.out.println("Sorted array : ");
		printArray();
	}

	public void quickSort(int[] arr, int low, int high)
	{

		if (low < high)
		{
			int pivot = findPivot(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}

	}


	/*
	 * Algorithm for partition to find pivot
	 *
	 * PARTITION.A;p;r
	 * 1 x =A[r]
	 * 2 i = p-1
	 * 3 for j =p to r-1
	 * 4   if A[j] <= x
	 * 5   i=i+1
	 * 6   exchange A[i]  with A[j]
	 * 7 exchange A[i+1] with x
	 * 8 return i+1
	 */

	public int findPivot(int[] arr, int low, int high)
	{

		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++)
		{
			if (arr[j] <= pivot)
			{
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, high, i + 1);
		return i + 1;
	}

	private void swap(final int[] arr, final int i, final int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void printArray()
	{
		for (int a : arr)
		{
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
