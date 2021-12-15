package dynamicprog;

import java.util.HashMap;
import java.util.Map;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 *
 * <p>Given an integer array nums representing the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 */
public class HouseRobbery {

  Map<Integer, Integer> map;

  HouseRobbery() {
    map = new HashMap<>();
  }

  public static void main(String[] args) {
    HouseRobbery houseRobbery = new HouseRobbery();
    System.out.println(houseRobbery.maxRobAmount(new int[]{2,7,9,3,1}));
  }

  public int maxRobAmount(int[] arr) {
    int len = arr.length;
    map.put(0, arr[0]);
    map.put(1, max(arr[0], arr[1]));

    return solution_bottom_up(arr);
  }

  private int solution_top_down(int[] arr, int index) {
    if (!map.containsKey(index)) {
      map.put(index, max(solution_top_down(arr, index - 1), solution_top_down(arr, index - 2) + arr[index]));
    }
    return map.get(index);
  }

  private int solution_bottom_up(int[] arr)
  {
    int len =arr.length;
    int[] dp = new int[len];
    dp[0] =arr[0];
    dp[1] = max(arr[0], arr[1]);

    for (int i=2; i<len; i++)
    {
      dp[i] = max(dp[i-1], dp[i-2]+arr[i]);
    }

    return dp[len-1];
  }


  private int max(int i, int j) {
    return i > j ? i : j;
  }
}
