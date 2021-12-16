package dynamicprog;

public class MaxScore {

  int n;
  int m;
  int[][] dp;
  int[] nums, multipliers;

  public static void main(String[] args) {
    MaxScore maxScore = new MaxScore();
    System.out.println(maxScore.maximumScore(new int[] {1, 2, 3}, new int[] {3, 2, 1}));
  }

  public int maximumScore(int[] nums, int[] multipliers) {

    n = nums.length;
    m = multipliers.length;

    if (n == 0 || m == 0) return 0;

    this.nums = nums;
    this.multipliers = multipliers;
    dp = new int[m][m];

    int profit = solution(0, 0);
    print(dp);
    return profit;
  }

  private int solution(int i, int left) {
    if (i == m) return 0;

    int mult = multipliers[i];
    int right = n - 1 - (i - left);
    if (dp[i][left] == 0) {
      dp[i][left] =
          max(
              mult * nums[left] + solution(i + 1, left + 1),
              mult * nums[right] + solution(i + 1, left));
    }
    return dp[i][left];
  }

  private int max(int a, int b) {
    return a > b ? a : b;
  }

  private void print(int[][] arr) {
    for (int[] ints : arr) {
      for (int anInt : ints) {
        System.out.println(anInt + " ");
      }
    }
  }
}
