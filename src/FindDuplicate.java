/**
 * Given an array in range 1..n, a val is repeated twice and a value is missing
 * find that duplicate in O(n)
 * 
 * @author vikky.agrawal
 */

public class FindDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindDuplicate obj = new FindDuplicate();
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 6, 8, 9 };

		obj.findDuplicate(arr, 9);

	}

	public void findDuplicate(int[] arr, int n) {

		if (n <= 0) {
			return;
		}

		int sum = (n * (n + 1)) / 2;
		int squareSum = (n * (n + 1) * ((2 * n) + 1)) / 6;

		int sumofArray = 0;
		int squareSumofArray = 0;

		for (int a : arr) {
			sumofArray += a;
			squareSumofArray += (a * a);
		}

		int a_b = sumofArray - sum; // a-b
		int a2_b2 = squareSumofArray - squareSum; // a^2-b^2

		// (a+b)= (a^2-b^2)/(a-b)

		int aplusb = a2_b2 / a_b;
		int a2 = a_b + aplusb;
		int b = aplusb - (a2 / 2);

		System.out.println("Missing element is :" + b);
		System.out.println("Duplicate element is :" + (a2 / 2));
	}

}
