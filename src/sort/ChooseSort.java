package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 张璐
 * @description &{description} TODO 璐哥 写点注释吧 !!!!!
 * @date 2021/3/4
 */
public class ChooseSort<T> {
	public T[] sort(T[] arr, Comparator<T> comparator){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j <arr.length ; j++) {
				if (comparator.compare(arr[j], arr[i])<0) {
					swap(i, j, arr);
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
		ChooseSort<Integer> integerChooseSort = new ChooseSort<>();
		Integer[] ints = {12, 6, 2, 56213, 1235, 7, 23, 121, 6, 7, 21, 2};
		Integer[] sort = integerChooseSort.sort(ints, Comparator.comparingInt(o -> o));
		System.out.println(Arrays.asList(sort));
	}
}
