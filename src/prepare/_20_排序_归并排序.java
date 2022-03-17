package prepare;

import utils.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 张璐
 * @date 2022/3/17
 */
public class _20_排序_归并排序 {
	public static void mergeSort(int[] arr) {
		int mergeSize = 1;
		while (mergeSize < arr.length) {
			for (int i = 0; i < arr.length-mergeSize; i += mergeSize << 1) {
				merge(arr, i, i + mergeSize - 1, Math.min(i + (mergeSize << 1) - 1, arr.length - 1));
			}
			mergeSize <<= 1;
		}
	}

	private static void merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int p = L;
		int q = M + 1;
		int i = 0;
		while (p <= M && q <= R) {
			help[i++] = arr[p] >= arr[q] ? arr[p++] : arr[q++];
		}
		while (p <= M) {
			help[i++] = arr[p++];
		}
		while (q <= R) {
			help[i++] = arr[q++];
		}
		for (i = 0; i <help.length; i++) {
			arr[i + L] = help[i];
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int[] arr = Utils.generateRandomIntArr(100, 1000);
			mergeSort(arr);
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] > arr[j - 1]) {
					System.out.println("出错了");
					System.out.println(Arrays.toString(arr));
					break;
				}
			}
		}
	}
}
