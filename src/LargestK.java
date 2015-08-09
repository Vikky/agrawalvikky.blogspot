/**
 * 
 * @author vikky.agrawal
 *
 */
public class LargestK {

	int arr[];
	int length;

	LargestK() {
		arr = new int[] { 16, 17, 18, 4, 12, 9, 5, 1 };
		this.length = arr.length;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LargestK().operate();
	}

	public void operate() {
		int k = 1;
		System.out.println(k + " th largest in array : "
				+ findKthLargest(arr, 0, length - 1, length - k));

	}

	// Using QuickSort's pivot finding method
	public int findKthLargest(int[] arr, int p, int q, int k) {

		if (p == q) {
			if (k == p) {
				return arr[p];
			} else {
				return -1;
			}
		}

		else if (p < q) {
			int pivot = findPivot(arr, p, q);

			if (pivot == k)
				return arr[pivot];
			if (pivot > k) {
				return findKthLargest(arr, 0, pivot - 1, k);
			} else {
				return findKthLargest(arr, pivot + 1, length - 1, k);
			}
		} else {
			return -1;
		}

	}

	public int findPivot(int[] arr, int p, int r) {

		int x = arr[r];
		int i = p - 1;

		for (int j = p; j < r; j++) {
			if (arr[j] <= x) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		arr[r] = arr[i + 1];
		arr[i + 1] = x;
		return i + 1;
	}

}
