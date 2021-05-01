package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 张璐
 * @description &{description}插入排序
 * @date 2021/3/4
 */
public class InsertSort<T> {
	public T[] sort(T[] arr, Comparator<T> comparator) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (comparator.compare(arr[j - 1], arr[j]) > 0) {
					swap(j - 1, j, arr);
				} else {
					break;
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
		InsertSort<Integer> integerInsertSort = new InsertSort<>();
		Integer[] ints = {12, 6, 2, 56213, 1235, 7, 23, 121, 6, 7, 21, 2};
		Integer[] sort = integerInsertSort.sort(ints, Comparator.comparingInt(o -> o));
		System.out.println(Arrays.toString(sort));
	}
}
