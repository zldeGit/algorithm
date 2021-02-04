package dp;

/**
 * @author 张璐
 * @description &{description}矩阵的最小路径和
 * 给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径
 * 上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * @date 2021/2/4
 */
public class MinMatrixSolution {
	public int minSolution(int[][] dp){
		int[][] ints = new int[dp.length][dp[0].length];
		return getmin(dp, 0, 0,ints);
	}

	private int getmin(int[][] dp, int m, int n,int[][] results) {
		if (m==dp.length-1&&n==dp[m].length-1) {
			return dp[m][n];
		}
		if (m>=dp.length||n>=dp[m].length) {
			return Integer.MAX_VALUE;
		}
		if (results[m][n]!=0) {
			return results[m][n];
		}
		int min = Math.min(getmin(dp, m + 1, n,results), getmin(dp, m, n + 1,results));
		results[m][n] = dp[m][n]+min;
		return results[m][n];
	}

	public static void main(String[] args) {
		int[][] ints = {
				{1, 2, 3, 4, 5, 6, 8, 9},
				{1, 2, 3, 4, 5, 6, 8, 9},
				{1, 2, 3, 4, 5, 6, 8, 9},
				{1, 2, 3, 4, 5, 6, 8, 9},
				{1, 2, 3, 4, 5, 6, 8, 9},
				{1, 2, 3, 4, 5, 6, 8, 9}};
		MinMatrixSolution minMatrixSolution = new MinMatrixSolution();
		int i = minMatrixSolution.minSolution(ints);
		System.out.println("i = " + i);
	}
}
