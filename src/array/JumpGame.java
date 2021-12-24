package array;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of
 * the array.
 *
 * <p>Each element in the array represents your maximum jump length at that position.
 *
 * <p>Your goal is to reach the last index in the minimum number of jumps.
 *
 * <p>You can assume that you can always reach the last index.
 */
public class JumpGame {

  public static void main(String[] args) {
    JumpGame obj = new JumpGame();
    int[] nums = new int[] {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
    System.out.println(obj.jump(nums));
    System.out.println(obj.canJump(new int[] {3, 2, 1, 0, 4}));
  }

  /** Using greedy algorithm */
  public int jump(int[] nums) {

    if (nums == null || nums.length == 0 || nums.length == 1) return 0;
    int len = nums.length;
    if (len == 2) return 1;

    int jump = 0, currentStairs = 0, farthest = 0;

    for (int i = 0; i < len - 1; i++) {
      farthest = Math.max(farthest, i + nums[i]);

      if (i == currentStairs) {
        jump++;
        currentStairs = farthest;
      }
    }
    return jump;
  }

  /** Using greedy to identify whether it can jump or not. */
  public boolean canJump(int[] nums) {

    if (nums == null || nums.length == 0) return false;

    int len = nums.length;
    if (len == 1) return true;

    int currentStairs = 0, farthest = 0;

    for (int i = 0; i < len; i++) {
      farthest = Math.max(farthest, i + nums[i]);

      if (i == currentStairs) {
        currentStairs = farthest;
        if (currentStairs >= len - 1) return true;
      }
    }
    return false;
  }

  /**
   * Using the concept of ladders and stairs. <br>
   * Keep the largest ladders and use it to go up the stair. <br>
   * if stairs are done using current ladder, use last largest ladder and increase the jump count.
   *
   * <p>@see <a href="https://youtu.be/vBdo7wtwlXs">https://youtu.be/vBdo7wtwlXs</a>
   */
  public int jump_ladder(int[] nums) {

    if (nums == null || nums.length == 0 || nums.length == 1) return 0;
    int len = nums.length;
    if (len == 2) return 1;

    int jump = 1;
    int max_ladder = nums[0];
    int curr_stair = nums[0];

    for (int level = 1; level < len; level++) {
      if (level == len - 1) return jump;

      if (level + nums[level] > max_ladder) {
        max_ladder = level + nums[level];
      }
      curr_stair--;

      if (curr_stair == 0) {
        jump++;
        curr_stair = max_ladder - level;
      }
    }
    return jump;
  }

  /**
   * Precompute the jump array starting from end decision based on precomputed array (memoization)
   */
  public int jump_memoization(int[] nums) {

    if (nums == null || nums.length == 0 || nums.length == 1) return 0;

    int len = nums.length;
    if (len == 2) return 1;

    int[] pre = new int[len];

    //    pre[len - 2] = 1;
    for (int j = len - 2; j >= 0; j--) {
      if (nums[j] == 0) pre[j] = Integer.MAX_VALUE;
      else if (nums[j] + j >= len - 1) pre[j] = 1;
      else {
        // min of all index+1
        int min = Integer.MAX_VALUE;
        for (int i = j + 1; i < len - 1 && i <= (j + nums[j]); i++) {
          min = Math.min(min, pre[i]);
        }
        if (min == Integer.MAX_VALUE) pre[j] = Integer.MAX_VALUE;
        else pre[j] = 1 + min;
      }
    }
    return pre[0];
  }
}
