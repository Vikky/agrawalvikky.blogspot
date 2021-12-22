package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i !=
 * j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * <p>Notice that the solution set must not contain duplicate triplets.
 *
 * <p>Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 */
public class TripletSum {

  List<List<Integer>> result = new ArrayList();
  int[] nums;
  int len = 0;

  public static void main(String[] args) {
    TripletSum tripletSum = new TripletSum();

    tripletSum.threeSum(new int[] {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0});

    tripletSum.result.forEach(
        list -> {
          list.forEach(val -> System.out.print(val + " "));
          System.out.println();
        });
  }

  public List<List<Integer>> threeSum(int[] nums) {

    if (nums == null || nums.length < 3) return result;

    this.nums = nums;
    this.len = nums.length;

    Arrays.sort(nums);

    for (int i = 0; i < len && nums[i] <= 0; ) {
      int val = nums[i];
      twoSum(0 - val, i + 1, len - 1);
      while (++i < len && nums[i] == val)
        ;
    }
    return result;
  }

  private void twoSum(int target, int start, int end) {
    for (int i = start, j = end; i < j; ) {
      int num1 = nums[i];
      int num2 = nums[j];
      int sum = num1 + num2;
      if (sum == target) {
        addResult(0 - target, nums[i], nums[j]);
        while (++i < j && nums[i] == num1)
          ;
        while (--j > i && nums[j] == num2)
          ;
        continue;
      }

      if (sum < target) i++;
      else j--;
    }
  }

  private void addResult(int a, int b, int c) {
    List<Integer> list = new ArrayList();
    list.add(a);
    list.add(b);
    list.add(c);
    result.add(list);
  }
}
