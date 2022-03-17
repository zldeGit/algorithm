package prepare;

import entity.ListNode;
import utils.Utils;

/**
 * @author 张璐
 * @date 2022/3/15
 */
public class _8_链表_链表K个节点的组内逆序调整 {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next ==null || k == 1) {
			return head;
		}
		ListNode cur = head;
		int count = 0;
		while (cur != null) {
			cur = cur.next;
			count++;
		}
		int i = count / k;
		cur = head;
		ListNode ans = new ListNode();
		ListNode kPreL = null;
		ListNode kCurL = ans;
		ListNode pre = null;
		for (int j = 0; j < i; j++) {
			for (int l = 0; l < k; l++) {
				if (l == 0) {
					kPreL= kCurL;
					kCurL = cur;
				}
				ListNode next = cur.next;
				if (l == k - 1) {
					kPreL.next = cur;
				}
				cur.next = pre;
				pre = cur;
				cur = next;
			}
		}
		kCurL.next = cur;
		return ans.next;
	}

	public static void main(String[] args) {
		int[] ints = new int[]{1, 2, 3, 4, 5};
		ListNode listNode = Utils.arrayToListNode(ints);
		ListNode listNode1 = reverseKGroup(listNode, 2);
		printListNode(listNode1);
		System.out.println(listNode1 == null);
	}


	public static void printListNode(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
