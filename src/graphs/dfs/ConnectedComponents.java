package graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {

  public static void main(String[] args) {
    ConnectedComponents components = new ConnectedComponents();
    System.out.println(components.countComponents(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    System.out.println(
        components.countComponents(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    System.out.println(components.countComponents(6, new int[][] {{0, 1}, {0, 2}, {2, 3}, {4, 5}}));
  }

  public int countComponents(int n, int[][] edges) {
    int len = edges.length;
    boolean[] visited = new boolean[n];
    List<Integer>[] adjList = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      adjList[i] = new ArrayList<>();
    }

    for (int i = 0; i < len; i++) {
      adjList[edges[i][0]].add(edges[i][1]);
      adjList[edges[i][1]].add(edges[i][0]);
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(visited, adjList, i);
        count++;
      }
    }
    return count;
  }

  private void dfs(boolean[] visited, List<Integer>[] adjList, int start) {
    List<Integer> list = adjList[start];
    visited[start] = true;
    for (int i = 0; i < list.size(); i++) {
      int next = list.get(i);
      if (!visited[next]) {
        dfs(visited, adjList, next);
      }
    }
  }
}
