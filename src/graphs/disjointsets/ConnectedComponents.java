package graphs.disjointsets;

import java.util.HashSet;
import java.util.Set;

/**
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai,
 * bi] indicates that there is an edge between ai and bi in the graph.
 *
 * <p>Return the number of connected components in the graph.
 */
public class ConnectedComponents {

  public static void main(String[] args) {
    ConnectedComponents components = new ConnectedComponents();
    System.out.println(components.countComponents(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    System.out.println(
        components.countComponents(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    System.out.println(components.countComponents(6, new int[][] {{0, 1}, {0, 2}, {2, 3}, {4, 5}}));
  }

  public int countComponents(int n, int[][] edges) {

    DisjointSets djs = new DisjointSets(n);

    // O(n)* O(h)
    for (int i = 0; i < edges.length; i++) {
      int x = edges[i][0];
      int y = edges[i][1];

      djs.union(x, y);
    }

    Set<Integer> set = new HashSet();
    for (int i = 0; i < n; i++) set.add(djs.find(i));

    return set.size();
  }

  static class DisjointSets {

    int[] parent, rank;
    int n;

    DisjointSets(int size) {
      this.parent = new int[size];
      this.rank = new int[size];
      this.n = size;

      // initialize
      for (int i = 0; i < size; i++) parent[i] = i;
    }

    // O(h) - h is the height of connected tree.
    public int find(int x) {
      if (parent[x] == x) return x;

      return parent[x] = find(parent[x]);
    }

    // O(h) : finding takes O(h) and then just updates.
    public void union(int i, int j) {
      int rootX = find(i);
      int rootY = find(j);

      if (rootX == rootY) return;

      if (rank[rootX] < rank[rootY]) {
        parent[rootX] = rootY;
      } else if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
      } else {
        parent[rootY] = rootX;
        rank[rootX]++;
      }
    }
  }
}
