package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author vikky.agrawal
 */
public class HeapSort
{

	ArrayList<Integer> array;

	HeapSort()
	{
		array = new ArrayList<>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new HeapSort().operate();
	}

	public void operate()
	{
		for (int i = 0; i < 11; i++)
		{
			array.add(((int) (Math.random() * 100)));
		}

		System.out.println("Array before maxheapify :");
		printArray();

		buildMaxHeap();

		System.out.println("Array after max heapify");
		printArray();

		this.heapSort();

		System.out.println("\nArray after Heap Sort");

		printArray();
		System.out.println("\nIs Array sorted now ? " + isSorted());

	}
	
	
	
	/*
	 * Heapify takes O(log n) / O(height)
	 */

	public void heapify(ArrayList<Integer> array, int index, int size)
	{
		int left = this.getLeft(index);
		int right = this.getRight(index);

		final int indexElement = array.get(index);
		int largest = indexElement;
		int temp = index;

		if (left != -1 && array.get(left) > largest && left < size)
		{
			largest = array.get(left);
			temp = left;
		}

		if (right != -1 && array.get(right) > largest && right < size)
		{
			largest = array.get(right);
			temp = right;
		}

		if (temp != index)
		{
			swap(array, index, indexElement, largest, temp);

			if (temp < size / 2)
			{
				heapify(array, temp, size);
			}
		}

	}

	private void swap(final ArrayList<Integer> array, final int index, final int indexElement, final int largest,
			final int temp)
	{
		array.add(index, largest);
		array.remove(index + 1); // Arraylist shifts elements to right, so remove it
		array.add(temp, indexElement);
		array.remove(temp + 1);
	}

	/*
	 * Building a Max Heap takes O(n) time
	 */

	public void buildMaxHeap()
	{
		int size = array.size();
		for (int i = (size / 2) - 1; i >= 0; i--)
		{
			this.heapify(array, i, size);
		}
	}
	
	
	/*
	 * Heap sort takes O(n logn) overall;
	 */

	public void heapSort()
	{
		int size = array.size();
		int index = size - 1;

		for (int i = 0; i < size; i++)
		{
			int data = array.remove(0);
			array.add(index, data);

			for (int j = (size / 2) - 1; j >= 0; j--)
			{
				this.heapify(array, j, index);
			}

			index--; //ignore indexes which are sorted
		}

		//Reverse the array for sorted version (runs in linear time)
		Collections.reverse(array);
	}

	/*
	 * Helper functions for Heap
	 */
	public int getLeft(int index)
	{
		if ((index * 2) + 1 < array.size())
		{
			return (index * 2) + 1;
		}
		return -1;
	}

	public int getRight(int index)
	{
		if ((index * 2) + 2 < array.size())
		{
			return (index * 2) + 2;
		}
		return -1;
	}

	public int getParent(int index)
	{
		if (index < array.size())
		{
			if (index % 2 == 0)
			{
				return (index / 2) - 1;
			}
			return index / 2;
		}
		return -1;
	}

	public void printArray()
	{
		Iterator<Integer> itr = array.iterator();
		while (itr.hasNext())
		{
			System.out.print(itr.next() + " ");
		}
		System.out.println();
	}

	public boolean isSorted()
	{
		for (int i = 1; i < array.size(); i++)
		{
			if (array.get(i) > array.get(i - 1))
			{
				return false;
			}
		}
		return true;
	}

}
