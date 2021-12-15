package dynamicprog;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once
 * you pay the cost, you can either climb one or two steps.
 *
 * <p>You can either start from the step with index 0, or the step with index 1.
 *
 * <p>Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs {

  public static void main(String[] args) {
    MinCostClimbingStairs climbingStairs = new MinCostClimbingStairs();
    System.out.println(climbingStairs.solution_bottom_up(new int[]{1,100,1,1,1,100,1,1,100,1}));
  }

  private int solution_bottom_up(int[] cost) {
    int len = cost.length;
    int[] dp = new int[len];
    dp[0] = cost[0];
    dp[1] = min(cost[0], cost[1]);

    for (int i = 2; i < len; i++) {
      dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
    }

    return dp[len - 1];
  }

  private int min(int a, int b) {
    return a < b ? a : b;
  }
}
