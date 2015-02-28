/**
 * QuickSortPracticePractice.java
 * 
 * @author vikky.agrawal
 */
package SortingTechniques;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class QuickSortPractice {

	int[] arr;
	static int number = 10000;
	static long comparisons = 0;

	QuickSortPractice() {
		arr = new int[number];
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		QuickSortPractice obj = new QuickSortPractice();
		obj.readLargerTextFile("/Users/viagrawal/learning/QuickSort.txt");
		obj.operate();
	}

	public void operate() {

		System.out.println("Array before sortings: ");
		printArray();
		QuickSort(arr, 0, number - 1);

		System.out.println("Sorted array : ");
		printArray();

		System.out.println("Total  comparisons : " + comparisons);
	}

	public void QuickSort(int[] arr, int p, int r) {

		if (p < r) {
			//int q = findPivotUsingFirst(arr, p, r);
			//int q = findPivotUsingLast(arr, p, r);
			int q = findPivotUsingMedian(arr, p, r);
			QuickSort(arr, p, q - 1);
			QuickSort(arr, q + 1, r);
		}

	}

	
	/**
	 * Partition(A as array, low as int, high as int)
     pivot = A[low]
     leftwall = low

     for i = low + 1 to high
         if (A[i] < pivot) then
             leftwall = leftwall + 1
             swap(A[i], A[leftwall])

     swap(A[low],A[leftwall])

    return (leftwall)
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	public int findPivotUsingFirst(int[] arr, int l, int r){
		
		comparisons += r-l ;

		int p = arr[l];
		int i = l;
		for(int j = l+1 ; j<=r ; j++){
			if(arr[j]<p){
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, l, i);
		return i;
		
	}
	/*
	 * Algorithm for partition to find pivot as last element
	 * 
	 * PARTITION.A;p;r 1 x =A[r] 2 i = p-1 3 for j =p to r-1 4 if A[j] <= x 5
	 * i=i+1 6 exchange A[i] with A[j] 7 exchange A[i+1] with x 8 return i+1
	 */

	public int findPivotUsingLast(int[] arr, int p, int r) {
		swap(arr,p,r);
		return findPivotUsingFirst(arr, p, r);
	}
	
	
	
	public int findPivotUsingMedian(int[] arr, int p, int r) {
		
		int mid = (p+r)/2;
		int pivot = findSecondMax(arr[p], arr[mid], arr[r]);
		int index = p;
		if(pivot == arr[mid]){
			index=mid;
		}else if(pivot == arr[r]){
			index = r;
		}
		swap(arr,p,index);
		return findPivotUsingFirst(arr, p, r);
	}


	public void swap(int[] arr , int i ,int j){
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j] = temp;
	}
	
	
	
	
	public int findSecondMax(int a, int b, int c) {

		return a > b ? (b > c ? b : (a > c ? c : a)) : (a > c ? a : (b > c ? c
				: b));

	}

	public void printArray() {
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	void readLargerTextFile(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		try (Scanner scanner = new Scanner(path)) {
			int i = 0;
			while (scanner.hasNextLine()) {
				arr[i++] = Integer.parseInt(scanner.nextLine());
			}
		}

		// printArray();

	}
	
	
}
