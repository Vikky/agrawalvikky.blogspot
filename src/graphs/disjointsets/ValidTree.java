package graphs.disjointsets;

/**
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of
 * edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and
 * bi in the graph.
 *
 * <p>Return true if the edges of the given graph make up a valid tree, and false otherwise.
 */
public class ValidTree {

  public static void main(String[] args) {

    ValidTree validTree = new ValidTree();
    System.out.println(validTree.validateTree(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    System.out.println(
        validTree.validateTree(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    System.out.println(validTree.validateTree(6, new int[][] {{0, 1}, {0, 2}, {2, 3}, {4, 5}}));
  }

  public boolean validateTree(int n, int[][] edges) {

    // empty tree
    if (n == 0) return true;

    // cycle would mean if there are n nodes and >=n edges
    if (edges.length >= n) return false;

    DisjointSets djs = new DisjointSets(n);
    for (int i = 0; i < edges.length; i++) {
      int x = edges[i][0];
      int y = edges[i][1];
      if (!djs.union(x, y)) return false;
    }

    int val = djs.find(0);
    for (int i = 1; i < n; i++) {
      if (djs.find(i) != val) {
        // System.out.println("Graph not tree");
        return false;
      }
    }
    return true;
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
    public boolean union(int i, int j) {
      int rootX = find(i);
      int rootY = find(j);

      if (rootX == rootY) return false;

      if (rank[rootX] < rank[rootY]) {
        parent[rootX] = rootY;
      } else if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
      } else {
        parent[rootY] = rootX;
        rank[rootX]++;
      }
      return true;
    }

    public boolean connected(int i, int j) {
      return find(i) == find(j);
    }
  }
}
