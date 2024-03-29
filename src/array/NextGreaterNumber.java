package array;

import java.util.Arrays;

/**
 * Given a number, find the next greater number using same digits(or by rearranging the digits). For
 * example, if the given number is 1234 then next greater number would be 1243. For the input 1243,
 * next greater number would be 1324. If the input is 6938652 then the output should be the number
 * 6952368
 *
 * <p>Created by viagrawal on 3/10/18.
 *
 * <p>Check {@link NextPermutation} for cleaner implementation
 */
public class NextGreaterNumber {
  public static void main(String[] args) {
    int arr[] = new int[] {1, 9, 1, 7, 0};

    for (int i = arr.length - 1; i >= 0; i--) {
      int j = i - 1;
      while (j >= 0 && arr[j] > arr[i]) j--;
      if (i == 0 && j == -1) {
        System.out.println("Not possible");
        break;
      }
      if (j == -1) continue;
      swap(arr, findNextGreaterIndex(arr, j, arr[j], arr[i]), j);
      Arrays.sort(arr, j + 1, arr.length);
      break;
    }
    for (int a : arr) System.out.println(a);
  }

  /**
   * @param arr
   * @param index
   * @param element
   * @param min
   * @return
   */
  private static int findNextGreaterIndex(
      final int[] arr, final int index, final int element, int min) {
    for (int j = index + 1; j < arr.length; j++) {
      if (arr[j] > element && arr[j] <= min) return j;
    }
    return -1; // will never come here
  }

  private static void swap(final int[] arr, final int nextGreater, final int index) {
    int temp = arr[index];
    arr[index] = arr[nextGreater];
    arr[nextGreater] = temp;
  }
}
