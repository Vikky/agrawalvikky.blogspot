package trees;

/**
 * Program to check if two binary trees are identical or not.
 * i.e. if they have identical structure & their contents are also same.
 *
 * @author vikky.agrawal on 4/22/17.
 */
public class BinaryTreeEqual
{
	static class Node
	{
		int data;
		Node left;
		Node right;

		public Node(final int data)
		{
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args)
	{

		Node first = new Node(4);
		System.out.println("Building tree with root value " + first.data);
		insert(first, 2);
		insert(first, 1);
		insert(first, 3);
		insert(first, 5);
		insert(first, 6);
		insert(first, 7);
		insert(first, 8);

		Node second = new Node(4);
		System.out.println("Building tree with root value " + second.data);
		insert(second, 2);
		insert(second, 1);
		insert(second, 3);
		insert(second, 5);
		insert(second, 6);
		insert(second, 7);
		insert(second, 8);

		System.out.println("Whether tress are equal ? : " + checkIfEqual(first, second));

		//change structure to check if equal
		second.left.data = 7;
		System.out.println("Whether tress are equal ? : " + checkIfEqual(first, second));
	}

	private static boolean checkIfEqual(Node first, Node second)
	{

		if(first==null && second ==null)
			return true;

		if(first==null || second==null)
			return false;

		if (first.data == second.data)
			return checkIfEqual(first.left, second.left) && checkIfEqual(first.right, second.right);

		return false;
	}

	public static void insert(Node node, int value)
	{
		if (value < node.data)
		{
			if (node.left != null)
			{
				insert(node.left, value);
			}
			else
			{
				node.left = new Node(value);
			}
		}
		else if (value > node.data)
		{
			if (node.right != null)
			{
				insert(node.right, value);
			}
			else
			{
				node.right = new Node(value);
			}
		}
	}
}