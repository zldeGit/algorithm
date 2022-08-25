package lu.zhang.hot;

/**
 * @author 张璐
 * @date 2022/8/18
 */
public class _1_绳子压住最多的点 {
	public static int maxPoint(int[] arr, int K) {
		int l = arr[0];
		int r = l + K;
		int ans = 0;
		int L = 0;
		int R = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>r) {
				break;
			}
			ans++;
			R = i;
		}
		while (R < arr.length) {
			int temp = ans -1 ;
			l += arr[L];
			r += arr[L];
			L++;
			R++;
			while (R < arr.length && arr[R] <= r) {
				temp++;
				R++;
			}
			ans = Math.max(temp, ans);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] ints = {1, 2, 5, 7};
		System.out.println(maxPoint(ints, 3));
	}
}
