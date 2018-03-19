package trie;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Find first k maximum occurring words in given set of strings
 * http://www.techiedelight.com/find-first-k-maximum-occurring-words-given-set-strings/
 * <p>
 * Created by viagrawal on 3/19/18.
 */
public class MaxWordsCount
{

	public static void main(String[] args)
	{
		String[] dict = { "hell", "hello", "hello", "hello", "hello", "hello", "hero", "hero", "hero", "hello", "hello",
				"hello", "home", "go", "go", };

		MaxWordsCount object = new MaxWordsCount();
		object.printKFrequentWords(dict, 3);

	}

	private void printKFrequentWords(String[] dict, int k)
	{

		Trie head = new Trie();

		for (String key : dict)
			insert(head, key);

		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

		preOrder(head, priorityQueue);

		while (k-- > 0 && !priorityQueue.isEmpty())
		{
			Node node = priorityQueue.poll();
			System.out.println("key : " + node.key + ", having count : " + node.count);
		}
	}

	private void insert(Trie head, String str)
	{
		if (str == null || str.isEmpty())
			return;

		Trie current = head;

		for (char c : str.toCharArray())
		{
			if (!current.trieMap.containsKey(c))
			{
				current.trieMap.put(c, new Trie());
			}
			current = current.trieMap.get(c);
		}
		current.count += 1;
		current.key = str;
	}

	private void preOrder(Trie head, PriorityQueue<Node> priorityQueue)
	{
		if (head == null)
			return;

		for (Map.Entry<Character, Trie> trieEntry : head.trieMap.entrySet())
		{
			if (trieEntry.getValue().count != 0)
			{
				priorityQueue.add(new Node(trieEntry.getValue().count, trieEntry.getValue().key));
			}
			preOrder(trieEntry.getValue(), priorityQueue);
		}

	}

	private static class Trie
	{
		int count;
		String key;
		Map<Character, Trie> trieMap = new HashMap<>();
	}

	private static class Node implements Comparable
	{
		int count;
		String key;

		Node(int count, String key)
		{
			this.count = count;
			this.key = key;
		}

		@Override
		public int compareTo(final Object o)
		{
			Node node = (Node) o;
			return this.count - node.count;
		}
	}

}
