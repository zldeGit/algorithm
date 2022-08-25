package lu.zhang.stack;

/**
 * @author 张璐
 * @description &{description}
 * @date 2020/12/9
 */
public class LeetCode62 {
	public int uniquePaths(int m, int n) {
		int[][] ints = new int[m][n];
		for (int i = 0; i < m; i++) {
			ints[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			ints[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				ints[i][j] = ints[i - 1][j] + ints[i][j - 1];
			}
		}
		return ints[m - 1][n - 1];
	}

	public static void main(String[] args) {
		LeetCode62 leetCode62 = new LeetCode62();
		leetCode62.uniquePaths(52, 7);
	}
}
