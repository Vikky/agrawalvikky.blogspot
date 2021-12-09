package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its zigzag level order traversal. 
 * You should populate the values of all Nodes of the first level from left to right, 
 * then right to left for the next level and keep alternating in the same manner for the following levels.
 */


public class ZigzagTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		ZigzagTraversal obj = new ZigzagTraversal();
		obj.traverse(root);
	}


	private List<List<Integer>> traverse(TreeNode root) {

		if (root == null)
			return new ArrayList();

		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		boolean flag = true;

		List<List<Integer>> result = new ArrayList();
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (flag)
					list.add(node.val);
				else
					list.add(0, node.val);

				addIfNotNull(node.left, queue);
				addIfNotNull(node.right, queue);
			}
			print(list);
			result.add(list);
			flag = !flag;
		}
		return result;
	}

	private void addIfNotNull(TreeNode node, Queue<TreeNode> queue) {
		if (node != null)
			queue.add(node);
	}

	private void print(List<Integer> list) {
		list.forEach(num -> {
			System.out.println(num);
		});
	}


	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

	}
}