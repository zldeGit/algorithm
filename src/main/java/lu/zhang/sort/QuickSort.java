package lu.zhang.sort;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * @author 张璐
 * @description &{description} 快排
 * @date 2021/4/7
 */
public class QuickSort {
	public static void main(String[] args) {
		int i = 16;
		int j = 123123;
		int k = j % i;
	}

	/**
	 * 荷兰国旗问题:
	 * 给定一个数组和一个int x,修改数组 使得数组中任意数字i满足 i <=x 在左边,i>x在右边
	 */
	public static void partition(int[] arr, int x) {
		int L = -1;
		int i = 0;
		while (i < arr.length) {
			if (arr[i] <= x) {
				swap(arr, i, ++L);
			}
			i++;
		}
	}

	/**
	 * 荷兰国旗问题2:
	 * 给定一个数组和一个int x,修改数组 使得数组中任意数字i满足 i <x 在左边,i>x在右边,i=x在中间
	 */
	//假设x =arr[r]
	public static int[] partition2(int[] arr,  int l, int r) {
		int L = -1;
		int R = r;
		int i = 0;
		while (i < R) {
			if (arr[i] == arr[r]) {
				i++;
			} else if (arr[i] < arr[r]) {
				swap(arr, i++, ++L);
			} else {
				swap(arr, i, --R);
			}
		}
		swap(arr, r, R);
		return new int[]{L, R};
	}


	/**
	 * 荷兰国旗问题2+随机选择:
	 * 给定一个数组和一个int x,修改数组 使得数组中任意数字i满足 i <x 在左边,i>x在右边,i=x在中间
	 */
	//假设x =arr[r]
	public static int[] partition3(int[] arr,  int l, int r) {
		int L = -1;

		int R = r;
		int i = 0;
		while (i < R) {
			if (arr[i] == arr[r]) {
				i++;
			} else if (arr[i] < arr[r]) {
				swap(arr, i++, ++L);
			} else {
				swap(arr, i, --R);
			}
		}
		swap(arr, r, R);
		return new int[]{L, R};
	}

	public static void quickSort(int[] arr, int l, int r) {
		recursiveQuickSort(arr, l, r);
	}

	private static void recursiveQuickSort(int[] arr, int l, int r) {
		if (l>=r) {
			return;
		}
		int[] eqArr = partition2(arr, l, r);
		recursiveQuickSort(arr, l, eqArr[0]);
		recursiveQuickSort(arr, eqArr[1], l);
	}


	public static void swap(int[] arr, int a, int b) {
		if (a == b) {
			return;
		}
		arr[a] = arr[a] ^ arr[b];
		arr[b] = arr[a] ^ arr[b];
		arr[a] = arr[a] ^ arr[b];
	}

	public void testHelanguoqi() throws UnsupportedEncodingException {
		int[] ints = {1, 3, 4, 8, 1, 6, 3, 6, 89, 1111};
		recursiveQuickSort(ints, 0, ints.length - 1);
		String s = "  as +大赛  ";
		String replace = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
		String decode = URLDecoder.decode(replace, "UTF-8");
		System.out.println("encode = " + replace);
		System.out.println("decode = " + decode);
		System.out.println(Arrays.toString(ints));
	}
}
