package queue;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author 张璐
 * @description &{description} 栈的实现
 * @date 2021/3/9
 */
public class StackQueue  {
	private Stack<Integer> stack;
	private Stack<Integer> stack2;


	public boolean add(Integer integer) {
		return false;
	}

	
	public boolean offer(Integer integer) {
		return false;
	}

	
	public Integer remove() {
		return null;
	}

	
	public Integer poll() {
		Integer peek = this.peek();
		stack2.pop();
		return peek;
	}

	
	public Integer element() {
		Integer peek = this.peek();
		if (peek != null) {
			return peek;
		} else {
			throw new NoSuchElementException();
		}
	}

	
	public Integer peek() {
		if (!stack2.empty()) {
			return stack.peek();
		}
		while (stack.empty()) {
			stack2.push(stack.pop());
		}
		return stack2.empty() ? null : stack2.peek();
	}
}
