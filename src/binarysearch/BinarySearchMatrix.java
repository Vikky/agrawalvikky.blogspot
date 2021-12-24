package binarysearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the
 * following properties:
 *
 * <p>Integers in each row are sorted from left to right. The first integer of each row is greater
 * than the last integer of the previous row.
 */
public class BinarySearchMatrix {

  int[][] nums;
  int m, n;

  public static void main(String[] args) {

    BinarySearchMatrix obj = new BinarySearchMatrix();
    int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    System.out.println(obj.searchMatrix(matrix, 3));
  }

  /**
   * Modified binary search: Binary search in range to identify the row and then binary search to
   * find the val;
   */
  public boolean searchMatrix(int[][] matrix, int target) {

    if (matrix == null) return false;

    this.nums = matrix;
    this.m = matrix.length;
    this.n = matrix[0].length;

    int row = binarySearchRow(0, m - 1, target);

    if (row == -1) return false;

    return binarySearch(row, 0, n - 1, target);
  }

  private int binarySearchRow(int start, int end, int val) {
    if (start <= end) {
      int mid = (start + end) / 2;
      if (val >= nums[mid][0] && val <= nums[mid][n - 1]) return mid;

      if (val < nums[mid][0]) return binarySearchRow(start, mid - 1, val);
      else return binarySearchRow(mid + 1, end, val);
    }
    return -1;
  }

  private boolean binarySearch(int row, int start, int end, int val) {
    if (start <= end) {
      int mid = (start + end) / 2;

      if (val == nums[row][mid]) return true;

      if (val < nums[row][mid]) return binarySearch(row, start, mid - 1, val);
      else return binarySearch(row, mid + 1, end, val);
    }
    return false;
  }
}
