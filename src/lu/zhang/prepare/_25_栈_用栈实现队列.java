package lu.zhang.prepare;

import java.util.Stack;

/**
 * @author 张璐
 * @description &{description} TODO 璐哥 写点注释吧 !!!!!
 * @date 2022/3/22
 */
public class _25_栈_用栈实现队列 {
	public static class StackQueue<T> {
		private Stack<T> push = new Stack<>();
		private Stack<T> pop = new Stack<>();

		public StackQueue() {
		}

		;

		public void push(T o) {
			push.push(o);
		}

		public T pop() {
			if (pop.isEmpty()) {
				while (!push.isEmpty()) {
					pop.push(push.pop());
				}
			}
			if (pop.isEmpty()) {
				throw new RuntimeException("栈空了");
			}
			return pop.pop();
		}
	}

	public static void main(String[] args) {
		StackQueue<Integer> queue = new StackQueue<>();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.push(5);
		queue.push(6);
		queue.push(7);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
