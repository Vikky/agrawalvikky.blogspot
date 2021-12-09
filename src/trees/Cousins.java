package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two nodes in a binary tree, check if they are cousins.
 * Two nodes are cousins if:
 * 1: they are not siblings (children of same parent).
 * 2: they are on the same level.
 * For example, in the following binary tree
 */


//Algo
// Level order traversal, put parent child in Queue.
// If any node found and other not return false;
// if same parent return false;
// return true;

// Algo 2:
// return (!isSibling(a, b) && getLevel(a) == getLevel(b));
// Sibling check : if both belong to same parent; (check for root & then recurse on left and right subtree.)


public class Cousins
{

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);

		Cousins obj = new Cousins();
		System.out.println("Are cousing : "+obj.cousins(root, 4,3));

	}



	public boolean cousins(TreeNode root, int first, int second)
	{
		if(root==null)
			return false;

		if(root.left==null || root.right== null)
			return false;

		Queue<Pair> queue = new LinkedList();
		queue.add(new Pair(root.left, root));
		queue.add(new Pair(root.right, root));

		while(!queue.isEmpty())
		{
			int size = queue.size();
			for(int i=0;i<size;i++)
			{
				Pair pair = queue.poll();
				if (pair.node.val == first) {
					return checkOther(queue, pair.parent, second, i+1, size);
				}

				if (pair.node.val == second) {
					return checkOther(queue, pair.parent, first, i+1, size);
				}
				addIfNotNull(pair.node.left, pair.node, queue);
				addIfNotNull(pair.node.right, pair.node, queue);

			}
		}
		return false;
	}


	private boolean checkOther(Queue<Pair> queue, TreeNode parent, int other, int index, int size)
	{
		for(int i= index; i<size; i++)
		{
			Pair pair = queue.poll();
			if (pair.node.val == other && pair.parent.val != parent.val) {
				return true;
			}
		}
		return false;
	}

	private void addIfNotNull(TreeNode node, TreeNode parent, Queue<Pair> queue) {
		if (node != null) {
			queue.add(new Pair(node, parent));
		}
	}



	private static class Pair
	{
		TreeNode node;
		TreeNode parent;

		Pair(TreeNode node, TreeNode parent)
		{
			this.node = node;
			this.parent = parent;
		}
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			this.val = val;
		}
	}


}

