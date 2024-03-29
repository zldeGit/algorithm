package lu.zhang.prepare;

/**
 * @author 张璐
 * @date 2022/8/2 日常修改
 */
public class _53_并查集 {

  public static class Node<V> {

    V value;
    Node<V> parent;
    int rank;

    public Node(V value) {
      this.value = value;
      this.parent = this;
    }

    public Node find() {
      if (parent != this) {
        this.parent = parent.find();
      }
      return parent;
    }

    public void union(Node node) {
      parent = find();
      node.parent = node.find();
      if (parent != node.parent) {
        Node large = parent.rank > node.parent.rank ? parent : node.parent;
        Node small = parent.rank > node.parent.rank ? node.parent : parent;
        small.parent = large;
        if (small.rank == large.rank) {
          large.rank += 1;
        }
      }
    }
  }

  class UnionFind {

    int count;
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) {
      count = 0;
      int m = grid.length;
      int n = grid[0].length;
      parent = new int[m * n];
      rank = new int[m * n];
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (grid[i][j] == '1') {
            parent[i * n + j] = i * n + j;
            ++count;
          }
          rank[i * n + j] = 0;
        }
      }
    }

    public int find(int i) {
			if (parent[i] != i) {
				parent[i] = find(parent[i]);
			}
      return parent[i];
    }

    public void union(int x, int y) {
      int rootx = find(x);
      int rooty = find(y);
      if (rootx != rooty) {
        if (rank[rootx] > rank[rooty]) {
          parent[rooty] = rootx;
        } else if (rank[rootx] < rank[rooty]) {
          parent[rootx] = rooty;
        } else {
          parent[rooty] = rootx;
          rank[rootx] += 1;
        }
        --count;
      }
    }

    public int getCount() {
      return count;
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;
    UnionFind uf = new UnionFind(grid);
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          if (r + 1 < nr && grid[r + 1][c] == '1') {
            uf.union(r * nc + c, (r + 1) * nc + c);
          }
          if (c + 1 < nc && grid[r][c + 1] == '1') {
            uf.union(r * nc + c, r * nc + c + 1);
          }
        }
      }
    }
    return uf.getCount();
  }
}