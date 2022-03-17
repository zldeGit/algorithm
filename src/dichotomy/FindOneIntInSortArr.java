package dichotomy;

/**
 * @author 张璐
 * @description &{description}
 * @date 2021/3/4
 */
public class FindOneIntInSortArr {
	public int finInt(int[] arr, int num) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) >> 1;
			if (arr[mid] > num) {
				right = mid - 1;
			}
			if (arr[mid] < num) {
				left = mid + 1;
			}
			if (arr[mid] == num) {
				return mid;
			}
		}
		return 0;
	}

	public int findIntMostLeft(int[] arr, int num) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] <= num) {
				left = mid + 1;
			}
			if (arr[mid] > num) {
				right = mid - 1;
			}
		}
		return left == arr.length ? -1 : left;
	}

	public int findMostRight(int[] arr, int num) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] < num) {
				left = mid + 1;
			}
			if (arr[mid]>=num) {
				right=mid-1;
			}
		}
		return left==arr.length?-1:left;
	}

	public static void main(String[] args) {
		int[] num = {1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9, 9, 9, 9, 10};
		FindOneIntInSortArr findOneIntInSortArr = new FindOneIntInSortArr();
		int intMostLeft = findOneIntInSortArr.findIntMostLeft(num, 11);
		int mostRight = findOneIntInSortArr.findMostRight(num, 0);
		System.out.println(intMostLeft);
		System.out.println("mostRight = " + mostRight);

	}
}
