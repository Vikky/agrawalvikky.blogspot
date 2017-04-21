package sorting;

/**
 * @author Vikky.Agrawal
 * 
 */
public class InsertionSort {

	
	int[] arr;
	
	InsertionSort(){
		arr=new int[] { 5, 3, 1, 2, 9, 8 };
	}
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {

		InsertionSort obj = new InsertionSort();
		obj.operate();
		

	}
	
	public void operate(){


		System.out.println("Array before sortings: ");
		printArray();
		sort();

		System.out.println("Sorted array : ");
		printArray();
	}
	

	/*
	 * Insertion Sort algo: 
	 * 1 for j=1 to Arr.length 
	 * 2 key= Arr[j]; 
	 * 3 //Insert Arr[j] into the sorted sequence Arr[0...j-1].
	 * 4 i=j-1; //initialization for looping 
	 * 5 while (i>=0 and Arr[i] >key) 
	 * 6   Arr[i+1]=Arr[i] 
	 * 7   i=i-1; 
	 * 8 Arr[i+1] = key
	 */

	public int[] sort() {

		int length = arr.length;
		int i = 0;
		int key = 0;
		for (int j = 1; j < length; j++) {

			i = j - 1;
			key = arr[j];
			while (i >= 0 && arr[i] > key) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = key;
		}

		return arr;
	}

	public void printArray(){
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	
}
