/**
 * @author Vikky.Agrawal
 * 
 */
public class MaxSumSubArray {

	/**
	 * @param args
	 */

	int arr[];

	MaxSumSubArray() {
		arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
	}

	public static void main(String[] args) {
		new MaxSumSubArray().operate();

	}

	public void operate() {
		System.out.println("Max sum is " + findMaxSum(arr, 0, arr.length - 1));
		System.out.println("Max sum using kadane's algo :"
				+ findMaxSubArraySum(arr));
	}

	public int findMaxSum(int arr[], int low, int high) {

		if (low == high) {
			return arr[low];
		}

		int mid = (low + high) / 2;
		return maxOfThree(findMaxSum(arr, low, mid),
				findMaxSum(arr, mid + 1, high),
				maxCrossSum(arr, low, mid, high));

	}

	public int maxCrossSum(int arr[], int low, int mid, int high) {

		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = mid; i >= low; i--) {
			sum = sum + arr[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}

		sum = 0;

		for (int j = mid + 1; j <= high; j++) {
			sum += arr[j];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}

		return leftSum + rightSum;

	}

	// refer : http://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane.27s_algorithm
	// Using Kadane's algorithm
	// will return negative if all elements are negative
	// Time complexity : O(n)

	public int findMaxSubArraySum(int arr[]) {

		int max_ending_here = arr[0];
		int max_so_far = arr[0];

		int begin = 0;
		int end = 0;
		int temp = 0;

		for (int i = 1; i < arr.length; i++) {

			if (max_ending_here < 0) {
				max_ending_here = arr[i];
				temp = i;
			} else {
				max_ending_here += arr[i];
			}

			if (max_ending_here >= max_so_far) {
				max_so_far = max_ending_here;
				begin = temp;
				end = i;
			}

		}

		System.out.println("Largest subarry start index :" + begin
				+ " end index : " + end);

		return max_so_far;
	}

	//Another approach using Kadane's
	public int findMaxSumKadane(int arr[]){
		int  max_ending_here =0, max_so_far = 0;
		
		for(int data:arr){
			max_ending_here=maxOfTwo(0,	max_ending_here+data);
			max_so_far= maxOfTwo(max_so_far, max_ending_here);
		}
		
		return max_so_far;
	}
	
	
	
	// Helper functions
	public int maxOfTwo(int a, int b) {
		return a > b ? a : b;
	}

	public int maxOfThree(int a, int b, int c) {
		return maxOfTwo(maxOfTwo(a, b), c);
	}

}
