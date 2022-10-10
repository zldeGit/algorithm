package lu.zhang.entity;

/**
 * @author 张璐
 * @description &{description}
 * @date 2021/2/23
 */
public class DoubleListNode {
	public int val;
	public DoubleListNode next;
	public DoubleListNode last;

	DoubleListNode() {
	}

	public DoubleListNode(int val, DoubleListNode next, DoubleListNode last) {
		this.val = val;
		this.next = next;
		this.last = last;
	}

	DoubleListNode(int val) {
		this.val = val;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		if (nums.length < 3) {
			return ;
		}
		int res = 0;
		int pre = nums[1] - nums[0];
		int start = 0;
		for (int i = 2; i < nums.length; i++) {
			int x = nums[i] - nums[i - 1];
			int i1 = i  - start;
			if (x == pre && i1 > 1) {
				res += i1 - 1;
			}
			if (x != pre) {
				start = i - 1;
				pre = x;
			}
		}
		System.out.println(res);
	}

}
