package string;

/**
 * Z algorithm to pattern matching
 * Time complexity - O(n + m)
 * Space complexity - O(n + m)
 * <p>
 * https://www.youtube.com/watch?v=CpZh4eF8QBw
 * Created by vikky.agrawal on 8/29/17.
 */
public class ZArray
{

	public static void main(String[] args)
	{
		final ZArray object = new ZArray();
		final String string = "aabxaabxcaabxaabxay";
		final String pattern = "aabx";
		object.match(pattern, string);
	}

	public void match(final String pattern, final String string)
	{
		final String str = pattern + "$" + string;
		final int length = str.length();
		int[] zarray = new int[length];
		populateZArray(zarray, str, length);

		final int patternLength = pattern.length();

		for (int i = 0; i < zarray.length; i++)
		{
			if (zarray[i] == patternLength)
				System.out.print("\nPattern can be found starting index at : " + (i - (patternLength + 1)));
		}

	}

	public void populateZArray(int[] zarray, final String str, int length)
	{
		//initialize first element with 0;
		zarray[0] = 0;
		for (int i = 1; i < length; )
		{
			int j = 0, k = i;
			while (str.charAt(j) == str.charAt(k) && k < length)
			{
				j++;
				k++;
			}
			zarray[i] = k - i;
			i = populateNext(i + 1, (k - i), length, zarray);
		}
		print(zarray);
	}

	private int populateNext(final int k, final int length, final int arrayLength, final int[] zarray)
	{
		int index = 1;
		for (int i = k; i < k + length && i < arrayLength; )
		{
			if (zarray[index] < k + length)
			{
				zarray[k] = zarray[index];
				index++;
				i++;
			}
			else
				return k;
		}
		return k;
	}

	private void print(int[] zarray)
	{
		for (int i = 0; i < zarray.length; i++)
			System.out.print(zarray[i] + " ");
	}

}
