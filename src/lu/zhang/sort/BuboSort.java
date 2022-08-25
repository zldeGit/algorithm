package lu.zhang.sort;

import java.util.Comparator;

/**
 * @author 张璐
 * @description &{description} TODO 璐哥 写点注释吧 !!!!!
 * @date 2021/3/4
 */
public class BuboSort<T> {
	public T[] sort(T[] arr, Comparator<T> comparator) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j + 1 < arr.length - i; j++) {
				if (comparator.compare(arr[j], arr[j + 1]) > 0) {
					swap(j, j + 1, arr);
				}
			}
		}
		return arr;
	}

	private void swap(int i, int j, T[] arr) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		BuboSort<Integer> sort = new BuboSort<>();
		Integer[] ints = {12, 6, 2, 56213, 1235, 7, 23, 121, 6, 7, 21, 2};
		sort.sort(ints, Comparator.comparingInt(o -> o));
	}
}
