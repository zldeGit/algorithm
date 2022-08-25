package lu.zhang.math;

/**
 * @author 张璐
 * @description &{description}
 * @date 2021/2/3
 */
public class MultiMatrix {
	 	//矩阵的乘方
	public int[][] matrixPower(int[][] m, int p) {
		int[][] res = new int[m.length][m[0].length];
		// 先把res 设为单位矩阵，相当于整数中的1
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}
		int[][] tmp = m;
		for (; p != 0; p >>= 1) {
			if ((p & 1) != 0) {
				res = muliMatrix(res, tmp);
			}
			tmp = muliMatrix(tmp, tmp);
		}
		return res;
	}

	public int c3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int[][] base = { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		int[][] res = matrixPower(base, n - 3);
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
	}


	public int c32(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int[][] base = { { 1, 0, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };
		int[][] res = matrixPower(base, n - 3);
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
	}

	public int[][] muliMatrix(int[][] m1, int[][] m2) {
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}

	public int[][] multiMatrix(int[][] m1, int[][] m2) {
		int[][] result = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m1[0].length; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MultiMatrix multiMatrix = new MultiMatrix();
//		int[][] ints = {{1, 2}, {3, 4}};
//		int[][] ints1 = multiMatrix.matrixPower(ints, 18);
//		for (int[] ints2 : ints1) {
//			System.out.println(Arrays.toString(ints2));
//		}
//		int jump = multiMatrix.getJump(41);
		int c3 = multiMatrix.c3(10);
		System.out.println("c3 = " + c3);
		int c32 = multiMatrix.c32(10);
		System.out.println("c32 = " + c32);
	}

	public int getJump(int n) {
		int[] ints = new int[n];
		return jump(n, ints);
	}
	public int jump(int n,int [] dp) {
		if (n < 1) {
			return 0;
		}
		if (n<3) {
			return n;
		}
		if (dp[n-1]!=0) {
			return dp[n-1];
		}
		int res1 = jump(n - 1, dp);
		int res2 = jump(n - 2, dp);
		dp[n-1] = res1 + res2;
		return dp[n-1];
	}

	public int momo(int n) {
		return momo(n, new int[n]);
	}

	private int momo(int n, int[] ints) {
		if (n < 0) {
			return 0;
		}
		if (n < 4) {
			return n;
		}
		if (ints[n-1]!=0) {
			return ints[n - 1];
		}
		int res1 = momo(n - 1, ints);
		int res3 = momo(n - 3, ints);
		ints[n-1]=res1+res3;
		return ints[n - 1];
	}


}
