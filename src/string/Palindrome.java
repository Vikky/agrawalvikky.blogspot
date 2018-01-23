package string;

import static java.lang.Character.isLetter;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Created by viagrawal on 8/28/17.
 */
public class Palindrome
{

	public static void main(String[] args)
	{
		Palindrome object = new Palindrome();

		System.out.println(object.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(object.isPalindrome("race a car"));
	}


	public boolean isPalindrome(final String str)
	{
		char[] array = str.toCharArray();
		int start = 0, end = array.length - 1;

		while (start <= end)
		{
			if (!isLetter(array[start]))
			{
				start++;
				continue;
			}
			if (!isLetter(array[end]))
			{
				end--;
				continue;
			}
			if (!(""+array[start]).equalsIgnoreCase(""+array[end]))
			{
				return false;
			}
			start++;
			end--;
		}
		return true;
	}


}
