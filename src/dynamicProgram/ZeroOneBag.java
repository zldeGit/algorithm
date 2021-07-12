package dynamicProgram;

import java.util.Arrays;

/**
 * @author 张璐
 * @date 2021/7/12
 */
public class ZeroOneBag {
	public static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		Arrays.sort(nums);
		int N=nums.length;
		int R = N - 1;
		for (int i = 0; i < N; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			while (i<R&&nums[i]+nums[R]>target) {
				R--;
			}
			if (nums[i]+nums[R]==target) {
				res[0] = i;
				res[1] = R;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] ints = {2, 7, 5, 11};
		twoSum(ints, 9);
	}
}
