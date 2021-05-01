import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

class NumArray {
	private int MAXN;
	private int[] arr;
	private int[] sum;

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length = nums1.length + nums2.length;
		int k = length / 2 + 1;
		if (nums1.length == 0) {
			return (length & 1) == 0 ? nums2[k] / 2d + nums2[k - 1] / 2d : nums2[k];
		}
		if (nums2.length == 0) {
			return (length & 1) == 0 ? nums1[k] / 2d + nums1[k - 1] / 2d : nums1[k];
		}
		int l1 = 0;
		int r1 = nums1.length - 1;
		int l2 = 0;
		int r2 = nums2.length - 1;
		while (true) {
			if (k == 1) {
				if (l1 > r1) {
					return (length & 1) == 1 ? nums2[l2] : nums2[l2] / 2d + nums2[l2 + 1] / 2d;
				}
				if (l2 > r2) {
					return (length & 1) == 1 ? nums1[l1] : nums1[l1] / 2d + nums1[l1 + 1] / 2d;
				}
				return (length & 1) == 1 ? Math.min(nums1[l1], nums2[l2]) : (nums1[l1] / 2d + nums2[l2] / 2d);
			}
			if (k / 2 > r1 - l1 + 1) {
				if (nums1[r1] > nums2[k / 2 - 1]) {
					l2 += k / 2;
					k -= k / 2;
				} else {
					k -= r1 - l1 + 1;
					return (length & 1) == 0 ? nums2[k - 1] / 2d + nums2[k - 2] / 2d : nums2[k - 1];
				}
				continue;
			}
			if (k / 2 > r2 - l2 + 1) {
				if (nums2[r2] > nums1[k / 2 - 1]) {
					l1 += k / 2;
					k -= k / 2;
				} else {
					k -= r2 - l2 - 1;
					return (length & 1) == 0 ? nums1[k - 1] / 2d + nums1[k - 2] / 2d : nums1[k - 1];
				}
				continue;
			}
			if (nums1[k / 2 - 1] > nums2[k / 2 - 1]) {
				l2 += k / 2;
				k -= k / 2;
			} else {
				l1 += k / 2;
				k -= k / 2;
			}
		}
	}

	public NumArray(int[] nums) {
		MAXN = nums.length + 1;
		arr = new int[MAXN]; // arr[0] 不用  从1开始使用
		for (int i = 1; i < MAXN; i++) {
			arr[i] = nums[i - 1];
		}
		sum = new int[MAXN << 2]; //
		build(1, nums.length, 1);
	}

	public int sumRange(int i, int j) {
		return query(i + 1, j + 1, 1, arr.length - 1, 1);

	}

	public NumArray() {
	}

	public void build(int l, int r, int rt) {
		if (l == r) {
			sum[rt] = arr[l];
			return;
		}
		int mid = (l + r) >> 1;
		build(l, mid, rt << 1);
		build(mid + 1, r, rt << 1 | 1);
		pushUp(rt);
	}

	private void pushUp(int rt) {
		sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
	}

	public int query(int L, int R, int l, int r, int rt) {
		if (L <= l && r <= R) {
			return sum[rt];
		}
		int mid = (l + r) >> 1;
		int ans = 0;
		if (L <= mid) {
			ans += query(L, R, l, mid, rt << 1);
		}
		if (R > mid) {
			ans += query(L, R, mid + 1, r, rt << 1 | 1);
		}
		return ans;
	}


}