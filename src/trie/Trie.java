package trie;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

/**
 * Created by viagrawal on 7/3/17.
 */
public class Trie
{
	private TrieNode root;

	public Trie()
	{
		root = new TrieNode();
	}

	public static void main(String[] args)
	{
		final Trie trie = new Trie();

		trie.insert("dog");
//		trie.insert("dog");        //testing duplicates
		trie.insert("dogs");    //testing words having prefixes
//		trie.insert("abc");

//		System.out.println(trie.search("dog"));
		System.out.println(trie.search("dogs"));
//		System.out.println(trie.search("abc"));
//
//		System.out.println(trie.search("do"));
//		System.out.println(trie.search("dogss"));
	}

	public void insert(final String word)
	{
		if (isNull(word) || isEmpty(word))
			return;

		if (search(word))
			return;

		final char[] chars = word.toCharArray();
		final int length = chars.length;
		TrieNode pointer = root;

		for (int index = 0; index < length; index++)
		{
			TrieNode child = pointer.children.get(chars[index]);
			if (isNull(child))
			{
				final TrieNode newNode = new TrieNode();
				if (index == length - 1)
					newNode.endOfWord = true;
				pointer.children.put(chars[index], newNode);
			}
			pointer = pointer.children.get(chars[index]);
		}
	}

	public boolean search(final String word)
	{
		if (isNull(word) || isEmpty(word))
			return false;

		final char[] chars = word.toCharArray();
		final int length = chars.length;
		TrieNode pointer = root;

		for (int index = 0; index < length; index++)
		{
			pointer = pointer.children.get(chars[index]);
			if (isNull(pointer))
				return false;
			if (index == length - 1 && pointer.endOfWord)
				return true;
		}
		return false;
	}

	//TODO complete
	public void delete(final String word)
	{
		if (isNull(word) || isEmpty(word))
			return ;

		if (!search(word))
		{
			System.out.println("word doesn't exists, can't be deleted");
			return;
		}




	}

	private void deleteRecursive(final String word, final int index)
	{



	}



	private static class TrieNode
	{
		private Map<Character, TrieNode> children;
		private boolean endOfWord;

		TrieNode()
		{
			this.children = new HashMap<>();
		}
	}

	private boolean isEmpty(final String word)
	{
		return isNull(word) || word.trim().length() == 0;
	}
}
