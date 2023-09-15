package lu.zhang.leetCode;

import java.util.HashSet;
import lu.zhang.entity.ListNode;

/**
 * @author 张璐
 * @description &{description} TODO 璐哥 写点注释吧 !!!!!
 * @date 2021/2/23
 */
public class Leetcode24 {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode res = head.next;
    head.next = res.next;
    res.next = head;
    while (head.next != null && head.next.next != null) {
      ListNode fourth = head.next.next.next;
      ListNode third = head.next.next;
      ListNode second = head.next;
      head.next = third;
      second.next = fourth;
      third.next = second;
      head = second;
    }
    return res;
  }


  public int lengthOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<>();
    int i = 0;
    int max = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      i++;
      if (set.contains(c)) {
        max = Math.max(set.size(), max);
        set.clear();
      }
      set.add(c);
    }
    return 0;
  }

  public static void main(String[] args) {
    Leetcode24 leetcode24 = new Leetcode24();
    leetcode24.lengthOfLongestSubstring(" ");
  }
}
