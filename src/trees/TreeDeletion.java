package trees;

/**
 * Tree(BST) deletion algo:
 *
 *  - Traverse the tree till the key is found, maintain current and parent pointer;
 *  - case1: if both the child are null;
 *  	if current ==root
 *    		root =null
 *  	parent.left/right =null
 *  	delete current
 *
 *  - case2 : if both child non null
 *  	find min Node from right sub-tree
 *  	copy its key to current;
 *  	call recursive delete on found node(min) [it will land on case 1/3]
 *
 * - case 3: if either of left or right subtree present
 * 		Child = left/right
 * 		if root == current
 * 			root = child
 * 		else
 * 			parent.left/right = child
 *
 */
public class TreeDeletion
{

	public static void main(String[] args)
	{
		Node root = null;
		int[] keys = { 15, 10, 20, 8, 12, 16 };

		for (int key : keys)
		{
			root = insert(root, key);
		}

		root = deleteNode(root, 20);
		inorder(root);
	}

	// Recursive function to insert a key into BST
	public static Node insert(Node root, int key)
	{
		// if the root is null, create a new node and return it
		if (root == null)
		{
			return new Node(key);
		}

		// if given key is less than the root node, recur for left subtree
		if (key < root.data)
		{
			root.left = insert(root.left, key);
		}

		// if given key is more than the root node, recur for right subtree
		else
		{
			root.right = insert(root.right, key);
		}

		return root;
	}

	public static Node deleteNode(Node root, int key)
	{
		if (root == null)
			return root;

		Node current = root;
		Node parent = root;

		while (current != null && current.data != key)
		{
			parent = current;

			if (key > current.data)
				current = current.right;
			else
				current = current.left;
		}

		// case 1: if both the children are null
		if (current.left == null && current.right == null)
		{
			if (current == root)
			{
				root = null;
				return root;
			}
			else
			{
				if (parent.left == current)
					parent.left = null;
				else
					parent.right = null;
			}
		}
		//case 2: if both children non null
		if (current.left != null && current.right != null)
		{
			Node successor = minimumKey(current.right);

			int data = successor.data;

			deleteNode(root, data);

			current.data = data;
		}
		//case 3 : either only left subtree or right subtree
		else
		{
			Node child = current.left != null ? current.left : current.right;

			if (current == root)
			{
				root = child;
			}
			else
			{
				if (parent.left == current)
					parent.left = child;
				else
					parent.right = child;
			}

		}
		return root;
	}

	// Function to perform inorder traversal of the BST
	public static void inorder(Node root)
	{
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// Helper function to find minimum value node in subtree rooted at curr
	public static Node minimumKey(Node curr)
	{
		while (curr.left != null)
		{
			curr = curr.left;
		}
		return curr;
	}

	static class Node
	{
		int data;
		Node left = null, right = null;

		Node(int data)
		{
			this.data = data;
		}
	}
}