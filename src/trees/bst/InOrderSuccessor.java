package trees.bst;

public class InOrderSuccessor {

  /**
   * Algo : If node's right is not null then return min of right.<br>
   * else <br>
   * Find the successor which would be the Lowest ancestor.<br>
   * if node lies in left of root, move left & keep on changing successor<br>
   * else move to the right side.<br>
   *
   */
  public TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
    if (root == null) return null;

    if (node.right != null) return findMin(node.right);

    TreeNode succ = null;

    TreeNode current = root;
    while (current != null) {
      if (node.val < current.val) {
        succ = current;
        current = current.left;
      } else if (node.val > current.val) current = current.right;
      else break;
    }
    return succ;
  }

  private TreeNode findMin(TreeNode node) {
    TreeNode current = node;
    while (current.left != null) current = current.left;

    return current;
  }
}
