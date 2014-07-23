/**
 * @author Vikky.Agrawal
 * 
 */
public class StringOperations {

	public static void main(String[] args) {
		StringOperations obj = new StringOperations();
		obj.operate();
	}

	public void operate() {
		// index: //01234567890123456789012
		findPatternNaive("ABC ABCDAB ABCDABCDABDE", "ABCDAB");
		findPatternNaive("AABAACAADAABAAABAA", "AB");
	}

	/*
	 * O(mn) solution m=string length, n=pattern length
	 */
	public void findPatternNaive(String string, String pattern) {

		if (string == null || pattern == null) {
			System.out.println("String or pattern null ");
			return;
		}

		int stringlen = string.length();
		int patternlen = pattern.length();

		for (int i = 0; i < stringlen - patternlen; i++) {

			if (string.charAt(i) == pattern.charAt(0)) {

				int temp = i + 1;
				boolean found = false;

				for (int j = 1; j < patternlen && (i <= stringlen - patternlen); j++) {

					if (string.charAt(temp) != pattern.charAt(j)) {
						found = false;
						break;
					} else {
						found = true;
					}
					temp++; // increment pointer in original text.
				}

				if (found) {
					System.out.println("Match found at index : " + i);
				}
			}
		}
	}

	public void findPatternKMP(String string, String pattern) {

		if (string == null || pattern == null) {
			System.out.println("String or pattern null ");
			return;
		}

		int stringlen = string.length();
		int patternlen = pattern.length();

		for (int i = 0; i <= stringlen - patternlen; i++) {

			if (string.charAt(i) == pattern.charAt(0)) {

				int temp = i + 1;
				boolean found = false;

				for (int j = 1; j < patternlen && (i <= stringlen - patternlen); j++) {

					if (string.charAt(temp) != pattern.charAt(j)) {
						found = false;
						break;
					} else {
						found = true;
					}
					temp++; // increment pointer in original text.
				}

				if (found) {
					System.out.println("Match found at index : " + i);
				}
			}
		}
	}

}
