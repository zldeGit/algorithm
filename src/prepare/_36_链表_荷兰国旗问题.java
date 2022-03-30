package prepare;

import entity.ListNode;
import sun.reflect.generics.tree.Tree;
import utils.Utils;

/**
 * @author 张璐
 * @date 2022/3/29
 */
public class _36_链表_荷兰国旗问题 {
	public static ListNode partition(ListNode node, int target) {
		if (node == null) {
			return null;
		}
		ListNode hiHead = null;
		ListNode hiTail = null;
		ListNode eqHead = null;
		ListNode eqTail = null;
		ListNode loHead = null;
		ListNode loTail = null;
		ListNode cur = node;
		while (cur != null) {
			if (cur.val > target) {
				if (hiHead == null) {
					hiHead = cur;
					hiTail = cur;
				} else {
					hiTail.next=cur;
					hiTail=cur;
				}
			} else if (cur.val == target) {
				if (eqHead == null) {
					eqHead = cur;
					eqTail = cur;
				} else {
					eqTail.next=cur;
					eqTail=cur;
				}
			} else {
				if (loHead == null) {
					loHead = cur;
					loTail = cur;
				} else {
					loTail.next=cur;
					loTail=cur;
				}
			}
			cur = cur.next;

		}
		if (loTail == null) {
			if (eqHead == null) {
				hiTail.next = null;
				return loHead;
			} else {
				if (hiHead == null) {
					eqTail.next = null;
				} else {
					eqTail.next = hiHead;
					hiTail.next = null;
				}
				return eqHead;
			}
		} else {
			if (eqHead == null) {
				if (hiHead == null) {
					loTail.next = null;
				} else {
					loTail.next = hiHead;
					hiTail.next = null;
				}
			} else {
				if (hiHead == null) {
					eqTail.next = null;
					loTail.next = eqHead;
				} else {
					hiTail.next = null;
					eqTail.next=hiHead;
					loTail.next=eqHead;
				}
			}
			return loHead;
		}
	}

	public static void main(String[] s) {
		for (int i = 0; i < 10000; i++) {
			int[] arr = Utils.generateRandomIntArr(1000, 1000);
			if (arr.length==0) {
				continue;
			}
			int target = arr[(int) (Math.random() * arr.length)];
			ListNode listNode = Utils.arrayToListNode(arr);
			ListNode partition = partition(listNode,target);
			boolean check = check(partition, target);
			if (!check) {
				System.out.println("check = " + check);
				break;
			}
		}
	}

	private static boolean check(ListNode partition,int target) {
		ListNode cur = partition;
		boolean lo = true;
		boolean eq = false;
		boolean hi = false;
		while (cur != null) {
			int val = cur.val;
			if (val<target) {
				if (lo && !eq && !hi) {

				} else {
					return false;
				}
			} else if (val == target) {
				if (lo && !eq && !hi) {
					lo = false;
					eq = true;
					hi = false;
				} else {
					if (!lo && eq && !hi) {
					} else {
						return false;
					}
				}
			} else {
				if (lo && !eq && !hi) {
					lo = false;
					eq = false;
					hi = true;
				} else if (!lo && eq && !hi) {
					eq= false;
					hi =true;
				} else if (!lo && !eq && hi){
				}else {
					return false;
				}
			}
			cur = cur.next;
		}
		return true;
	}
}
