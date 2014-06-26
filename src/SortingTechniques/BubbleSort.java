package SortingTechniques;

/**
 * @author Vikky.Agrawal
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BubbleSort obj = new BubbleSort();

		int[] arr = { 5, 3, 1, 2, 9, 8 };

		System.out.println("Array before sorting : ");
		for (int a : arr) {
			System.out.print(a + " ");
		}

		obj.bubbleSort(arr);

		System.out.println("\nSorted array : ");
		for (int a : arr) {
			System.out.print(a + " ");
		}

		
	}

	/*
	 * stable sort
	 * O(n^2)
	 */
	
	public void bubbleSort(int[] arr){
		
		int length=arr.length;
		for(int i=0; i<length; i++){
		  boolean swap=false;
			for(int j=(length-1); j>i;j-- ){
				if(arr[j] < arr[j-1]){
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
					swap=true;
				}
			}
			if(!swap){
				//If there is not even a single swap then break the loop;
				//Since each element is being compared and if no swapping then it means, array is sorted now.
				break;
			}			
		}
		
	}
}
