package graphs.dfs;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are
 * surrounded by water.
 *
 * <p>The area of an island is the number of cells with a value 1 in the island.
 *
 * <p>Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxSizeIsland {

  int row;
  int col;
  int[][] grid;

  public static void main(String[] args) {
    MaxSizeIsland obj = new MaxSizeIsland();
    int[][] arr = new int[][] {{1, 1}};

    int area = obj.maxAreaOfIsland(arr);
    System.out.println(area);
  }

  public int maxAreaOfIsland(int[][] grid) {

    if (grid == null) return 0;

    this.grid = grid;
    this.row = grid.length;
    this.col = grid[0].length;

    int max = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, isIsland(i, j, 0));
        }
      }
    }
    return max;
  }

  private int isIsland(int row, int col, int count) {
    if (isValid(row, col)) {
      grid[row][col] = -1;
      count =
          1
              + isIsland(row + 1, col, count)
              + isIsland(row - 1, col, count)
              + isIsland(row, col - 1, count)
              + isIsland(row, col + 1, count);
    }
    return count;
  }

  private boolean isValid(int i, int j) {
    if (i >= 0 && i < row && j >= 0 && j < col && grid[i][j] == 1) return true;
    return false;
  }
}
