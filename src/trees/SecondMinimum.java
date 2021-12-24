package trees;

/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each
 * node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this
 * node's value is the smaller value among its two sub-nodes. More formally, the property root.val =
 * min(root.left.val, root.right.val) always holds.
 *
 * <p>Given such a binary tree, you need to output the second minimum value in the set made of all
 * the nodes' value in the whole tree.
 *
 * <p>If no such second minimum value exists, output -1 instead.
 */
public class SecondMinimum {

  public static void main(String[] args) {

    SecondMinimum obj = new SecondMinimum();

    // [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(1, new TreeNode(1), new TreeNode(1));
    root.right = new TreeNode(3, new TreeNode(3), new TreeNode(4));

    root.left.left.left = new TreeNode(3, new TreeNode(3), new TreeNode(3));
    root.left.left.right = new TreeNode(1, new TreeNode(1), new TreeNode(6));

    root.left.right.left = new TreeNode(1, new TreeNode(2), new TreeNode(1));
    root.left.right.right = new TreeNode(1);

    root.right.left.left = new TreeNode(3);
    root.right.left.right = new TreeNode(8);

    root.right.right.left = new TreeNode(4);
    root.right.right.right = new TreeNode(8);

    System.out.println(obj.findSecondMinimumValue(root));
  }

  public int findSecondMinimumValue(TreeNode root) {

    if (root == null || root.left == null) return -1;

    // Both left and right greater
    if (root.left.val > root.val && root.right.val > root.val)
      return Math.min(root.left.val, root.right.val);

    // both equal
    if (root.left.val == root.val && root.right.val == root.val)
      return findMin(findSecondMinimumValue(root.left), findSecondMinimumValue(root.right));

    // left equal, right greater
    if (root.left.val == root.val)
      return findMin(root.right.val, findSecondMinimumValue(root.left));

    if (root.right.val == root.val)
      return findMin(root.left.val, findSecondMinimumValue(root.right));

    return -1;
  }

  private int findMin(int a, int b) {
    if (a == -1 && b == -1) return -1;
    if (a > -1 && b > -1) return Math.min(a, b);
    if (b > -1) return b;
    if (a > -1) return a;
    return -1;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
