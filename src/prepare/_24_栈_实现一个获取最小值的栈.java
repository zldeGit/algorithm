package prepare;

import java.util.Stack;

/**
 * @author 张璐
 * @description &{description} TODO 璐哥 写点注释吧 !!!!!
 * @date 2022/3/22
 */
public class _24_栈_实现一个获取最小值的栈 {
	public static class MinStack<T extends Comparable>{
		private Stack<T> stack = new Stack<T>();
		private Stack<T> minStack = new Stack<T>();

		public MinStack(){};

		public void push(T i) {
			stack.push(i);
			minStack.push(minStack.isEmpty() ? i : minStack.peek().compareTo(i) > 0 ? i : minStack.peek());
		}

		public T pop() {
			if (stack.isEmpty()) {
				throw new RuntimeException("栈空了");
			}
			T ans = stack.pop();
			minStack.pop();
			return ans;
		}

		public T getMin() {
			if (stack.isEmpty()) {
				throw new RuntimeException("栈空了");
			}
			return minStack.peek();
		}
	}

	public static void main(String[] args) {
		MinStack<Integer> stack = new MinStack<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		Integer min = stack.getMin();
		System.out.println(min);
	}
}
