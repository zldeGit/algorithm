package lu.zhang.prepare;

import lu.zhang.entity.ListNode;

/**
 * @author 张璐
 * @date 2022/3/29
 */
public class _39_链表_有环相交链表 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode loopA = _40_链表_寻找环形链表的入环点.findLoopNode(headA);
    ListNode loopB = _40_链表_寻找环形链表的入环点.findLoopNode(headB);
    if (loopA == loopB) {
      int countA = 0;
      ListNode curA = headA;
      while (curA != loopA) {
        countA++;
        curA = curA.next;
      }
      int countB = 0;
      ListNode curB = headB;
      while (curB != loopA) {
        countB++;
        curB = curB.next;
      }
      curA = countA > countB ? headA : headB;
      curB = countA > countB ? headB : headA;
      int n = Math.abs(countA - countB);
      while (n > 0) {
        curA = curA.next;
        n--;
      }
      while (curA != curB) {
        curA = curA.next;
        curB = curB.next;
      }
      return curA;
    } else {
      ListNode cur = loopA.next;
      while (cur != loopB && cur != loopA) {
        cur = cur.next;
      }
      if (cur == loopA) {
        return null;
      } else {
        return loopA;
      }
    }
  }
}
