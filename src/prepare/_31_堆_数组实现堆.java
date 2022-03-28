package prepare;

import utils.Utils;

import java.util.Arrays;

/**
 * @author 张璐
 * @date 2022/3/23
 */
public class _31_堆_数组实现堆 {
	public static class Heap<T extends Comparable<T>> {
		private Comparable[] arr ;
		private int size;
		public Heap(int size){
			this.arr = new Comparable[size];
		}

		public Heap(T[] inArr) {
			this.arr = inArr;
			for (int i = arr.length - 1; i >= 0; i--) {
				selfDown(i, arr.length - 1);
			}
		}

		public T get(int i) {
			return (T) arr[i];
		}

		public void offer(T e) {
			if (size >= arr.length) {
				throw new RuntimeException("full !");
			}
			arr[size++] = e;
			selfUp(e, size - 1);
		}

		public T poll() {
			if (size == 0) {
				throw new RuntimeException("empty !");
			}
			T ans = (T) arr[0];
			Utils.swap(0, size - 1, arr);
			selfDown(0, --size - 1);
			return ans;
		}

		private void selfUp(T e,int index) {
			while (index> 0) {
				int parent = (index - 1) >> 1;
				if (arr[parent].compareTo(e) > 0) {
					Utils.swap(parent, index, arr);
					index = parent;
				} else {
					break;
				}
			}
		}

		public void selfDown(int L, int R) {
			int left = (L << 1) + 1;
			while (left <= R) {
				int min = left + 1 <= R && arr[left].compareTo(arr[left + 1]) > 0 ? left + 1 : left;
				if (arr[min].compareTo(arr[L]) > 0) {
					break;
				}
				Utils.swap(L, min, arr);
				L=min;
				left = (L << 1) + 1 ;
			}
		}

		public boolean isEmpty() {
			return !(size > 0);
		}
		public void heapSort() {
			for (int i = arr.length-1; i >0; i--) {
				Utils.swap(0, i, arr);
				selfDown(0, i-1);
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			Integer[] arr = Arrays.stream(Utils.generateRandomIntArr(1000, 100)).boxed().toArray(Integer[]::new);
			Heap<Integer> heap = new Heap<>(arr);
			heap.heapSort();
			if (!check(arr)) {
				System.out.println("opps!");
				System.out.println(Arrays.toString(arr));
				break;
			}
		}

	}

	public static boolean check(Integer[] arr) {
		if (arr.length < 2) {
			return true;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				return false;
			}
		}
		return true;
	}


}
