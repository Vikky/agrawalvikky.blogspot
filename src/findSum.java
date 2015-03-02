/**
 * Program to find whether sum of 2 numbers equals to a
 * given no in a sorted array
 * @author vikky.agrawal 
 *
 * 
 */
public class findSum {

	public static void main(String arg[]) {

		findSum obj = new findSum();
		int sum=108;
		System.out.println("whether sum: "+sum+" exists :"
				+ obj.find(new int[] { 1, 3, 6, 8, 9, 10, 19, 31, 34, 42, 56,
						76, 89, 99 }, 108));
		sum=15;
		System.out.println("\nPrinting all pairs for given sum : "+sum);
		obj.printAllPairs(new int[] { 6,7,8,9,10},sum);
	}

	/*
	 * O(n) solution to check whether sum of 2 numbers equals to any given number
	 */
	
	public boolean find(int arr[], int givenSum) {
		int len = arr.length;

		for (int i = 0, j = len - 1; i <= j;) {
			if (arr[i] + arr[j] == givenSum) {
				System.out.println("Given no : "+givenSum+" found at index : " + i + " value :" + arr[i]+ " and index : " + j + " value : " + arr[j]);
				return true;
			} else if (arr[i] + arr[j] < givenSum) {
				//Rather than blind increment
				//Smartly checks whether middle is a viable index if yes then point to that index+1
				if (arr[(i + j) / 2] + arr[j] < givenSum) {
					i = ((i + j) / 2) + 1;
				} else {
					//otherwise increment pointer
					i++;
				}
			} else if (arr[i] + arr[j] > givenSum) {
				//Decrement; same as above
				if (arr[i] + arr[(i + j) / 2] > givenSum) {
					j = ((i + j) / 2) - 1;
				} else {
					j--;
				}
			}
		}
		return false;
	}

	/*
	 * Prints all pairs(unique) which equate to given sum
	 */
	public void printAllPairs(int[] arr, int givenSum){
		
		int len=arr.length;
		
		for(int i=0, j=len-1; i<=j ; ){
			
			if(arr[i]+arr[j]==givenSum){
				System.out.println("Pair :"+arr[i]+" , "+arr[j]);
				i++;
				j--;
			}else if(arr[i]+arr[j]<givenSum){
				i++;
			}else{
				j--;
			}
		}
	}
	
	
}
