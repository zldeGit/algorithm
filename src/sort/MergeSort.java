package sort;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author 张璐
 * @description &{description}
 * @date 2021/3/10
 */
public class MergeSort {
	public int[] mergeSort(int[] arr) {
		process(arr, 0, arr.length - 1);
		return arr;
	}

	private void process(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		int mid = l + ((r - l) >> 1);
		process(arr, l, mid);
		process(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

	private void merge(int[] arr, int l, int mid, int r) {
		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = mid + 1;
		int i = 0;
		while (p1 <= mid && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
	}

	public static int removeDuplicates(int[] nums) {
		int res = 0;
		int size = nums.length - 1;
		int i = 0;
		while (i < size) {
			int j = i + 1;
			if (nums[i] == nums[j]) {
				nums[res++] = nums[i];
				nums[res++] = nums[i];
				while (++j < nums.length && nums[j] == nums[i]) {
				}
				i = j;
			} else {
				nums[res++] = nums[i];
				i = j;
			}
		}
		if (i == size) {
			nums[res++] = nums[size];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] ints = {-2147483647,0,-2147483647,2147483647};

		countRangeSum(ints, -564, 3864);
	}


	/*
	 *在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
	 * 例子： [1,3,4,2,5]
	 * 1左边比1小的数：没有
	 * 3左边比3小的数：1
	 * 4左边比4小的数：1、3
	 * 2左边比2小的数：1
	 * 5左边比5小的数：1、3、4、 2
	 * 所以数组的小和为1+1+3+1+1+3+4+2=16
	 * */
	public static int minSum(int arr[]) {
		int res = 0;
		int p = 2;
		while (true) {
			int length = arr.length;
			if (!(p < length * 2)) break;
			int i = 0;
			while (i < arr.length) {
				int[] help = new int[Math.min(arr.length - i, p)];
				if (help.length <= p >> 1) {
					i += p;
					continue;
				}
				int M = i + (p >> 1);
				int R = i + help.length;
				int left = i;
				int right = M;
				int h = 0;
				while (left < M && right < R) {
					if (arr[left] < arr[right]) {
						res += arr[left] * (R - right);
						help[h++] = arr[left++];
					} else {
						help[h++] = arr[right++];
					}
				}
				while (left < M) {
					help[h++] = arr[left++];
				}
				while (right < help.length) {
					help[h++] = arr[right++];
				}
				for (int j = 0; j < help.length; j++) {
					arr[i + j] = help[j];
				}
				i += p;
			}
			p <<= 1;
		}
		return res;
	}
	/*
	给定一个整数数组nums 。区间和S(i, j)表示在nums中，位置从i到j的元素之和，包含i和j(i ≤ j)。

		请你以下标 i （0 <= i <= nums.length ）为起点，元素个数逐次递增，计算子数组内的元素和。

		当元素和落在范围 [lower, upper] （包含lower和upper）之内时，记录子数组当前最末元素下标 j ，记作 有效 区间和S(i, j) 。

		求数组中，值位于范围 [lower, upper] （包含lower和upper）之内的 有效 区间和的个数。
*/
	public static int countRangeSum(int[] nums, int lower, int upper) {
		long [] sum=new long[nums.length];
		sum[0]=nums[0];
		for(int i=1;i<nums.length;i++){
			sum[i]=sum[i-1]+nums[i];
		}
		int process = process(sum, 0, sum.length - 1, lower, upper);
		return process;
	}
	public static int process(long[] sum,int L,int R,int lower,int upper){
		if(L==R){
			return sum[L]>=lower&&sum[L]<=upper? 1:0;
		}
		int mid=L+((R-L)>>1);
		int left = process(sum, L, mid, lower, upper);
		int right = process(sum, mid + 1, R, lower, upper);
		int merge = merge(sum, L, mid, R, lower, upper);
		return left + right + merge;
	}
	public static int merge(long[] sum, int L, int mid, int R, int lower, int upper){
		int windowL=L;
		int windowR=L;
		int res=0;
		for(int i=mid+1;i<=R;i++){
			long left=sum[i]-upper;
			long right=sum[i]-lower;
			while(windowL<=mid&&sum[windowL]<left){
				windowL++;
			}

			while(windowR<=mid&&sum[windowR]<=right){
				windowR++;
			}
			res+=windowR-windowL;
		}
		int pl=L;
		int pr=mid+1;
		int[] help=new int[R-L+1];
		int i=0;
		while(pl<=mid&&pr<=R){
			help[i++]= (int) (sum[pl]<sum[pr]?sum[pl++]:sum[pr++]);
		}
		while(pl<=mid){
			help[i++]= (int) sum[pl++];
		}
		while(pr<=R){
			help[i++]= (int) sum[pr++];
		}
		for( i=0;i<help.length;i++){
			sum[L+i]=help[i];
		}
		return res;
	}
}
