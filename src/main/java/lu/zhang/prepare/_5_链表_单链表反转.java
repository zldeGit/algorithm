package lu.zhang.prepare;

import lu.zhang.entity.ListNode;

/**
 * @author 张璐
 * @date 2022/3/15
 */
public class _5_链表_单链表反转 {

  public ListNode reverseList(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}
