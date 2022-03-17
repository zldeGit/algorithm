package prepare;

/**
 * @author 张璐
 * @date 2022/3/11
 */
//查找大于等于num的最左位置
public class _3_二分查询大于Target最左边的位置 {
	public static void main(String[] args) {
		int[] ints = {1, 3, 4, 5, 6, 7, 8, 10, 12, 12, 15};
		System.out.println(mostLeft(ints, 16));
	}

	public static int mostLeft(int arr[], int num) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int l = 0;
		int r = arr.length - 1;
		int pos = -1;
		while (l <= r) {
			int mid = (l + r) >> 1;
			if (arr[mid] >= num) {
				pos = mid;
				r = mid - 1;
			}else{
				l= mid + 1;
			}
		}
		return pos;
	}
}
