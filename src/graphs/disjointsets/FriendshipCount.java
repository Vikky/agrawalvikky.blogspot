package graphs.disjointsets;

import java.util.*;

/**
 * There are n people in a social group labeled from 0 to n - 1. You are given an array logs where
 * logs[i] = [timestampi, xi, yi] indicates that xi and yi will be friends at the time timestampi.
 *
 * <p>Friendship is symmetric. That means if a is friends with b, then b is friends with a. Also,
 * person a is acquainted with a person b if a is friends with b, or a is a friend of someone
 * acquainted with b.
 *
 * <p>Return the earliest time for which every person became acquainted with every other person. If
 * there is no such earliest time, return -1.
 */
public class FriendshipCount {

  public static void main(String[] args) {
    FriendshipCount frc = new FriendshipCount();
    System.out.println(
        frc.earliestAcq(
            new int[][] {{9, 3, 0}, {0, 2, 1}, {8, 0, 1}, {1, 3, 2}, {2, 2, 0}, {3, 3, 1}}, 4));
  }


  //
  public int earliestAcq(int[][] logs, int n) {

    Map<Integer, List<Integer>> map = new TreeMap();
    DisjointSets djs = new DisjointSets(n);

    // Sort the logs by time.
    for (int i = 0; i < logs.length; i++) {
      List<Integer> list = new ArrayList();
      list.add(logs[i][1]);
      list.add(logs[i][2]);
      map.put(logs[i][0], list);
    }
    int components = n-1;
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      int t = entry.getKey();
      int x = entry.getValue().get(0);
      int y = entry.getValue().get(1);
      if(djs.union(x, y)){
        components--;
      }
      if (components==0)
        return t;
    }
    return -1;
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
  }
}
