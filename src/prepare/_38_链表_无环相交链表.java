package prepare;

import entity.ListNode;

/**
 * @author 张璐
 * @date 2022/3/29
 */
public class _38_链表_无环相交链表 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null) return null;
		int countA=0;
		ListNode curA = headA;
		while(curA!=null){
			countA++;
			curA=curA.next;
		}
		int countB=0;
		ListNode curB =headB;
		while(curB!=null){
			countB++;
			curB=curB.next;
		}
		curA= countA>countB?headA:headB;
		curB= countA>countB?headB:headA;
		int n = Math.abs(countA-countB);
		while(n>0){
			curA=curA.next;
			n--;
		}
		while(curA!=curB){
			curA=curA.next;
			curB=curB.next;
		}
		return curA;
	}
}
