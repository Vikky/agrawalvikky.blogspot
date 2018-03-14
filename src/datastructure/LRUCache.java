package datastructure;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

/**
 * Created by viagrawal on 1/20/18.
 */
public class LRUCache
{

	private DoublyLinkList doublyLinkList;
	private Map<Integer, Node> keyMap;
	private int cacheSize;

	public LRUCache(int cacheSize)
	{
		this.cacheSize = cacheSize;
		this.doublyLinkList = new DoublyLinkList(cacheSize);
		this.keyMap = new HashMap<>(cacheSize);
	}

	public static void main(String[] args)
	{
		final LRUCache cache = new LRUCache(4);

		cache.accessPage(4);
		cache.accessPage(2);
		cache.accessPage(1);
		cache.accessPage(1);
		cache.accessPage(4);
		cache.accessPage(3);
		cache.accessPage(7);
		cache.accessPage(8);
		cache.accessPage(3);

		cache.doublyLinkList.printNodes();
	}

	public void accessPage(int pageNumber)
	{
		if (keyMap.containsKey(pageNumber))
		{
			final Node ptr = keyMap.get(pageNumber);
			doublyLinkList.moveToHead(ptr);
		}
		else
		{
			if (doublyLinkList.currentSize == cacheSize)
			{
				keyMap.remove(pageNumber);
			}
			this.keyMap.put(pageNumber, doublyLinkList.addAtHead(pageNumber));
		}
	}
}

class Node
{
	Node prev;
	Node next;
	Integer value;

	Node(Integer value)
	{
		this.value = value;
	}
}

class DoublyLinkList
{

	Node head;
	Node tail;
	int size;
	int currentSize;

	DoublyLinkList(int size)
	{
		this.size = size;
		this.currentSize = 0;
	}

	public Node addAtHead(int data)
	{
		final Node current = new Node(data);
		if (isNull(head))
		{
			tail = current;
			head = current;
			currentSize++;
			return current;
		}
		if (currentSize < size)
			currentSize++;
		else
		{
			//remove tail, no need to increase size
			tail = tail.prev;
			tail.next = null;
		}
		current.next = head;
		head.prev = current;
		head = current;
		return current;
	}

	public void moveToHead(Node ptr)
	{
		if (ptr == null || ptr == head)
			return;

		if (ptr == tail)
		{
			tail = tail.prev;
			tail.next = null;
		}
		else
		{
			ptr.next.prev = ptr.prev;
			ptr.prev.next = ptr.next;
		}
		currentSize--;
		addAtHead(ptr.value);
	}

	public void printNodes()
	{
		Node ptr = head;

		if (isNull(ptr))
			return;

		while (ptr.next != tail)
		{
			System.out.println(ptr.value);
			ptr = ptr.next;
		}
		System.out.println(ptr.value);
	}
}