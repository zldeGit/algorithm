package prepare;

/**
 * @author 张璐
 * @date 2022/3/21
 */
//一个数组中,只有一种数字出现了K次,其他数出现了M次 切 M>K,找出出现K次的数
public class _22_位运算_找到出现K次的数 {
	public static int singleNumber(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		return getK(nums, 1, 3);
	}


	public static int getK(int[] arr, int k, int m) {
		int[] bit = new int[32];
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = 0; j < 32; j++) {
				bit[j] += (temp & 1);
				temp >>= 1;
			}
		}
		int ans = 0;
		for (int i = 0; i < bit.length; i++) {
			if (bit[i] % m > 0) {
				ans |= (1 << i);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {-2,-2,1,1,4,1,4,4,-4,-2};
		System.out.println(singleNumber(nums));
	}
}
