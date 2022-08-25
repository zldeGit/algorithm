package lu.zhang.prepare;

import lu.zhang.utils.Utils;

import java.util.Arrays;

/**
 * @author 张璐
 * @date 2022/3/22
 */
public class _28_排序_归并排序解决逆序对 {
	//从右往左merge TODO
	public static int merge(int[] arr, int L, int M, int R) {
		int leftL = L;
		int leftR = M - 1;
		int rightL = M;
		int rightR = R;
		int[] help = new int[R - L + 1];
		int i = 0;
		int ans = 0;
		while (leftL <= leftR && rightL <= rightR) {
			if (arr[rightL] <= arr[leftL]) {
				help[i++] = arr[rightL++];
			} else {
				help[i++] = arr[leftL];
				ans += arr[leftL] * (rightR - rightL + 1);
				leftL++;
			}
		}
		while (rightL <= rightR) {
			help[i++] = arr[rightL++];
		}
		while (leftL <= leftR) {
			help[i++] = arr[leftL++];
		}
		for (int j = 0; j < help.length; j++) {
			arr[j + L] = help[j];
		}
		return ans;
	}

	public static int getSmallSumByMergeSort(int[] arr) {
//		arr = Arrays.copyOf(arr, arr.length);
		int ans = 0;
		int mergeSize = 1;
		while (mergeSize < arr.length) {
			for (int i = 0; i < arr.length - mergeSize; i += (mergeSize << 1)) {
				ans += merge(arr, i, i + mergeSize, Math.min(arr.length - 1, i + 2 * mergeSize - 1));
			}
			mergeSize <<= 1;
		}
		return ans;
	}

	public static int check(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					ans += arr[j];
				}
			}
		}
		return ans;
	}


	public static void main(String[] args) {
//		System.out.println(4 + 3 + 4 + 3 + 5 + 4 + 3 + 5 + 7 + 2 + 4 + 3 + 5 + 2 + 3 + 2);
		for (int i = 0; i < 10000; i++) {
			int[] ints = Utils.generateRandomIntArr(1000, 1000);
//			int[] ints = {4, 3, 5, 7, 2, 8, 6, 4};
			try {
				int check = check(ints);
				int smallSumByMergeSort = getSmallSumByMergeSort(ints);
				if (smallSumByMergeSort != check) {
					System.out.println("error");
					System.out.println(Arrays.toString(ints));
					break;
				}
			} catch (Exception e) {
				System.out.println(Arrays.toString(ints));
				break;
			}
		}
	}
}
