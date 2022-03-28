package prepare;

import utils.Utils;

/**
 * @author 张璐
 * @date 2022/3/28
 */
public class _34_排序_基数排序 {
	public static void radixSort(int[] arr) {
		radixSort(arr, 0, arr.length, getMaxDigit(arr, 0, arr.length));
	}

	private static void radixSort(int[] arr, int L, int R, int maxDigit) {
		if (L >= R || maxDigit == 0) {
			return;
		}
		for (int i = 1; i <=maxDigit ; i++) {
			int[] count = new int[10];
			int[] help = new int[R - L];
			for (int j = L; j < R; j++) {
				count[getDigitInt(arr[j], i)]++;
			}
			for (int j = 1; j < 10; j++) {
				count[j] += count[j - 1];
			}
			for (int j = R-1; j >=L; j--) {
				help[--count[getDigitInt(arr[j], i)]] = arr[j];
			}
			for (int j = L; j < R; j++) {
				arr[j] = help[j - L];
			}
		}
	}

	private static int getDigitInt(int i, int digit) {
		if (digit < 1) {
			throw new RuntimeException();
		}
		return (i / (int) Math.pow(10, digit - 1)) % 10;
	}

	public static int getMaxDigit(int[] arr, int L, int R) {
		int ans = 0;
		for (int i = L; i <R ; i++) {
			int num = arr[i];
			int temp = 0;
			while (num > 0) {
				num /= 10;
				temp++;
			}
			ans = Math.max(ans, temp);
		}
		return ans;
	}
	public static boolean check(int[] arr) {
		if (arr.length < 2) {
			return true;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		for (int i = 0; i <1000 ; i++) {

			int[] arr = Utils.generateRandomPosIntArr(1000, 1000);
			radixSort(arr);
			if (!check(arr)) {
				System.out.println("erro");
				break;
			}
		}
	}
}
