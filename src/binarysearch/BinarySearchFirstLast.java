package binarysearch;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
 * position of a given target value.
 *
 * <p>If target is not found in the array, return [-1, -1].
 *
 * <p>You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearchFirstLast {

  public static void main(String[] args) {
    BinarySearchFirstLast bs = new BinarySearchFirstLast();
    int[] result = bs.searchRange(new int[] {0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10}, 4);
    System.out.println(result[0]);
    System.out.println(result[1]);
  }

  /**
   * Algo: Find pos by binary search; using this pos find_first (breaking cond ; start== val or
   * mid-1< val otherwise update) find second (breaking cond ; end== val or mid+1 > val otherwise
   * update)
   */
  public int[] searchRange(int[] nums, int target) {

    if (nums == null || nums.length == 0) return new int[] {-1, -1};

    int len = nums.length;
    int pos = binarySearch(nums, target, 0, len - 1);
    if (pos == -1) return new int[] {-1, -1};

    int[] result = new int[2];
    int start = -1, end = -1;

    if (pos == 0 || nums[pos - 1] < target) start = pos;
    else if (nums[0] == target) start = 0;
    else start = findStart(nums, target, 0, pos);
    if (pos == len - 1 || nums[pos + 1] > target) end = pos;
    else if (nums[len - 1] == target) end = len - 1;
    else end = findEnd(nums, target, pos, len - 1);

    result[0] = start;
    result[1] = end;
    return result;
  }

  private int binarySearch(int[] nums, int val, int start, int end) {
    if (start <= end) {
      int mid = (start + end) / 2;

      if (nums[mid] == val) return mid;

      if (val > nums[mid]) return binarySearch(nums, val, mid + 1, end);

      return binarySearch(nums, val, start, mid - 1);
    }
    return -1;
  }

  private int findStart(int[] nums, int val, int start, int end) {
    if (start <= end) {
      int mid = (start + end) / 2;

      if (mid == 0) return mid;

      if (nums[mid] < val && nums[mid + 1] == val) return mid + 1;
      if (nums[mid - 1] < val && nums[mid] == val) return mid;

      if (nums[mid] == val) return findStart(nums, val, start, mid);
      else return findStart(nums, val, mid + 1, end);
    }
    return -1;
  }

  private int findEnd(int[] nums, int val, int start, int end) {
    if (start <= end) {
      int mid = (start + end) / 2;

      if (mid == nums.length - 1) return mid;

      if (nums[mid] > val && nums[mid - 1] == val) return mid - 1;
      if (nums[mid] == val && nums[mid + 1] > val) return mid;

      if (nums[mid] == val) return findEnd(nums, val, mid, end);
      else return findEnd(nums, val, start, mid - 1);
    }
    return -1;
  }
}
