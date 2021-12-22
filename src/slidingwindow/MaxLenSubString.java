package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/** Given a string s, find the length of the longest substring without repeating characters. */
public class MaxLenSubString {

  public static void main(String[] args) {

    MaxLenSubString obj = new MaxLenSubString();
    System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    System.out.println(obj.lengthOfLongestSubstring_map(" "));
  }

  /**
   * Keep the window sliding till condition met & update the counter. <br>
   * once the condition breaks, update first pointer.
   */
  public int lengthOfLongestSubstring(String s) {

    if (s == null || s.isEmpty()) return 0;

    int len = s.length();
    char[] chars = s.toCharArray();
    int[] arr = new int[200];

    int max = 0;
    int i = 0, j = 0;
    while (j < len) {
      char ch = chars[j];
      if (arr[ch] == 0) {
        arr[ch]++;
        max = Math.max(max, (j - i + 1));
        j++;
      } else {
        arr[chars[i]]--;
        i++;
      }
    }
    return max;
  }

  /**
   * Idea is to store last index of character to store in a map, so if its encountered again set i
   * to its next position. This is an optimization and no need to slow update, rather update to
   * next.
   */
  public int lengthOfLongestSubstring_map(String s) {
    if (s == null || s.isEmpty()) return 0;

    int len = s.length();
    char[] chars = s.toCharArray();
    int max = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0, j = 0; j < len; ) {
      char ch = chars[j];
      if (map.containsKey(ch)) i = Math.max(map.get(ch), i);

      map.put(ch, j + 1);
      max = Math.max(max, j - i + 1);
      j++;
    }
    return max;
  }
}
