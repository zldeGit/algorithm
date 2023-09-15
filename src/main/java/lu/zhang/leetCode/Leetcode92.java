package lu.zhang.leetCode;

import lu.zhang.entity.ListNode;
import lu.zhang.utils.Utils;

/**
 * //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链 //表节点，返回 反转后的链表
 * 。 // // // 示例 1： // // //输入：head = [1,2,3,4,5], left = 2, right = 4 //输出：[1,4,3,2,5] // // // 示例
 * 2： // // //输入：head = [5], left = 1, right = 1 //输出：[5] // // // // // 提示： // // // 链表中节点数目为 n //
 * 1 <= n <= 500 // -500 <= Node.val <= 500 // 1 <= left <= right <= n // // // // // 进阶：
 * 你可以使用一趟扫描完成反转吗？ // Related Topics 链表 👍 1218 👎 0
 */
public class Leetcode92 {

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    if (left == right) {
      return head;
    }
    ListNode ans = new ListNode();
    ans.next = head;
    int count = 0;
    ListNode ll = ans;
    while (count < left - 1) {
      ll = ll.next;
      count++;
    }
    ListNode lr = ll.next;
    ListNode rl = ll;
    while (count < right) {
      rl = rl.next;
      count++;
    }
    ListNode rr = rl.next;

    ListNode pre = ll;
    ListNode cur = lr;
    int l = left;
    while (l <= right) {
      l++;
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    ll.next = rl;
    lr.next = rr;
    return ans.next;
  }

  public static void main(String[] args) {
    ListNode listNode = Utils.arrayToListNode(new int[]{1, 2, 3, 4, 5});
    ListNode listNode2 = reverseBetween(listNode, 2, 4);
    System.out.println(listNode2);
  }
}
