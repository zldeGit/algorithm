class Solution {
	public static int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
				swap(nums[i] - 1, i, nums);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] - 1 != i) {
				return i+1;
			}
		}
		return nums.length + 1;
	}

	public static void swap(int i, int j, int[] arr) {
		if (i == j) return;
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 0};
		int i = firstMissingPositive(arr);
	}
}