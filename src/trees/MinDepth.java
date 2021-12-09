package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the minimum depth of the tree.
 * Minimum depth of a binary tree is the length of the shortest path of all paths from root to any leaf.
 */ 


public class MinDepth {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		MinDepth obj = new MinDepth();
		System.out.println("Min depth :" + obj.minDepth(root));
	}


	//Algo Do BFS and check if node doesn't have any Childs.
	// Keep incrementing the counter till then and return counter.

	private int minDepth(TreeNode root) {

		if (root == null)
			return 0;

		int counter = 0;
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			counter++;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null) {
					return counter - 1;
				}
				addIfNotNull(node.left, queue);
				addIfNotNull(node.right, queue);
			}

		}
		return counter - 1;
	}

	private void addIfNotNull(TreeNode node, Queue<TreeNode> queue) {
		if (node != null) {
			queue.add(node);
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
