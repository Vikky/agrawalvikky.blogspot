package sorting;


/**
 * @author Vikky.Agrawal
 *
 */
public class CountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 CountingSort obj=new  CountingSort();
		 int a[]=new int[]{7,2,6,9,1,2,8,0,5,4,2,3,1,6};
		 obj.countingSort(a, 9);
		
	}
	
/*
 * Algorithm
	COUNTING-SORT.(A;B;k)
	A[1...n] input array
	B[1...n] output array
	C[0...k] auxiliary array(k is the max element)
	
	1 let C[0..k]be a new array
	2 for i =0 to k
	3 C[i]=0;
	4 for j=1 to A.length
	5 C[ A[j] ]=C[ A[j] ]+1;
	6 // C[i]now contains the number of elements equal to i.
	7 for i= 1 to k
	8 C[i]=C[i]+c[i-1];
	9 //C[i] now contains the number of elements less than or equal to i.
	10 for j= A.length down to 1
	11 B[C[A[j]]]=A[j];
	12 C[A[j]]=C[A[j]]-1;
*/
	
	/*
	 * Sorting in linear time with auxiliary space O(n+k)
	 */
	
	public int[] countingSort(int[] a,int k){
		
		
		System.out.println("Input array :");
		printArray(a);
		
		int[] b=new int[a.length];
		int[] c=new int[k+1];
		
		for(int i=0;i<a.length;i++){
			c[a[i]]=c[a[i]]+1;
		}
		// C[i] now contains the number of elements equal to i. if c[5]=3 then there are 3 5's
		
		
		//sutract 1 to make array index from 0;
		c[0]=c[0]-1;
		for(int i=1;i<c.length;i++){
			c[i]=c[i]+c[i-1];
		}
		
		//C[i] now contains the number of elements less than or equal to i.
		//if c[1]=3 then there are 3 elements which are less than or equal to 1. 
		
		for(int j=a.length-1; j>=0 ;j--){
			b[c[a[j]]]=a[j];     //c[j] contains actual location of a[j]; 
			c[a[j]]=c[a[j]]-1;
		}
		
		System.out.println("\nSorted array :");
		printArray(b);		
		
		return b;
	}
	
	public void printArray(int[] arr){
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
