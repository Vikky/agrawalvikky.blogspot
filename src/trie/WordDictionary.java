package trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

  TrieNode head;

  public WordDictionary() {
    head = new TrieNode();
  }

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();

    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    System.out.println(wordDictionary.search("pad")); // return False
    System.out.println(wordDictionary.search("bad")); // return True
    System.out.println(wordDictionary.search(".ad")); // return True
    System.out.println(wordDictionary.search("b..")); // return True
  }

  public void addWord(String word) {
    if (word == null) return;

    char[] arr = word.toCharArray();
    TrieNode node = head;

    for (char c : arr) {
      if (!node.map.containsKey(c)) {
        node.map.put(c, new TrieNode());
      }
      node = node.map.get(c);
    }
    node.key = word;
  }

  public boolean search(String word) {
    if (word == null) return false;

    char[] arr = word.toCharArray();
    TrieNode node = head;

    for (char c : arr) {
      if (node == null) return false;
      if (c == '.') continue;
      if (!node.map.containsKey(c)) return false;
      node = node.map.get(c);
    }
    return node.key != null;
  }

  static class TrieNode {
    String key;
    Map<Character, TrieNode> map = new HashMap();
  }
}
