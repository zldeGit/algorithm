package stack;

import java.util.Random;
import java.util.Stack;

/**
 * @author 张璐
 * @description &{description} 只用一个栈的辅助空间对另一个栈排序
 * @date 2020/12/7
 */
public class StackSort {
	public Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<>();
		while (!stack.empty()) {
			Integer pop = stack.pop();
			while (!help.empty() && help.peek() >pop ){
				stack.push(help.pop());
			}
			help.push(pop);
		}
		return help;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Random random = new Random(100);
		for (int i = 0; i < 10; i++) {
			stack.push(random.nextInt());

		}
		StackSort stackSort = new StackSort();
		stackSort.sort2(stack);
	}


	public void sort2(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<>();
		while (!stack.empty()) {
			Integer pop = stack.pop();
			while (!help.empty() && help.peek() > pop) {
				stack.push(help.pop());
			}
			help.push(pop);
		}
		System.out.println(help);

	}
}
