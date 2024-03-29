package array;

import static java.lang.Math.max;

/**
 * https://www.techiedelight.com/trapping-rain-water-within-given-set-bars/ Trapping Rain Water
 * within given set of bars In trapping rain water problem, we need to find the maximum amount of
 * water that can be trapped within given set of bars where width of each bar is 1 unit.
 *
 * <p>Created by viagrawal on 3/16/18.
 */
public class RainWater {

  /**
   * O(n) with O(1) space complexity Idea is to find out max left and max right, (minimum of these
   * 2, minus bar height) will give the water storage Maintain 2 pointers for maximum in left and
   * maximum in right
   *
   * @param args
   */
  public static void main(String[] args) {

    //		int[] bars = { 7, 0, 4, 2, 5, 8, 6, 4, 0, 5 };
    int bars[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int length = bars.length;
    int left = 0, right = length - 1;
    int maxLeft = bars[left];
    int maxRight = bars[right];
    int water = 0;

    while (left < right) {
      if (bars[left] <= bars[right]) {
        maxLeft = max(maxLeft, bars[left]);
        water += (maxLeft - bars[left]);
        left++;
      } else {
        maxRight = max(maxRight, bars[right]);
        water += (maxRight - bars[right]);
        right--;
      }
    }
    System.out.println("max water that can be trapped : " + water);
  }
}
