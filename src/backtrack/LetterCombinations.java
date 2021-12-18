package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

  List<String> result = new ArrayList();
  Map<Character, String> map =
      Map.of(
          '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqr", '8', "stu", '9',
          "wxyz");

  String digits;
  int len;

  public static void main(String[] args) {
    LetterCombinations obj = new LetterCombinations();
    List<String> combinations = obj.letterCombinations("23");
    combinations.forEach(str -> System.out.println(str));
  }

  public List<String> letterCombinations(String digits) {

    if (digits == null || digits.isEmpty()) return result;

    this.digits = digits;
    this.len = digits.length();

    backtrack(0, new StringBuilder());

    return result;
  }

  private void backtrack(int index, StringBuilder path) {
    if (path.length() == len) {
      result.add(path.toString());
      return;
    }

    String letters = map.get(digits.charAt(index));

    for (char ch : letters.toCharArray()) {
      path.append(ch);
      backtrack(index + 1, path);
      path.deleteCharAt(path.length() - 1);
    }
  }
}
