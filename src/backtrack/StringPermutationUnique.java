package backtrack;

/**
 * Created by viagrawal on 3/30/18.
 */
public class StringPermutationUnique
{

	public static void main(String[] args)
	{
		StringPermutationUnique stringPermutation = new StringPermutationUnique();

		String string = "ABC";
		stringPermutation.permute(string, 0, string.length() - 1);

	}

	private void permute(String str, int l, int r)
	{
		if (l == r)
			System.out.println(str);
		else
		{
			for (int i = l; i <= r; i++)
			{
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String str, int i, int j)
	{
		char[] charArray = str.toCharArray();
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
