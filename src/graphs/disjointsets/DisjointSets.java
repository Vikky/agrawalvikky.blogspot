package graphs.disjointsets;

public class DisjointSets {

  int[] parent, rank;
  int n;

  DisjointSets(int size) {
    this.parent = new int[size];
    this.rank = new int[size];
    this.n = size;

    // initialize
    for (int i = 0; i < size; i++) parent[i] = i;
  }

  public static void main(String[] args) {
    // Let there be 5 persons with ids as
    // 0, 1, 2, 3 and 4
    int n = 5;
    DisjointSets dus = new DisjointSets(n);

    // 0 is a friend of 2
    dus.union(0, 2);

    // 4 is a friend of 2
    dus.union(4, 2);

    // 3 is a friend of 1
    dus.union(3, 1);

    // Check if 4 is a friend of 0
    if (dus.connected(4, 0)) System.out.println("Yes");
    else System.out.println("No");

    // Check if 1 is a friend of 0
    if (dus.connected(1, 0)) System.out.println("Yes");
    else System.out.println("No");
  }

  // O(h) - h is the height of connected tree.
  public int find(int x) {
    if (parent[x] == x) return x;

    return find(parent[x]);
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

  public boolean connected(int i, int j) {
    return find(i) == find(j);
  }
}
