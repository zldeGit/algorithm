package sort;

import dynamicProgram.ZeroOneBag;

/**
 * @author 张璐
 * @description &{description}
 * @date 2021/7/27
 */
public class RadixSort {
	public void radixSort(int[] arr) {
//		int max = 0;
//		for (int i = 0; i < arr.length; i++) {
//			max = Math.max(max, maxbits(arr[i]));
//		}
//		for (int N= 1; N <= max; N++) {
//			int[] count = new int[10];
//			for (int i = 0; i < arr.length; i++) {
//				int digit = getDigit(arr[i], N);
//				count[digit]++;
//			}
//			for (int i = 1; i < 10; i++) {
//				count[i] = count[i] + count[i - 1];
//			}
//			int[] help = new int[arr.length];
//			for (int i = arr.length-1; i >-1; i--) {
//				int digit = getDigit(arr[i], N);
//				help[count[digit]-1] = arr[i];
//				count[digit]--;
//			}
//			for (int i = 0; i < arr.length; i++) {
//				arr[i] = help[i];
//			}
//		}

		int max = 0;
		for (int i : arr) {
			max = Math.max(maxbits(i), max);
		}
		int[] help = new int[arr.length];
		for (int i = 1; i <= max; i++) {
			int[] count = new int[10];
			for (int j = 0; j < arr.length; j++) {
				count[getDigit(arr[j], i)]++;
			}
			for (int j = 1; j < count.length; j++) {
				count[j] += count[j - 1];
			}
			for (int j = arr.length - 1; j > -1; j--) {
				help[count[getDigit(arr[j], i)]---1] = arr[j];
			}
			for (int j = 0; j < arr.length; j++) {
				arr[j] = help[j];
			}
		}
	}

	public int maxbits(int n) {
		int res = 0;
		while (n != 0) {
			n /= 10;
			res++;
		}
		return res;
	}

	public int getDigit(int n, int d) {
		return (n / (int) Math.pow(10, d - 1)) % 10;
	}

	public static void main(String[] args) {
		int length = 100;
		int digit = 8;
		int[] ints = new int[length];
		for (int i = 0; i < ints.length; i++) {
			int i1 = (int) (Math.random() * Math.pow(10, Math.random() * digit));
			ints[i] = i1;
		}
		//2147483647
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}
		RadixSort radixSort = new RadixSort();
		radixSort.radixSort(ints);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}
	}
}
