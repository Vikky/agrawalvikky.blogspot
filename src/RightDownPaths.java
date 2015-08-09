/**
 * @author vikky.agrawal
 *
 */
public class RightDownPaths {

	int[][] arr;
	int length;

	RightDownPaths() {
		this.length = 4;
		arr = new int[length][length];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RightDownPaths().operate();

	}

	public void operate() {
		this.calculate(arr);
	}

	public void calculate(int[][] arr) {

		System.out.println("initial array :");
		printArray(arr);

		int length_ = length - 1;

		arr[length_][length_] = 0;

		// Initialize last row and column with 1.
		for (int k = 0; k < length; k++) {
			arr[k][length_] = 1;
			arr[length_][k] = 1;
		}

		//Building array from bottom to top
		for (int row = length_ - 1; row >= 0; row--) {
			for (int column = length_ - 1; column >= 0; column--) {
				arr[row][column] = arr[row][column + 1] + arr[row + 1][column];
				//Total paths = 	paths(right)		+   paths(down)
			}
		}
		System.out.println("Array after processing");
		printArray(arr);

		System.out
				.println("Total number of paths going right/down from [0,0] is = "
						+ arr[0][0]);

	}

	public void printArray(int[][] arr) {
		int length_ = length;

		for (int row = 0; row < length_; row++) {
			for (int column = 0; column < length_; column++) {
				System.out.print(arr[row][column] + " ");
			}
			System.out.println(" ");
		}
	}

}
