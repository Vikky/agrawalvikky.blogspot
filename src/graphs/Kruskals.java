package graphs;

import java.util.PriorityQueue;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane,
 * where points[i] = [xi, yi].
 *
 * <p>The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between
 * them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * <p>Return the minimum cost to make all points connected. All points are connected if there is
 * exactly one simple path between any two points.
 */
public class Kruskals {

  public static void main(String[] args) {

    Kruskals kruskals = new Kruskals();
    int[][] arr = new int[][] {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};

    int cost = kruskals.minCostConnectPoints(arr);

    System.out.println("Min cost :" + cost);
  }

  public int minCostConnectPoints(int[][] points) {

    if (points == null || points.length == 0) return 0;

    int nodes = points.length;
    PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((x, y) -> x.node1 - x.node2);

    for (int i = 0; i < nodes; i++) {
      for (int j = i + 1; j < nodes; j++) {
        int x1 = points[i][0];
        int y1 = points[i][1];

        int x2 = points[j][0];
        int y2 = points[j][1];

        int weight = Math.abs((x1 - x2) + (y1 - y2));
        priorityQueue.offer(new Edge(i, j, weight));
      }
    }

    int mincost = 0;
    Union union = new Union(nodes);
    for (int i = 0; i < nodes && !priorityQueue.isEmpty(); ) {
      Edge edge = priorityQueue.poll();
      // Union check if connected
      if (!union.connected(edge.node1, edge.node2)) {
        union.union(edge.node1, edge.node2);
        mincost += edge.weight;
        i++;
      }
    }

    return mincost;
  }

  static class Union {
    int[] root;
    int[] rank;

    Union(int n) {
      this.root = new int[n];
      this.rank = new int[n];

      for (int i = 0; i < n; i++) root[i] = i;
    }

    public int find(int x) {
      if (root[x] == x) return x;
      return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
      int rootx = find(x);
      int rooty = find(y);

      if (rootx == rooty) return;

      if (rank[rootx] < rank[rooty]) root[rootx] = root[rooty];
      if (rank[rootx] > rank[rooty]) root[rooty] = root[rootx];
      else {
        root[rooty] = root[rootx];
        rank[rootx]++;
      }
    }

    public boolean connected(int x, int y) {
      return find(x) == find(y);
    }
  }

  static class Edge {
    int node1;
    int node2;
    int weight;

    public Edge(int x, int y, int weight) {
      this.node1 = x;
      this.node2 = y;
      this.weight = weight;
    }
  }
}
