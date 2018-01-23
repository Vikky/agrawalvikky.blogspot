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

	public LRUCache()
	{
		this.doublyLinkList = new DoublyLinkList();
		this.keyMap = new HashMap<>();
	}

	public static void main(String[] args)
	{
		final LRUCache cache = new LRUCache();

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
			Integer value = keyMap.get(pageNumber).value;
//			System.out.println(value);
		}
		else
		{
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

	public Node addAtHead(int data)
	{
		final Node current = new Node(data);
		if (isNull(head))
		{
			tail = current;
			head = current;
		}
		else
		{
			current.next = head;
			head.prev = current;
			head = current;
			tail.next = head;
		}
		return head;
	}

	public void deleteFromTail()
	{
		if (isNull(tail))
			return;
		if (head == tail)
			head = tail = null;

		Node temp = tail.prev;
		temp.next = head;
		tail.next = null;
		tail.prev = null;
		tail = temp;

	}

	public void printNodes()
	{
		Node ptr = head;

		if (isNull(ptr))
			return;

		while (ptr.next != head)
		{
			System.out.println(ptr.value);
			ptr = ptr.next;
		}
		System.out.println(ptr.value);
	}
}