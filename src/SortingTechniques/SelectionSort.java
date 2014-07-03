package SortingTechniques;

/**
 * @author Vikky.Agrawal
 *
 */
public class SelectionSort {

	
	int[] arr;

	SelectionSort() {
		arr = new int[] { 5, 3, 1, 2, 9, 8 };
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SelectionSort obj = new SelectionSort();
		obj.operate();

	}
	
	public void operate(){


		System.out.println("Array before sortings: ");
		printArray();
		selectionSort(arr);

		System.out.println("Sorted array : ");
		printArray();
	}
	
	
	
	/*
	 * Not a stable sort
	 * O(n^2)
	 */
	
	public void selectionSort(int[] arr){
		
		int length=arr.length;
		for(int i=0; i<length; i++){
			//find the next min and swap
			int min=arr[i];
			int index=i;
			for(int j=i+1; j<length; j++ ){
				if(arr[j]<min){
					min=arr[j];
					index=j;
				}
			}
		
			if(index!=i){
				int temp=arr[i];
				arr[i]=arr[index];
				arr[index]=temp;
			}
					
		}
	}

	
	public void printArray(){
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	
}
