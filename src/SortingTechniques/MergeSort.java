package SortingTechniques;

/**
 * @author vikky.agrawal
 *
 */
public class MergeSort {

	
	int[] arr;
	
	MergeSort(){
		arr=new int[] { 5, 3, 1, 2, 9, 8 };
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MergeSort obj = new MergeSort();
		obj.operate();
		

	}
	
	
	public void operate(){


		System.out.println("Array before sortings: ");
		printArray();
		mergeSort(arr,0,5);

		System.out.println("Sorted array : ");
		printArray();
	}
	
	
	public void mergeSort(int[] arr, int p, int r){
		if(p<r){
			int q=(p+r)/2;
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr,p,q,r);
		}
	}
	
	public void merge(int[] arr, int p, int q, int r){
		
		int length=arr.length;
		int[] tempArray =new int[length];

		for (int i=0;i<length; i++) {
			tempArray[i]=arr[i];
		}
		
		int temp=p;
		int i=p,j=q+1;
		for(; i<=q && j<=r ; ){
			if(tempArray[i] < tempArray[j]){
				arr[temp++]=tempArray[i];
				i++;
			}else{
				arr[temp++]=tempArray[j];
				j++;
			}
		}
		
		while(i <= q){
			arr[temp++]=tempArray[i];
			i++;
		}
		
		while(j < r){
			arr[temp++]=tempArray[j];
			j++;
		}
	}
	

	public void printArray(){
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	
	
	
}
