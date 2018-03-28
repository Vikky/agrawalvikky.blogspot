package array;

/**
 * Created by viagrawal on 3/28/18.
 */
public class EquilibriumIndex
{

	/**
	 * O(n) solution, idea is to keep adding and subtracting current from left and right sum.
	 * No extra space required.
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{
		int nums[] = { 0, -3, 5, -4, -2, 3, 1, 0 };
		int length = nums.length;

		int totalSum = 0;

		for (int i = 0; i < length; i++)
		{
			totalSum += nums[i];
		}
		int leftSum = 0;
		int rightSum = totalSum;

		for (int i = 1; i < length; i++)
		{
			leftSum += nums[i - 1];
			rightSum -= nums[i];

			if (leftSum == rightSum)
				System.out.println("Equilibrium index found at : " + i);
		}
	}
}