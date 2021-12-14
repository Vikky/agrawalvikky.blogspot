package dfs;

/**
 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the
 * sum of all the node values of that path equals ‘S’.
 */
public class TreepathSum {

  /** 12 7 1 9 10 5 */
  public static void main(String[] args) {
    Node root = new Node(12);
    root.left = new Node(7);
    root.right = new Node(1);

    root.left.left = new Node(9);

    root.right.left = new Node(10);
    root.right.right = new Node(5);

    TreepathSum obj = new TreepathSum();
    int number = 1;
    System.out.println("path exists for :" + number + " : " + obj.findPath(root, number));
  }

  public boolean findPath(Node node, int sum) {

    if (node == null) {
      return false;
    }

    sum = sum - node.val;

    if (sum < 0) return false;

    if (sum == 0 && node.left == null && node.right == null) return true;

    // check for left subchild OR check for right subchild if it has the path

    return (findPath(node.left, sum) || findPath(node.right, sum));
  }

  private static class Node {
    Node left, right;
    int val;

    Node(int val) {
      this.val = val;
    }
  }
}
