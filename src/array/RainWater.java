package array;

import static java.lang.Math.max;

/**
 * Trapping Rain Water within given set of bars
 * In trapping rain water problem, we need to find the maximum amount of water
 * that can be trapped within given set of bars where width of each bar is 1 unit.
 * <p>
 * Created by viagrawal on 3/16/18.
 */
public class RainWater
{

	/**
	 * O(n) with O(1) time complexity
	 * Idea is to find out max left and max right, (minimum of these 2, minus bar height) will give the water storage
	 * Maintain 2 pointers for maximum in left and maximum in right
	 * @param args
	 */

	public static void main(String[] args)
	{

		int[] bars = { 7, 0, 4, 2, 5, 8, 6, 4, 0, 5 };
		int length = bars.length;
		int left = 0, right = length - 1;
		int maxLeft = bars[left];
		int maxRight = bars[right];
		int water = 0;

		while (left < right)
		{
			if (bars[left] <= bars[right])
			{
				left++;
				maxLeft = max(maxLeft, bars[left]);
				water += (maxLeft - bars[left]);
			}
			else
			{
				right--;
				maxRight = max(maxRight, bars[right]);
				water += (maxRight - bars[right]);
			}
		}
		System.out.println("max water that can be trapped : " + water);
	}
}