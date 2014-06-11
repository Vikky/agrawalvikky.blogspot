public class LinkedList {

	LinkNode node = null;

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.operations();

	}

	public void operations() {

		this.node = new LinkNode(10);

		for (int i = 1; i < 6; i++) {
			add(node, (int) (Math.random() * 100));
		}

		/*System.out.println("Before reversal"); 
		print(node);
		reverse(node); */
		
		
		printNthFromLast(node, 6);
		System.out.println("Print again"); 
		print(node);
		
		
		printMiddle(node);

		rotateACW(node, 6);

		// testing union of two lists
		 LinkNode list1=new LinkNode(2); 
		  LinkNode list2=new LinkNode(2);
		  
		  for(int i=5;i<15;i++){ 
			  add(list1, i); 
			  add(list2, i+2); 
		  }
		  
		  
		  getUnion(list1, list2);
		 

		LinkNode duplicateList = new LinkNode(3);
		add(duplicateList, 3);
		add(duplicateList, 3);
		add(duplicateList, 4);
		add(duplicateList, 4);
		add(duplicateList, 5);
		add(duplicateList, 5);
		add(duplicateList, 6);
		add(duplicateList, 7);
		add(duplicateList, 8);
		add(duplicateList, 8);
		add(duplicateList, 8);

		removeDuplicates(duplicateList);

	}

	public void add(LinkNode ptr, int data) {
		if (ptr == null) {
			System.out.println("Always null ?");
			ptr = new LinkNode(data);
		} else {
			LinkNode newptr = ptr;
			while (newptr.getLink() != null) {
				newptr = newptr.getLink();
			}
			newptr.setLink(new LinkNode(data));
			newptr.getLink().setLink(null);
		}
	}

	public void print(LinkNode ptr) {

		if (ptr == null) {
			return;
		}
		LinkNode ptr1 = ptr;
		System.out.print(ptr1.getData() + "->");
		while ((ptr1 = ptr1.getLink()) != null) {
			System.out.print(ptr1.getData() + "->");
		}
		System.out.println("/n");

	}

	public int size(LinkNode ptr) {

		if (ptr == null) {
			return -1;
		}
		LinkNode ptr1 = ptr;
		int i = 1;
		while ((ptr1 = ptr1.getLink()) != null) {
			i++;
		}
		return i;
	}

	public void reverse(LinkNode ptr) {

		if (ptr == null) {
			System.out.println("List is empty:returning");
			return;
		}
		LinkNode ptr1 = ptr;
		LinkNode ptr2 = ptr;
		LinkNode ptr3 = null;

		while (ptr1.getLink() != null) {
			ptr2 = ptr1;
			ptr1 = ptr1.getLink();
			ptr2.setLink(ptr3);
			ptr3 = ptr2;

		}
		ptr1.setLink(ptr2);

		System.out.println("Reversed List :");
		this.print(ptr1);
	}

	public void printNthFromLast(LinkNode root, int n) {

		int i = n;
		if (root == null) {
			return;
		}

		if (i > size(root)) {
			System.out.println("Not enough elements");
			return;
		}

		LinkNode node = root;
		LinkNode nodeback = root;

		while ((node.getLink() != null) && (--i > 0)) {
			node = node.getLink();
		}

		if (node.getLink() != null) {
			while (node.getLink() != null) {
				nodeback = nodeback.getLink();
				node = node.getLink();
			}
		}

		System.out.println("N = " + n + " element from last is :"
				+ nodeback.getData());

	}

	/*
	 * Print middle element using slow and fast pointers.
	 */

	public void printMiddle(LinkNode root) {
		if (root == null) {
			return;
		}

		System.out.println("Linked list is ");
		print(root);

		LinkNode hare = null;
		LinkNode tortoise = null;
		boolean temp = false;
		if (size(root) % 2 == 0)
			temp = true;

		if (temp) {
			hare = root.getLink();
			tortoise = root;
		} else {
			hare = root;
			tortoise = root;
		}

		while (hare != null && hare.getLink() != null) {
			hare = hare.getLink().getLink();
			tortoise = tortoise.getLink();
		}
		if (temp) {
			System.out.println("Middle elements :" + tortoise.getData()
					+ " and " + tortoise.getLink().getData());
		} else {
			System.out.println("Middle element is :" + tortoise.getData());
		}
	}

	/*
	 * Rotate a linked list Anti clock wise for given number of nodes
	 */

	public void rotateACW(LinkNode root, int n) {

		if (root == null || n<=0) {
			return;
		}

		int size=size(root);
		if(n==size){
			//no need to rotate, as it will be the same
			System.out.println("List after rotating");
			print(root);
			return;			
		}
		
		if (n > size) {
			n=n%size;
		}

		System.out.println("List Before rotating");
		print(root);

		LinkNode ptr = root;
		LinkNode ptr1 = null;

		while (n-- > 0) {
			ptr1 = ptr;
			ptr = ptr.getLink();
		}

		LinkNode temp = ptr;

		while (temp.getLink() != null) {
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

	public void getUnion(LinkNode list1, LinkNode list2) {

		if (list1 == null && list2 == null) {
			return;
		}

		System.out.println("List 1:");
		print(list1);

		System.out.println("List 2: ");
		print(list2);

		LinkNode newList = new LinkNode();

		while (list1 != null && list2 != null) {
			if (list1.getData() < list2.getData()) {
				add(newList, list1.getData());
				list1 = list1.getLink();
			} else if (list1.getData() > list2.getData()) {
				add(newList, list2.getData());
				list2 = list2.getLink();
			} else {
				add(newList, list2.getData());
				list1 = list1.getLink();
				list2 = list2.getLink();
			}
		}

		while (list1 != null) {
			add(newList, list1.getData());
			list1 = list1.getLink();
		}

		while (list2 != null) {
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

	public void removeDuplicates(LinkNode node) {

		LinkNode root = node;

		if (root == null) {
			return;
		}

		System.out.println("Before duplicate removal:");
		print(root);

		while (root != null) {

			if (root.getData() == root.getLink().getData()) {
				LinkNode ptr = root.getLink();
				while (ptr != null && ptr.getLink() != null
						&& (ptr.getData() == ptr.getLink().getData())) {
					ptr = ptr.getLink();
				}
				root.setLink(ptr.getLink());
			}
			root = root.getLink();
		}
		System.out.println("After duplicate removal");
		print(node);
	}

	

}
