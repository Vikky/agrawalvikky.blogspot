package lists;

/**
 * Link List operations and solutions to few problems
 *
 * @author vikky.agrawal
 */

public class LinkedList
{

	Node node = null;
	Node palindromeRoot = null;
	Node left = null;

	public LinkedList()
	{
		this.node = new Node(10);
		this.palindromeRoot = new Node(1);
		add(palindromeRoot, 2);
		add(palindromeRoot, 3);
		add(palindromeRoot, 2);
		add(palindromeRoot, 1);
	}

	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
//		list.operations();

		//		Node right = list.palindromeRoot;
		//		System.out.println("Is palindrome : " + list.isPalindrome(right));

//		list.testCycle();
		list.operations();
	}

	public void testCycle()
	{
		for (int i = 1; i < 6; i++)
		{
			add(node,i);
		}
		System.out.println(isCycleInList(node));
		Node temp = node;
		temp.next.next = node;
		System.out.println(isCycleInList(node));
	}


	public void operations()
	{
		for (int i = 1; i < 6; i++)
		{
			add(node, (int) (Math.random() * 100));
		}

		//		System.out.println("Test: iterative, List before reversal");
		//		print(node);
		//		this.node = reverse(node);

		System.out.println("Test: recursive, List before reversal");
		print(node);
		this.node = this.recursiveReverse(node);
		System.out.println("After recursice reverse list is : ");
		print(node);

		//		this.rotateACW(node, 8);

	}

	public boolean isCycleInList(Node root)
	{
		if (root == null)
			return false;

		Node slowPtr = root;
		Node fastPtr = root.next;

		while (fastPtr != null)
		{
			if (slowPtr == fastPtr || slowPtr == fastPtr.next)
			{
				return true;
			}

			slowPtr = slowPtr.next;
			if (fastPtr.next != null)
				fastPtr = fastPtr.next.next;
			else
				break;
		}
		return false;
	}
	/*
	 * Reverse a linked list iterative. Using auxiliary pointers.
	 */

	public Node reverse(Node ptr)
	{

		if (ptr == null)
		{
			System.out.println("List is empty:returning");
			return null;
		}
		Node ptr1 = ptr;
		Node ptr2 = ptr;
		Node ptr3 = null;

		while (ptr1.next != null)
		{
			ptr2 = ptr1;
			ptr1 = ptr1.next;
			ptr2.next = ptr3;
			ptr3 = ptr2;

		}
		ptr1.next = ptr2; // setting link for the last node;

		System.out.println("Reversed List :");
		this.print(ptr1);
		return ptr1;
	}

	/*
	 * RecursiveReverse() Use cases: What is the reverse of null (the empty
	 * list)? null. What is the reverse of a one element list? the element. What
	 * is the reverse of an n element list? the reverse of the second element on
	 * followed by the first element.
	 */

	public Node recursiveReverse(Node root)
	{

		// base case

		if (root == null || root.next == null)
		{
			return root;
		}

		Node temp = recursiveReverse(root.next);

		// temp contains last element when recursion done; ie. temp always
		// points to last node while recursion done and returned
		// take 2/3 nodes and dry-run
		root.next.next = root;
		root.next = null;
		return temp;
	}

	/*
	 * Print reverse of the link list reccursively
	 */

	public void printReverseRecursive(Node root)
	{

		if (root.next != null)
		{
			printReverseRecursive(root.next);
			System.out.println(root.data);
		}
		else
		{
			System.out.println(root.data);
		}
	}

	private boolean isPalindrome(Node right)
	{
		left = palindromeRoot;

		if (right == null)
			return true;

		boolean rp = isPalindrome(right.next);
		if (!rp)
			return false;

		boolean lp = left.data == right.data;
		//		System.out.println("current left : "+left.data + " right is : "+right.data);
		left = left.next;
		return lp;
	}

	public void printNthFromLast(Node root, int n)
	{

		int i = n;
		if (root == null)
		{
			return;
		}

		if (i > size(root))
		{
			System.out.println("Not enough elements");
			return;
		}

		Node node = root;
		Node nodeback = root;

		while ((node.next != null) && (--i > 0))
		{
			node = node.next;
		}

		if (node.next != null)
		{
			while (node.next != null)
			{
				nodeback = nodeback.next;
				node = node.next;
			}
		}

		System.out.println("N = " + n + " element from last is :" + nodeback.data);

	}

	/*
	 * Print middle element using slow and fast pointers.
	 */

	public void printMiddle(Node root)
	{
		if (root == null)
		{
			return;
		}

		System.out.println("Linked list is ");
		print(root);

		Node hare = null;
		Node tortoise = null;
		boolean temp = false;
		if (size(root) % 2 == 0)
			temp = true;

		if (temp)
		{
			hare = root.next;
			tortoise = root;
		}
		else
		{
			hare = root;
			tortoise = root;
		}

		while (hare != null && hare.next != null)
		{
			hare = hare.next.next;
			tortoise = tortoise.next;
		}
		if (temp)
		{
			System.out.println("Middle elements :" + tortoise.data + " and " + tortoise.next.data);
		}
		else
		{
			System.out.println("Middle element is :" + tortoise.data);
		}
	}

	/*
	 * Rotate a linked list Anti clock wise for given number of nodes
	 */

	public void rotateACW(Node root, int n)
	{

		if (root == null || n <= 0)
		{
			return;
		}

		int size = size(root);
		if (n == size)
		{
			// no need to rotate, as it will be the same
			System.out.println("List after rotating");
			print(root);
			return;
		}

		if (n > size)
		{
			n = n % size;
		}

		System.out.println("List Before rotating");
		print(root);

		Node ptr = root;
		Node ptr1 = null;

		while (n-- > 0)
		{
			ptr1 = ptr;
			ptr = ptr.next;
		}

		Node temp = ptr;

		while (temp.next != null)
		{
			temp = temp.next;
		}

		temp.next = root;
		ptr1.next = null;
		root = ptr;

		System.out.println("List after rotating");
		print(root);

	}

	/*
	 * Program to get Union of 2 linked Lists Assuming given lists are
	 * sorted(with unique elements)
	 */

	public void getUnion(Node list1, Node list2)
	{

		if (list1 == null && list2 == null)
		{
			return;
		}

		System.out.println("List 1:");
		print(list1);

		System.out.println("List 2: ");
		print(list2);

		Node newList = new Node();

		while (list1 != null && list2 != null)
		{
			if (list1.data < list2.data)
			{
				add(newList, list1.data);
				list1 = list1.next;
			}
			else if (list1.data > list2.data)
			{
				add(newList, list2.data);
				list2 = list2.next;
			}
			else
			{
				add(newList, list2.data);
				list1 = list1.next;
				list2 = list2.next;
			}
		}

		while (list1 != null)
		{
			add(newList, list1.data);
			list1 = list1.next;
		}

		while (list2 != null)
		{
			add(newList, list2.data);
			list2 = list2.next;
		}

		newList = newList.next;
		System.out.println("Union of lists:");
		print(newList);

	}

	/*
	 * Program to remove duplicate from Linked List Assume list is sorted Have
	 * to do Inplace
	 */

	public void removeDuplicates(Node node)
	{
		Node root = node;
		if (root == null)
			return;

		System.out.println("Before duplicate removal:");
		print(root);

		while (root != null)
		{
			if (root.data == root.next.data)
			{
				Node ptr = root.next;
				while (ptr != null && ptr.next != null && (ptr.data == ptr.next.data))
				{
					ptr = ptr.next;
				}
				root.next = ptr.next;
			}
			root = root.next;
		}
		System.out.println("After duplicate removal");
		print(node);
	}

	/*
	 * Given a singly linked list, swap every two nodes e.g. 1->2->3->4->5->6
	 * should become 2->1->4->3->6->5
	 */

	public void swap(Node root)
	{

		if (root == null)
		{
			return;
		}

		System.out.println("before swap : ");
		print(root);

		Node temp = root;
		while (temp != null && temp.next != null)
		{
			int data = temp.data;
			temp.data = temp.next.data;
			temp.next.data = data;
			temp = temp.next.next;
		}
		System.out.println("After swap");
		print(root);

	}

	/*
	 * You are given a pointer to a node in a singly linked list. Delete that
	 * node from the linked list. Pointer to previous node is not available.
	 */

	public void deleteNodePointer(Node pointer)
	{
		if (pointer == null)
		{
			return;
		}

		// in case its not last node
		if (pointer.next != null)
		{
			pointer.data = pointer.next.data;
			pointer.next = pointer.next.next;
			return;
		}
		// otherwise
		else
		{
			// indicate that the node is deleted
			pointer.data = -1;
		}
	}

	/*
	 * Helper functions for lists.nextedList
	 */
	public void add(Node ptr, int data)
	{
		if (ptr == null)
		{
			System.out.println("Always null ?");
			ptr = new Node(data);
		}
		else
		{
			Node newptr = ptr;
			while (newptr.next != null)
			{
				newptr = newptr.next;
			}
			newptr.next = new Node(data);
			newptr.next.next = null;
		}
	}

	public void print(Node ptr)
	{

		if (ptr == null)
		{
			return;
		}
		Node ptr1 = ptr;
		System.out.print(ptr1.data + "->");
		while ((ptr1 = ptr1.next) != null)
		{
			System.out.print(ptr1.data + "->");
		}
		System.out.println("/n");

	}

	public int size(Node ptr)
	{

		if (ptr == null)
		{
			return -1;
		}
		Node ptr1 = ptr;
		int i = 1;
		while ((ptr1 = ptr1.next) != null)
		{
			i++;
		}
		return i;
	}

	/*
	 * static inner class for lists.nextedList Data Structure
	 */
	private static class Node
	{
		private int data;
		private Node next;

		Node(int data)
		{
			this.data = data;
			this.next = null;
		}

		public Node()
		{

		}
	}

}
