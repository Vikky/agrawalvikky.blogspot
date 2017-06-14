package trees;

import java.util.Stack;

import static java.lang.Math.max;
import static java.util.Objects.isNull;

/**
 * @author vikky.agrawal
 */

public class BST
{

	static int k = 3;
	private TreeNode root;

	BST()
	{
		root = new TreeNode(5);
	}

	public static void main(String[] args)
	{

		new BST().BSToperation();
	}

	public void BSToperation()
	{

		System.out.println("Building tree with root value " + root.getData());
		insert(root, 3);
		insert(root, 8);
		insert(root, 6);
		insert(root, 10);
		insert(root, 2);
		insert(root, 4);
		System.out.println("Traversing tree in in-order");
		inorder(root);

		System.out.println("Traversing tree in  reverse-order");
		reverseorder(root);

		System.out.println("Traversing tree in  post-order");
		postOrder(root);

		System.out.println("Find whether sum=12 exists in tree : " + findSum(root, 12));

		System.out.println("Height of tree : " + getHeight(root));

		printKSmallest(root);

	}



	public void inorder(TreeNode root)
	{
		if (root != null)
		{
			inorder(root.getLeft());
			System.out.println(root.getData());
			inorder(root.getRight());
		}
	}

	/*
	 * Right -root -left
	 */
	public void reverseorder(TreeNode root)
	{
		if (root != null)
		{
			reverseorder(root.getRight());
			System.out.println(root.getData());
			reverseorder(root.getLeft());
		}
	}

	/*
	 * left -right - root
	 */
	public void postOrder(TreeNode root)
	{
		if (root != null)
		{
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.println(root.getData());

		}
	}

	/*
	 * O(n log(n) solution. finding for each node using trees.BST property.
	 */
	public boolean findSum(TreeNode root, int val)
	{
		if (root != null)
		{
			// for each node find whether its counterpart exists?
			TreeNode left = root.getLeft();
			TreeNode right = root.getRight();
			return (findSum(left, val) || find(this.root, val - root.getData()) || findSum(right, val));
		}
		return false;
	}

	/*
	 * O(log n) helper function
	 */

	private boolean find(TreeNode root, int val)
	{
		if (root != null)
		{
			if (root.getData() == val)
			{
				return true;
			}
			else if (root.getData() > val)
			{
				return find(root.getLeft(), val);
			}
			else
			{
				return find(root.getRight(), val);
			}
		}
		return false;
	}

	//Height of binary tree
	private int getHeight(TreeNode root)
	{
		if (root == null)
			return 0;

		return 1 + max(getHeight(root.left), getHeight(root.right));
	}

	private void printKSmallest(TreeNode root)
	{
		if (root == null)
		{
			k--;
			return;
		}

		printKSmallest(root.left);
		if (k == 0)
		{
			System.out.println("kth smallest element " + root.data);
		}
		printKSmallest(root.right);
	}



	/*
	 * public boolean array.findSum(TreeNode root, int val){ if(root!=null){
	 * 
	 * //traverse only left if root.value-val <=0 if(val-root.getData() <= 0){
	 * return array.findSum(root.getLeft(), val); }else { //scenario 1: when
	 * root.value-val < root.value if(val-root.getData() < root.getData()){
	 * if(find(root.getLeft(),val-root.getData())){ return true; }else{ return
	 * array.findSum(root.getLeft(), val); } } //scenario 2: traversing to the right.
	 * else{ if(find(root.getRight(),val-root.getData())){ return true; }else{
	 * return array.findSum(root.getRight(), val); } } }
	 * 
	 * } return false;
	 * 
	 * }
	 */


	public void insert(TreeNode root, int val)
	{
		if (root == null)
		{
			root = new TreeNode(val);
			return;
		}
		else
		{
			if (val < root.getData())
			{
				if (root.getLeft() == null)
				{
					System.out.println("inserting left to :" + root.getData() + " val : " + val);
					root.setLeft(new TreeNode(val));
				}
				else
				{
					insert(root.getLeft(), val);
				}
			}
			else
			{
				if (root.getRight() == null)
				{
					System.out.println("inserting right to :" + root.getData() + " val : " + val);
					root.setRight(new TreeNode(val));
				}
				else
				{
					insert(root.getRight(), val);
				}
			}
		}
	}


	//DS for tree
	private static class TreeNode
	{

		private int data;
		private TreeNode right;
		private TreeNode left;

		TreeNode()
		{
		}

		TreeNode(int data)
		{
			this.setData(data);
			this.setLeft(null);
			this.setRight(null);
		}

		public int getData()
		{
			return this.data;
		}

		public TreeNode getRight()
		{
			return this.right;
		}

		public TreeNode getLeft()
		{
			return this.left;
		}

		public void setData(int data)
		{
			this.data = data;
		}

		public void setRight(TreeNode right)
		{
			this.right = right;
		}

		public void setLeft(TreeNode left)
		{
			this.left = left;
		}
	}
}
