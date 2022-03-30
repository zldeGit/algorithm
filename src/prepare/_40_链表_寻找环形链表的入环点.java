package prepare;

import entity.ListNode;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 张璐
 * @date 2022/3/29
 */
public class _40_链表_寻找环形链表的入环点 {
	public static ListNode findLoopNode(ListNode node) {
		if (node==null) {
			return null;
		}
		ListNode slow= node;
		ListNode fast= node;
		do {
			fast = fast.next.next;
			slow = slow.next;
		} while (fast != null && fast.next != null && fast != slow);
		if (fast!=slow) {
			return null;
		}
		fast = node;
		while (fast != slow) {
			fast=fast.next;
			slow=slow.next;
		}
		return fast;
	}
}
