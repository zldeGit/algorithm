package lu.zhang.prepare;

import lu.zhang.entity.ListNode;

/**
 * @author 张璐
 * @date 2022/3/29
 */
public class _40_链表_寻找环形链表的入环点 {

  public static ListNode findLoopNode(ListNode node) {
    if (node == null) {
      return null;
    }
    ListNode slow = node;
    ListNode fast = node;
    do {
      fast = fast.next.next;
      slow = slow.next;
    } while (fast != null && fast.next != null && fast != slow);
    if (fast != slow) {
      return null;
    }
    fast = node;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }

  public static ListNode findLoopNode(ListNode node, int N) {
    if (node == null || node.next == null) {
      return null;
    }
    ListNode slow = node;
    ListNode fast = node;
    int count = 0;
    loop:
    do {
      slow = slow.next;
      for (int i = 0; i < N; i++) {
        if (fast == null) {
          break loop;
        }
        fast = fast.next;
      }
      count++;
      if (count > 1000) {
        throw new RuntimeException("ops");
      }
    } while (fast != null && fast.next != null && fast != slow);

    if (fast != slow) {
      return null;
    }
    fast = node;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }

  public static ListNode randomListNode(int maxLength) {
    int length = (int) (Math.random() * (maxLength)) + 1;
    int loopIndex = (int) (Math.random() * (maxLength + 1));
    ListNode head = new ListNode();
    ListNode pre = head;
    ListNode loop = null;
    for (int i = 0; i < length; i++) {
      ListNode cur = new ListNode();
      if (i == loopIndex) {
        loop = cur;
      }
      pre.next = cur;
      pre = cur;
    }
    pre.next = loop;
    if (loop != null) {
      loop.val = loopIndex;
    }
    head.next.val = loopIndex;
    return head.next;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10000; i++) {
      ListNode node = randomListNode(10);
      int val = node.val;
      ListNode loopNode = findLoopNode(node, 3);
      if (loopNode != null) {
        System.out.println(loopNode.val == val);
      }
    }
  }
}
