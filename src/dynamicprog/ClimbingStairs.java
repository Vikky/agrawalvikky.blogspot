package dynamicprog;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * <p>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the
 * top?
 */
public class ClimbingStairs {

  Map<Integer, Integer> map;

  ClimbingStairs() {
    map = new HashMap<>();
    map.put(1, 1);
    map.put(2, 2);
  }

  public static void main(String[] args) {
    ClimbingStairs climbingStairs = new ClimbingStairs();
    System.out.println(climbingStairs.climb_top_bottom(6));
    System.out.println(climbingStairs.climb_bottom_up(6));
  }

  /** Top down - memoization at each step to avoid duplicate computation. */
  public int climb_top_bottom(int n) {
    if (n < 2) return map.get(n);

    if (!map.containsKey(n)) {
      map.put(n, climb_top_bottom(n - 1) + climb_top_bottom(n - 2));
    }
    return map.get(n);
  }

  /** Bottom up - building the array and storing the result. */
  public int climb_bottom_up(int n) {
    int[] arr = new int[n];
    arr[0] = 1;
    arr[1] = 2;

    if (n < 2) return arr[n - 1];

    for (int i = 2; i < n; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }

    return arr[n - 1];
  }
}
