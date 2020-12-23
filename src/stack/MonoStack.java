package stack;

import java.util.Stack;

/**
 * @author 张璐
 * @description &{description} 单调栈
 * @date 2020/12/9Z
 * 思路:
 *
 */
public class MonoStack {
	//给定一个不含有重复值的数组arr，找到每一个i 位置左边和右边离i 位置最近且值比arr[i]小的位置。返回所有位置相应的信息。
	public int[][] rightWay(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int[][] result = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.empty() && arr[stack.peek()] > arr[i]) {//弹出所有比当前遍历的位置大的元素 i即为这些元素的右边最近且下的位置 左位置默认是左边一位
				Integer pop = stack.pop();
				result[pop][1] = i;
				result[pop][0] = stack.empty() ? -1 : stack.peek();
			}
			stack.push(i);
		}
		while (!stack.empty()) {
			Integer pop = stack.pop();
			result[pop][0] = stack.empty() ? -1 : stack.peek();
			result[pop][1] = -1;
		}

		return result;
	}

	public static void main(String[] args) {
		MonoStack monoStack = new MonoStack();
		monoStack.rightWay(new int[]{3, 4, 1, 5, 6, 2, 7});
	}
}
