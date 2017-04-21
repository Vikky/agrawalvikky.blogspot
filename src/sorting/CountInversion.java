/**
 * 
 */
package sorting;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author vikky.agrawal
 *
 */
public class CountInversion {

	int[] arr;
	static int number =100000;
	static long n = 0;

	CountInversion() {
		arr = new int[number];
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		CountInversion obj = new CountInversion();
		obj.readLargerTextFile("/Users/viagrawal/Desktop/IntegerArray.txt");
		obj.operate();
		System.out.println("N is : "+n);
		

	}

	public void operate() {

		//System.out.println("Array before sortings: ");
		//printArray();
		mergeSort(arr, 0,number-1 );

		System.out.println("Sorted array : ");
		printArray();
	}

	public void mergeSort(int[] arr, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}

	public void merge(int[] arr, int p, int q, int r) {

		int length = arr.length;
		int[] tempArray = new int[length];

		for (int i = 0; i < length; i++) {
			tempArray[i] = arr[i];
		}

		int temp = p;
		int i = p, j = q + 1;
		for (; i <= q && j <= r;) {
			if (tempArray[i] < tempArray[j]) {
				arr[temp++] = tempArray[i];
				i++;
			} else {
				// System.out.println("Array indexes p :"+p+" q :"+q+" r :"+r+" i :"+i+" j :"+j);
				n = n + (q + 1) - i;
				arr[temp++] = tempArray[j];
				j++;
			}
		}

		while (i <= q) {
			arr[temp++] = tempArray[i];
			i++;
		}

		while (j < r) {
			arr[temp++] = tempArray[j];
			j++;
		}
	}

	public void printArray() {
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	
	void readLargerTextFile(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    try (Scanner scanner =  new Scanner(path)){
	    	int i=0;
	      while (scanner.hasNextLine()){
	        //System.out.println(scanner.nextLine());
	    	 
	        arr[i++]= Integer.parseInt(scanner.nextLine());
	      }
	      System.out.println("Numbers are  :"+i);
	    }
	    
	   // printArray();
	    
	  }
	
	
	
	
	

}
