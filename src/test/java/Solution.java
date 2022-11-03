import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		UnioFind find = new UnioFind(m, n);
		List<Integer> ans = new LinkedList<>();

		for (int i = 0; i < positions.length; i++) {
			find.add(positions[i][0], positions[i][1]);
			ans.add(find.count);
		}
		return ans;
	}

	public class UnioFind {
		public int[] parent;
		public int[][] island;
		public int[] order;
		public int count;

		public UnioFind(int m, int n) {
			this.parent = new int[m * n];
			this.island = new int[m][n];
			this.order = new int[m * n];
			this.count = 0;
		}

		public void add(int x, int y) {
			if (island[x][y] == 1) return;
			parent[x * island[x].length + y] = x * island[x].length + y;
			island[x][y] = 1;
			count++;
			if (x - 1 > 0 && island[x - 1][y] == 1) {
				union(x - 1, y, x, y);
			}
			if (x + 1 < island.length && island[x + 1][y] == 1) {
				union(x + 1, y, x, y);
			}
			if (y - 1 > 0 && island[x][y - 1] == 1) {
				union(x, y - 1, x, y);
			}
			if (y + 1 < island[x].length && island[x][y + 1] == 1) {
				union(x, y + 1, x, y);
			}

		}

		public void union(int x, int y, int m, int n) {
			int a = x * island[x].length + y;
			int b = m * island[m].length + n;
			int parent_a = findParent(a);
			int parent_b = findParent(b);
			if (parent_a != parent_b) {
				if (order[parent_a] == order[parent_b]) {
					parent[parent_b] = parent_a;
					order[parent_a] += 1;
				} else if (order[parent_a] > order[parent_b]) {
					parent[parent_b] = parent_a;
				} else {
					parent[parent_a] = parent_b;
				}
				count--;
			}
		}

		public int findParent(int index) {
			if (parent[index] == index) return index;
			parent[index] = findParent(parent[index]);
			return parent[index];
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] arr = new int[7][2];
		arr[0] = new int[]{0, 1};
		arr[1] = new int[]{1, 2};
		arr[2] = new int[]{2, 1};
		arr[3] = new int[]{1, 0};
		arr[4] = new int[]{0, 2};
		arr[5] = new int[]{0, 0};
		arr[6] = new int[]{1, 1};
		solution.numIslands2(3, 3, arr);
	}
}