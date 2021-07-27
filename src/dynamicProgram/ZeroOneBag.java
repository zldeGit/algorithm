package dynamicProgram;

import java.util.ArrayList;

/**
 * @author 张璐
 * @date 2021/7/12
 */
public class ZeroOneBag {

	public void radixSort(int[] arr) {
		int N = 0;
		for (int i = 0; i < arr.length; i++) {
			N = Math.max(N, maxbits(arr[i]));
		}
		int[] help = new int[arr.length];
		for (int d = 1; d <= N; d++) {
			int[] count = new int[10];
			for (int i = 0; i < arr.length; i++) {
				count[getDigit(arr[i], d)]++;
			}
			for (int i = 1; i < count.length; i++) {
				count[i] = count[i - 1] + count[i];
			}
			for (int i = arr.length-1; i >=0; i--) {
				int j = getDigit(arr[i], d);
				help[count[j] - 1] = arr[i];
				count[j]--;
			}
			for (int i = 0; i < help.length; i++) {
				arr[i] = help[i];
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
		return (n /  (int) Math.pow(10, d - 1)) % 10;
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
		ZeroOneBag zeroOneBag = new ZeroOneBag();
		zeroOneBag.radixSort(ints);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}
	}
}
