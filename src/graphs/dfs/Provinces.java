package graphs.dfs;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected
 * directly with city b, and city b is connected directly with city c, then city a is connected
 * indirectly with city c.
 *
 * <p>A province is a group of directly or indirectly connected cities and no other cities outside
 * of the group.
 *
 * <p>You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the
 * jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * <p>Return the total number of provinces.
 */
public class Provinces {

  public static void main(String[] args) {
    Provinces provinces = new Provinces();
    int[][] connected = new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    System.out.println(provinces.findCircleNum(connected));
  }

  public int findCircleNum(int[][] connected) {

    int n = connected.length;
    boolean[] visited = new boolean[n];
    int count = 0;
    for (int j = 0; j < connected.length; j++) {
      if (!visited[j]) {
        count++;
        dfs(connected, visited, j);
      }
    }
    return count;
  }

  private void dfs(int[][] connected, boolean[] visited, int i) {
    for (int j = 0; j < connected.length; j++) {
      if (connected[i][j] == 1 && !visited[j]) {
        visited[j] = true;
        dfs(connected, visited, j);
      }
    }
  }
}
