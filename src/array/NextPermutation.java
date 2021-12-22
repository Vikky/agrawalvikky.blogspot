package array;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 *
 * <p>If such an arrangement is impossible, it must rearrange it to the lowest possible order (i.e.,
 * sorted in ascending order).
 *
 * <p>The replacement must be in place and use only constant extra memory
 */
public class NextPermutation {

  int len;

  public static void main(String[] args) {
    NextPermutation nextPermutation = new NextPermutation();
    int[] arr = new int[] {4, 2, 0, 2, 3, 2, 0};
    nextPermutation.nextPermutation(arr);

    for (int i : arr) System.out.println(i);
  }

  /**
   * Algo: Start from end, find next less digit than current if found then find the next_max digit
   * than found digit. <br>
   * swap those 2 digits. <br>
   * sort the array from found index+1 <br.
   *
   * <P>
   * if not found that means array sorted in reverse order there can't be next greater permutation
   * so reverse the array. (Or return -1 depending on the question)
   */
  public void nextPermutation(int[] nums) {

    if (nums == null || nums.length == 0) return;

    this.len = nums.length;

    // Next small than the current. if array is sorted(reverse) then there won't be next small
    int index = findNextSmall(nums);
    if (index == -1) {
      reverse(nums);
      return;
    }
    int next_max = nextMax(nums, nums[index], index);
    swap(nums, index, next_max);
    Arrays.sort(nums, index + 1, len);
  }

  // O(n)
  private int findNextSmall(int[] nums) {
    for (int i = len - 1; i > 0; i--) {
      if (nums[i - 1] < nums[i]) return i - 1;
    }
    return -1;
  }

  private int nextMax(int[] nums, int val, int index) {
    for (int i = len - 1; i > index; i--) {
      if (nums[i] > val) return i;
    }
    return -1;
  }

  // O(n)
  private void reverse(int[] arr) {
    for (int i = 0, j = len - 1; i < j; i++, j--) {
      swap(arr, i, j);
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
