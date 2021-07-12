import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 张璐
 * @date 2021/2/18
 */
public class Test {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		AtomicInteger integer = new AtomicInteger(0);
//		ExecutorService executorService = Executors.newFixedThreadPool(6);
//		Semaphore semaphore = new Semaphore(0);
//		Object o = new Object();
//		for (int i = 0; i < 6; i++) {
//			int finalI = i;
//			executorService.submit(() -> {
//
//			});
//		}
		String url = "123";
		try {
			url = "456";
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(url);
	}

	public static void test() {
		int i = 0;
		int j = 1;
		System.out.println("j^1 = " + (j ^ 1));
		System.out.println("i^1 = " + (i ^ 1));
	}

	public boolean isSubsequence(String s, String t) {
		int indexS = 0;
		int indexT = 0;
		while (indexS < s.length() && indexT < t.length()) {
			if (s.charAt(indexS) == t.charAt(indexT)) {
				indexS++;
				indexT++;
				continue;
			}
			indexT++;
		}
		if (indexS >= s.length()) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean find132pattern(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return false;
		}

		// 左侧最小值
		int leftMin = nums[0];
		// 右侧所有元素
		TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

		for (int k = 2; k < n; ++k) {
			rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
		}

		for (int j = 1; j < n - 1; ++j) {
			if (leftMin < nums[j]) {
				Integer next = rightAll.ceilingKey(leftMin + 1);
				if (next != null && next < nums[j]) {
					return true;
				}
			}
			leftMin = Math.min(leftMin, nums[j]);
			rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
			if (rightAll.get(nums[j + 1]) == 0) {
				rightAll.remove(nums[j + 1]);
			}
		}

		return false;
	}

	public static boolean process(Stack<Integer[]> stacks, Integer num) {
		if (stacks.empty()) {
			return false;
		}
		Integer[] pop = stacks.pop();
		if (pop[0] < num && num < pop[1]) {
			stacks.push(pop);
			return true;
		}
		boolean process = process(stacks, num);
		stacks.push(pop);
		return process;
	}

}
