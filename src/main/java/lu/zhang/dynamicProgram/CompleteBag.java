package lu.zhang.dynamicProgram;

/**
 * @author 张璐
 * <p>
 * 全背包问题 ： 有 N 种物品和一个容量为 C 的背包，每种物品都有无限件。 第 i 件物品的体积是 v[i]，价值是 w[i]。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 * @description &{description} 完全背包问题
 * @date 2021/7/6
 */
public class CompleteBag {

  //常规解法
  public static int solution(int N, int C, int[] v, int[] w) {
    int[] dp = new int[C + 1];
    for (int i = 0; i < N; i++) {
      for (int j = C; j > -1; j--) {
        //遍历选取的每一种情况
        for (int k = 0; ; k++) {
          //不超过当前背包最大容量
          if (j < k * v[i]) {
            break;
          }
          dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
        }
      }
    }
    return dp[C];
  }

  //升级解法
  public static int solution2(int N, int C, int[] v, int[] w) {
    int[] dp = new int[C + 1];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < C + 1; j++) {
        int n = dp[j];//不选取当前数
        int m = w[i] + dp[j - v[i]];//选取当前数
        dp[j] = Math.max(n, m);
      }
    }
    return dp[C];
  }
}
