package backtrack;

import java.util.*;

public class WordLadder {

  List<List<String>> result = new ArrayList<>();
  String beginWord;
  String endWord;
  int size;
  int smallest = 0;

  public static void main(String[] args) {
    WordLadder wordLadder = new WordLadder();

    List<String> wordList = new ArrayList<>();
    String[] words =
        new String[] {
          "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
          "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr",
          "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as",
          "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
          "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st",
          "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr",
          "pa", "he", "lr", "sq", "ye"
        };
    for (String s : words) wordList.add(s);

    List<List<String>> strings = wordLadder.findLadders("qa", "sq", wordList);
    strings.forEach(
        str -> {
          str.forEach(
              strs -> {
                System.out.print(strs + "->");
              });
          System.out.println();
        });
  }

  /**
   * Algo : Store all the words having hamming distance 1 in the list Do a DFS and find possible
   * solution and store in list. check if found solution length is lesser than replace else return
   * all solutions.
   */
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

    if (beginWord == null || endWord == null || beginWord.length() != endWord.length())
      return result;

    this.size = wordList.size();
    this.beginWord = beginWord;
    this.endWord = endWord;
    Map<String, List<String>> hamming = new HashMap<>();

    for (int i = 0; i < wordList.size(); i++) {
      List<String> list = new ArrayList<>();
      String current = wordList.get(i);
      for (int j = 0; j < wordList.size(); j++) {
        if (i == j) continue;

        String compare = wordList.get(j);
        if (isHammingWord(current, compare)) list.add(compare);
      }
      hamming.put(current, list);
    }

    System.out.println("testing ");

    for (int i = 0; i < wordList.size(); i++) {
      String start = wordList.get(i);
      if (isHammingWord(beginWord, start)) {

        List<String> path = new ArrayList<>();
        path.add(start);
        dfs(hamming, start, endWord, path);
      }
    }
    return result;
  }

  private void dfs(Map<String, List<String>> hamming, String start, String end, List<String> path) {

    if (start.equalsIgnoreCase(end)) {
      processPath(path);
      return;
    }

    if (path.size() == size) return;

    List<String> neighbour = hamming.get(start);

    for (int i = 0; i < neighbour.size(); i++) {
      String next = neighbour.get(i);
      if (!path.contains(next)) {
        path.add(next);
        dfs(hamming, next, end, path);
        path.remove(path.size() - 1);
      }
    }
  }

  private void processPath(List<String> path) {

    List<String> cloned = new ArrayList<>(path);
    if (!cloned.get(0).equals(beginWord)) cloned.add(0, beginWord);
    int size = cloned.size();

    if (result.isEmpty()) {
      result.add(cloned);
      smallest = size;
    } else {
      if (size > smallest) return;
      if (size == smallest) result.add(cloned);
      else {
        smallest = size;
        for (int i = result.size() - 1; i >= 0; i--) result.remove(i);
        result.add(cloned);
      }
    }
  }



  private boolean isHammingWord(String first, String second) {
    int count = 0;

    for (int i = 0; i < first.length(); i++) {
      char ch1 = first.charAt(i);
      char ch2 = second.charAt(i);
      if (ch1 != ch2) count++;
      if (count > 1) return false;
    }
    return count == 1;
  }
}
