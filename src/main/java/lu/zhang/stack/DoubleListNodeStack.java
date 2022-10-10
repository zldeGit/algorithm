package lu.zhang.stack;

import lu.zhang.entity.DoubleListNode;

import java.util.EmptyStackException;

/**
 * @author 张璐
 * @description &{description} 双向链表实现栈
 * @date 2021/3/4
 */
public class DoubleListNodeStack {
	private DoubleListNode tail;
	public int pop() {
		if (empty()) {
			throw new EmptyStackException();
		}
		int res=tail.val;
		tail = tail.last;
		return res;
	}

	public void push(int i) {
		DoubleListNode doubleListNode = new DoubleListNode(i, null, tail);
		tail = doubleListNode;
	}

	public int peek() {
		return tail.val;
	}

	public boolean empty() {
		return tail == null;
	}
}
