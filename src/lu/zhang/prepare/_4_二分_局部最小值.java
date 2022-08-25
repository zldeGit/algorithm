package lu.zhang.prepare;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author 张璐
 * @date 2022/3/11
 */
//找到局部最小值  一个数组中任意相邻的两个数不相同 如果数组中 i位置的数同时小于左右两边的数 则 i为一个局部最小值
public class _4_二分_局部最小值 {
	public static void main(String[] args) {
		Integer[] aa = new Integer[]{9857, 2435, 2180, 6918, 6537, 8970, 9610, 780, 1422, 2192, 1555, 9107, 2196, 1813, 5022, 1311, 6818, 5157, 5928, 7721, 4905, 298, 9899, 555, 2220, 5292, 7727, 6831, 2490, 5053, 2366, 7998, 7621, 7239, 2248, 3016, 1742, 2129, 1362, 5588, 1876, 8661, 5846, 7766, 4311, 473, 8925, 7651, 996, 9962, 9588, 8180, 9334, 2039, 3191, 248, 7160, 5242, 5118};
		partMin(aa);
		for (int i = 0; i < 10000; i++) {
			int length= (int) (Math.random() * 101);
			Integer[] ints = null;
			HashSet<Integer> sets = new HashSet<>();
			for (int j = 0; j < length; j++) {
				sets.add((int) (Math.random() * 9999));
			}
			ints = new Integer[sets.size()];
			sets.toArray(ints);
			length = sets.size();
			int a = partMin(ints);
			if (a == -1) {
				System.out.println(length);
				System.out.println(Arrays.toString(ints));
				continue;
			}
			if (a == 0&&length>1&&(ints[a]>ints[a+1]) ) {
					System.out.println("出错了");
				System.out.println(a);
				System.out.println(Arrays.toString(ints));

			}else if (length>1&& a == ints.length - 1&&(ints[a-1]<ints[a])) {
				System.out.println("出错了");
				System.out.println(a);
				System.out.println(Arrays.toString(ints));
			} else if (a!=0&&a!=ints.length-1&&length > 2 && ((ints[a] > ints[a - 1]) || ints[a] > ints[a + 1])) {
				System.out.println("出错了");
				System.out.println(a);
				System.out.println(Arrays.toString(ints));
			}
		}
	}

	public static int partMin(Integer arr[]) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		if (arr.length == 1) {
			return 0;
		}
		if (arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int l=0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) >> 1;
			if (mid == 0) {
				return 1;
			}
			if (mid == arr.length - 1) {
				return arr.length - 2;
			}
			if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
				return mid;
			}else if (arr[mid] > arr[mid - 1]) {
				r = mid - 1;
			}else if (arr[mid] > arr[mid + 1]) {
				l = mid + 1;
			}
		}
		return -1;
	}
}
