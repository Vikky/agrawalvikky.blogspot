package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 *
 * <p>Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreak {

  public static void main(String[] args) {
    WordBreak wordBreak = new WordBreak();
    System.out.println(wordBreak.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
  }

  /** Using dynamic programming to store substring's result. */
  public boolean wordBreak(String s, List<String> wordDict) {

    Set<String> dict = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && dict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  /**
   * Store all dict words in HashSet. Find min length dictionary word. Start building the words from
   * input string and check if that exists in dict. <br>
   * (Doesn't work for all use cases.)
   */
  public boolean wordBreak_(String s, List<String> wordDict) {

    if (s == null || s.isEmpty()) return false;

    int min = 21;
    Set<String> set = new HashSet();

    for (int i = 0; i < wordDict.size(); i++) {
      String str = wordDict.get(i);
      min = min < str.length() ? min : str.length();
      set.add(str);
    }

    char[] arr = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      sb.append(arr[i]);
      if (sb.length() >= min) {
        if (set.contains(sb.toString())) sb = new StringBuilder();
      }
    }
    return sb.length() == 0;
  }
}
