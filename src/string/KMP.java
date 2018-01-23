package string;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[],
 * char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.
 * <p>
 * KMP algorithm works on the principle of finding prefix of a suffix in the current array
 * <p>
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 * <p>
 * Created by vikky.agrawal on 9/2/17.
 */
public class KMP
{
	public static void main(String[] args)
	{
		KMP object = new KMP();

		String text = "abxabcabcaby"; //length m
		String pattern = "abcaby";    //length n
		object.search(text, pattern);
	}

	/**
	 * Time complexity O(m+n)
	 * Space complexity O(n)
	 */
	public void search(String text, String pattern)
	{
		final char[] txt = text.toCharArray();
		final char[] patt = pattern.toCharArray();

		final int[] prefix = prefixArray(pattern);  // O(n)
		printArray(prefix);
		final int textLength = text.length();       //m
		final int patternLength = pattern.length(); //n

		int j = 0;
		for (int i = 0; i < textLength; i++) // O(m)
		{

			if (txt[i] == patt[j])
				j++;
			else if (j > 0)
			{
				j = prefix[j - 1]; //array index is 0 based so subtract 1
				i--;
			}
			if (j == patternLength)
			{
				System.out.println("\nPattern : " + pattern + " found in text : " + text);
				break;
			}
		}
	}

	// O(n)
	public int[] prefixArray(final String pattern)
	{
		final int length = pattern.length();
		final char[] arr = pattern.toCharArray();
		final int[] prefix = new int[length];
		int j = 0;
		for (int i = 1; i < length; i++)
		{
			if (arr[i] == arr[j])
			{
				prefix[i] = j + 1;
				j++;
			}
			else if (j > 0)
			{
				j = prefix[j - 1];
				i--; //decreasing index so it will point to same element in next comparison
			}
		}
		return prefix;
	}

	private void printArray(int[] arr)
	{
		for (int i : arr)
			System.out.print(i + " ");
	}

}
