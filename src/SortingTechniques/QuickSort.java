package SortingTechniques;

/**
 * @author Vikky.Agrawal
 *
 */
public class QuickSort {

	
	int[] arr;
	
	QuickSort(){
		arr=new int[] { 5, 3, 1, 2, 9, 8 };
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		QuickSort obj = new QuickSort();
		obj.operate();
	}
	
	
	public void operate(){
		
		System.out.println("Array before sortings: ");
		printArray();
		quickSort(arr,0,5);

		System.out.println("Sorted array : ");
		printArray();
	}
	
	
	public void quickSort(int[] arr, int p, int r){
		
		if(p<r){
			int q= findPivot(arr,p,r);
			quickSort(arr, p, q-1);
			quickSort(arr, q+1, r);
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
	
	public int findPivot(int[] arr, int p, int r){
		
		int x=arr[r];
		int i=p-1;	
		
		for(int j=p ;j<r; j++){
			if(arr[j]<= x){
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}		
		
		arr[r]=arr[i+1];
		arr[i+1]=x;
		return i+1;
	}
	
	public void printArray(){
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	
	
}
