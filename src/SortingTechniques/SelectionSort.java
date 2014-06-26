package SortingTechniques;

/**
 * @author Vikky.Agrawal
 *
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SelectionSort obj = new SelectionSort();

		int[] arr = { 5, 3, 1, 2, 9, 8 };

		System.out.println("Array before sorting : ");
		for (int a : arr) {
			System.out.print(a + " ");
		}

		obj.selectionSort(arr);

		System.out.println("\nSorted array : ");
		for (int a : arr) {
			System.out.print(a + " ");
		}

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

}
