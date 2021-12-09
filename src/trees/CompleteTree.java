package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * binary tree is a complete binary tree if all levels of the tree starting from root node level are filled.
 * Only the last level of the tree is allowed to have an incompletely filled state. Also for tree to be a complete binary tree, all nodes should be placed as left as possible.
 */


class CompleteTree {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);

        CompleteTree tree= new CompleteTree();
        System.out.println("Complete tree :"+tree.checkComplete(root));
    }

    //Algo : DO BFS, at each level check size = 2^level
    // if not check if its leaf nodes
    // at each level check if right child exists and left doesn't return false;
    public boolean checkComplete(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        int counter = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size == Math.pow(2, counter)) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left == null && node.right != null)
                        return false;
                    addIfNotNull(node.left, queue);
                    addIfNotNull(node.right, queue);
                }
            } else {
                return checkLeafNodes(queue);
            }
            counter++;
        }
        return true;

    }

    private boolean checkLeafNodes(Queue<TreeNode> queue) {

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null || node.right != null)
                return false;

        }
        return true;
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
