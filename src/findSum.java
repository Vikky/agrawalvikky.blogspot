/**
 * @author vikky.agrawal 
 * program to find whether sum of 2 numbers equals to a
 * given no in a sorted array
 * 
 */
public class findSum {

	public boolean findNo(int arr[], int givenNo) {
		int len = arr.length;

		for (int i = 0, j = len - 1; i <= j;) {
			if (arr[i] + arr[j] == givenNo) {
				System.out.println("found at index : " + i + " value :" + arr[i]+ " and index : " + j + " value : " + arr[j]);
				return true;
			} else if (arr[i] + arr[j] < givenNo) {
				if (arr[(i + j) / 2] + arr[j] < givenNo) {
					i = ((i + j) / 2) + 1;
				} else {
					i++;
				}
			} else if (arr[i] + arr[j] > givenNo) {
				if (arr[i] + arr[(i + j) / 2] > givenNo) {
					j = ((i + j) / 2) - 1;
				} else {
					j--;
				}
			}
		}
		return false;
	}

	public static void main(String arg[]) {

		findSum obj = new findSum();
		System.out.println("whether sum exists :"
				+ obj.findNo(new int[] { 1, 3, 6, 8, 9, 10, 19, 31, 34, 42, 56,
						76, 89, 99 }, 108));

	}

}
