package lu.zhang.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 张璐
 * @description &{description}
 * @date 2020/12/28
 */
public class LeetCode188 {
	public int maxProfit(int k, int[] prices) {
		int i1 = prices.length - 1;
		int result = 0;
		int buy = 0;
		boolean up = false;
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int i = 0; i < i1; i++) {
			if (prices[i+1]>prices[i]&&!up) {
				buy = prices[i];
				up = true;
				continue;
			}
			if (prices[i+1]<prices[i]&&up) {
				q.offer(prices[i] - buy);
				up = false;
				continue;
			}
		}
		if (up) {
			q.offer(prices[prices.length-1] - buy);
		}
		for (int i = 0; (i < k&&!q.isEmpty()); i++) {
			result += q.poll();
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode188 leetCode188 = new LeetCode188();
		int[] ints = {1,2,4,2,5,7,2,4,9,0};
		leetCode188.maxProfit(2,ints);
	}


}
