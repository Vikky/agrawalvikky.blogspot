package array;

/**
 * http://www.techiedelight.com/find-majority-element-in-an-array-boyer-moore-majority-vote-algorithm/
 * Boyer–Moore majority vote algorithm – returns wrong value if no majority element present
 * <p>
 * 1. can be solved by sorting the array and checking mid with first/last
 * 2. Store frequency in Map and check if any frequency > n/2
 * <p>
 * Created by viagrawal on 3/10/18.
 */
public class MajorityElement
{

	public static void main(String[] args)
	{
		int arr[] = new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4 };

		int i = 0;
		int m = -1;

		for (int j = 0; j < arr.length; j++)
		{
			if (i == 0)
			{
				m = arr[j];
			}
			else if (m == arr[j])
			{
				i++;
			}
			else
				i--;
		}
		System.out.println("majority element : " + m);
	}
}