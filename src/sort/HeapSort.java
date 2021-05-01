package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 张璐
 * @description &{description}
 * @date 2021/4/16
 */
public class HeapSort {
	public static void build(int[] arr) {
		for (int i = arr.length - 1; i > -1; i--) {
			heaptify(arr, i, arr.length);
		}
	}

	public static void heapSort(int[] arr) {
		build(arr);
		int heapSize = arr.length;
		swap(arr, 0, --heapSize);
		while (heapSize > 0) {
			heaptify(arr, 0, heapSize);
			swap(arr, 0, --heapSize);
		}
	}
	public static void heaptify(int[] arr, int index, int heapSize) {
		while (index < heapSize) {
			int left = index * 2 + 1;
			if (left < heapSize) {
				int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
				largest = arr[index] > arr[largest] ? index : largest;
				if (largest == index) {
					break;
				}
				swap(arr, index, largest);
				index = largest;
			} else {
				break;
			}
		}
	}

	public static void swap(int[] arr, int a, int b) {
		if (a == b) {
			return;
		}
		arr[a] = arr[a] ^ arr[b];
		arr[b] = arr[a] ^ arr[b];
		arr[a] = arr[a] ^ arr[b];
	}

	@Test
	public void test() {
		int[] arr = new int[]{12, 2346, 1, 123, 6, 1, 2, 621346, 12, 1, 3};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
