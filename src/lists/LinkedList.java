package lists;

/**
 * Link List operations and solutions to few problems
 *
 * @author vikky.agrawal
 */

public class LinkedList
{

	Node node = null;
	Node palindromeRoot =null;
	Node left =null;


	public LinkedList()
	{
		this.node = new Node(10);
		this.palindromeRoot = new Node(1);
		add(palindromeRoot,2);
		add(palindromeRoot,3);
		add(palindromeRoot,2);
		add(palindromeRoot,1);
	}

	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
//		list.operations();

		Node right = list.palindromeRoot;
		System.out.println("Is palindrome : "+list.isPalindrome(right));
	}



	public void operations()
	{
		for (int i = 1; i < 6; i++)
		{
			add(node, (int) (Math.random() * 100));
		}

		/*
		 * System.out.println("Test: iterative, List before reversal");
		 * print(node); this.node=reverse(node);
		 * 
		 * 
		 * System.out.println("Test: recursive, List before reversal");
		 * print(node); this.node=this.recursiveReverse(node);
		 * System.out.println("After recursice reverse list is : ");
		 * print(node);
		 */

		this.rotateACW(node, 8);

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

		while (ptr1.getLink() != null)
		{
			ptr2 = ptr1;
			ptr1 = ptr1.getLink();
			ptr2.setLink(ptr3);
			ptr3 = ptr2;

		}
		ptr1.setLink(ptr2); // setting link for the last node;

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

		if (root == null || root.getLink() == null)
		{
			return root;
		}

		Node temp = recursiveReverse(root.getLink());

		// temp contains last element when recursion done; ie. temp always
		// points to last node while recursion done and returned
		// take 2/3 nodes and dry-run

		root.getLink().setLink(root);
		root.setLink(null);
		return temp;

	}

	/*
	 * Print reverse of the link list reccursively
	 */

	public void printReverseRecursive(Node root)
	{

		if (root.getLink() != null)
		{
			printReverseRecursive(root.getLink());
			System.out.println(root.getData());
		}
		else
		{
			System.out.println(root.getData());
		}
	}

	private boolean isPalindrome(Node right)
	{
		left= palindromeRoot;

		if (right == null)
			return true;

		boolean rp = isPalindrome(right.link);
		if (!rp)
			return false;

		boolean lp = left.data == right.data;
//		System.out.println("current left : "+left.data + " right is : "+right.data);
		left = left.link;
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

		while ((node.getLink() != null) && (--i > 0))
		{
			node = node.getLink();
		}

		if (node.getLink() != null)
		{
			while (node.getLink() != null)
			{
				nodeback = nodeback.getLink();
				node = node.getLink();
			}
		}

		System.out.println("N = " + n + " element from last is :" + nodeback.getData());

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
			hare = root.getLink();
			tortoise = root;
		}
		else
		{
			hare = root;
			tortoise = root;
		}

		while (hare != null && hare.getLink() != null)
		{
			hare = hare.getLink().getLink();
			tortoise = tortoise.getLink();
		}
		if (temp)
		{
			System.out.println("Middle elements :" + tortoise.getData() + " and " + tortoise.getLink().getData());
		}
		else
		{
			System.out.println("Middle element is :" + tortoise.getData());
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
			ptr = ptr.getLink();
		}

		Node temp = ptr;

		while (temp.getLink() != null)
		{
			temp = temp.getLink();
		}

		temp.setLink(root);
		ptr1.setLink(null);
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
			if (list1.getData() < list2.getData())
			{
				add(newList, list1.getData());
				list1 = list1.getLink();
			}
			else if (list1.getData() > list2.getData())
			{
				add(newList, list2.getData());
				list2 = list2.getLink();
			}
			else
			{
				add(newList, list2.getData());
				list1 = list1.getLink();
				list2 = list2.getLink();
			}
		}

		while (list1 != null)
		{
			add(newList, list1.getData());
			list1 = list1.getLink();
		}

		while (list2 != null)
		{
			add(newList, list2.getData());
			list2 = list2.getLink();
		}

		newList = newList.getLink();
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
		{
			return;
		}

		System.out.println("Before duplicate removal:");
		print(root);

		while (root != null)
		{

			if (root.getData() == root.getLink().getData())
			{
				Node ptr = root.getLink();
				while (ptr != null && ptr.getLink() != null && (ptr.getData() == ptr.getLink().getData()))
				{
					ptr = ptr.getLink();
				}
				root.setLink(ptr.getLink());
			}
			root = root.getLink();
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
		while (temp != null && temp.getLink() != null)
		{
			int data = temp.getData();
			temp.setData(temp.getLink().getData());
			temp.getLink().setData(data);
			temp = temp.getLink().getLink();
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
		if (pointer.getLink() != null)
		{
			pointer.setData(pointer.getLink().getData());
			pointer.setLink(pointer.getLink().getLink());
			return;
		}
		// otherwise
		else
		{
			// indicate that the node is deleted
			pointer.setData(-1);
		}
	}

	/*
	 * Helper functions for lists.LinkedList
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
			while (newptr.getLink() != null)
			{
				newptr = newptr.getLink();
			}
			newptr.setLink(new Node(data));
			newptr.getLink().setLink(null);
		}
	}

	public void print(Node ptr)
	{

		if (ptr == null)
		{
			return;
		}
		Node ptr1 = ptr;
		System.out.print(ptr1.getData() + "->");
		while ((ptr1 = ptr1.getLink()) != null)
		{
			System.out.print(ptr1.getData() + "->");
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
		while ((ptr1 = ptr1.getLink()) != null)
		{
			i++;
		}
		return i;
	}

	/*
	 * static inner class for lists.LinkedList Data Structure
	 */
	private static class Node
	{
		private int data;
		private Node link;

		Node()
		{

		}

		Node(int data)
		{
			// mergedList=new Node();
			this.setData(data);
			this.setLink(null);
		}

		public int getData()
		{
			return this.data;
		}

		public Node getLink()
		{
			return this.link;
		}

		public void setData(int data)
		{
			this.data = data;
		}

		public void setLink(Node link)
		{
			this.link = link;
		}
	}

}
