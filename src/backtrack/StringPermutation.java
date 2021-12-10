package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {

  List<String> resultList = new ArrayList<>();

  public static void main(String[] args) {
    StringPermutation obj = new StringPermutation();
    obj.permutations("AABC");

    obj.resultList.forEach(
        str -> {
          System.out.println(str);
        });
  }

  public List<String> permutations(String str) {
    char[] input = str.toCharArray();
    Map<Character, Integer> map = new TreeMap<>();
    for (char c : input) map.put(c, map.getOrDefault(c, 0) + 1);

    char[] keys = new char[map.size()];
    int[] count = new int[map.size()];

    int index = 0;
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      keys[index] = entry.getKey();
      count[index] = entry.getValue();
      index++;
    }

    char[] result = new char[str.length()];
    buildPermutation(result, keys, count, 0);

    return null;
  }

  private void buildPermutation(char[] result, char[] keys, int[] count, int level) {
    if (level == result.length) {
      resultList.add(String.valueOf(result));
      return;
    }

    for (int i = 0; i < keys.length; i++) {
      if (count[i] == 0) continue;

      result[level] = keys[i];
      count[i]--;
      buildPermutation(result, keys, count, level + 1);
      count[i]++;
    }
  }
}
