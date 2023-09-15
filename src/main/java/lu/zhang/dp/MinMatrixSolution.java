package lu.zhang.dp;

/**
 * @author 张璐
 * @description &{description}矩阵的最小路径和 给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径
 * 上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * @date 2021/2/4
 */
public class MinMatrixSolution {

  public int minSolution(int[][] dp) {
    int[][] ints = new int[dp.length][dp[0].length];
    return getmin(dp, 0, 0, ints);
  }

  private int getmin(int[][] dp, int m, int n, int[][] results) {
    if (m == dp.length - 1 && n == dp[m].length - 1) {
      return dp[m][n];
    }
    if (m >= dp.length || n >= dp[m].length) {
      return Integer.MAX_VALUE;
    }
    if (results[m][n] != 0) {
      return results[m][n];
    }
    int min = Math.min(getmin(dp, m + 1, n, results), getmin(dp, m, n + 1, results));
    results[m][n] = dp[m][n] + min;
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

  //空间压缩
  public int minLowSpaceUseSolution(int[][] dp) {
    if (dp == null || dp.length == 0 || dp[0] == null || dp[0].length == 0) {
      return 0;
    }
    boolean columnMore = dp[0].length > dp.length;
    int more = columnMore ? dp[0].length : dp.length;
    int less = columnMore ? dp.length : dp[0].length;
    int[] arr = new int[less];
    arr[0] = dp[0][0];
    for (int i = 1; i < less; i++) {
      arr[i] = arr[i - 1] + (columnMore ? dp[i][0] : dp[0][i]);
    }
    for (int i = 1; i < more; i++) {
      arr[0] = arr[0] + (columnMore ? dp[0][i] : dp[i][0]);
      for (int j = i; j < less; j++) {
        arr[j] = Math.min(arr[j], arr[j - 1]) + (columnMore ? dp[j][i] : dp[i][j]);
      }
    }
    return arr[less - 1];
  }
}

