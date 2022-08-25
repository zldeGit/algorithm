package lu.zhang.prepare;

import lu.zhang.entity.ListNode;

/**
 * @author 张璐
 * @date 2022/3/15
 */
public class _7_链表_链表实现队列 {
	private ListNode head = null;
	private ListNode tail = null;

	private int size = 0;
	public _7_链表_链表实现队列() {
	}

	private boolean isEmpty() {
		return size == 0;
	}

	private boolean add(int  i) {
		ListNode node = new ListNode(i);
		if (size == 0) {
			this.head = node;
			this.tail = node;
			size++;
			return true;
		}
		tail.next = node;
		tail=node;
		size++;
		return true;
	}

}
