package stack;

import java.util.Stack;

/**
 * @author 张璐
 * @description &{description} 使用递归反转栈
 * 思路:
 * 1,递归拿到栈低的数字,存在递归调用栈中,调用方法结束入栈
 *
 * @date 2020/12/7
 */
public class ReverseStack {
	private void reverseStack(Stack<Integer> stack) {
		if (stack.empty()) {
			return ;
		}
		int andRemoveLast = getAndRemoveLast(stack);
		reverseStack(stack);
		stack.push(andRemoveLast);
	}

	private int getAndRemoveLast(Stack<Integer> stack) {
		int pop = stack.pop();
		if (stack.empty()) {
			return pop;
		} else {
			int last = getAndRemoveLast(stack);
			stack.push(pop);
			return last;
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		ReverseStack stackReverse = new ReverseStack();
		stackReverse.reverseStack(stack);
	}
}
