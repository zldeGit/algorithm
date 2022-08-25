package lu.zhang.prepare;

import lu.zhang.entity.ListNode;

/**
 * @author 张璐
 * @date 2022/3/15
 */
public class _6_链表_两个链表相加 {
	public static ListNode addNode(ListNode head1, ListNode head2) {
		ListNode cur1 = head1;
		ListNode cur2 = head2;
		ListNode ans = new ListNode();
		ListNode cur = ans;
		int more = 0;
		while (cur1 != null && cur2 != null) {
			int add = cur1.val + cur2.val + more;
			ListNode next = new ListNode(add % 10);
			cur.next = next;
			cur = next;
			more = add / 10;
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		if (cur1 == null) {
			while (cur2 != null) {
				int add = cur2.val + more;
				ListNode next = new ListNode(add % 10);
				cur.next = next;
				cur = next;
				more = add / 10;
				cur2 = cur2.next;
			}
		}
		while (cur1 != null) {
			int add = cur1.val + more;
			ListNode next = new ListNode(add % 10);
			cur.next = next;
			cur = next;
			more = add / 10;
			cur1 = cur1.next;
		}
		return ans.next;
	}

	public static void main(String[] args) {
		int[] ints1 = {3, 4, 6, 1};
		int[] ints2 = {7, 9, 7};
		ListNode listNode1 = arrayToListNode(ints1);
		ListNode listNode2 = arrayToListNode(ints2);
		ListNode listNode = addNode(listNode1, listNode2);
		printListNode(listNode);
	}
	public static ListNode arrayToListNode(int[] arr) {
		if (arr==null||arr.length==0) {
			return null;
		}
		ListNode head = new ListNode();
		ListNode cur =head;
		for (int i = 0; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			cur.next=node;
			cur=node;
		}
		return head.next;
	}

	public static void printListNode(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
