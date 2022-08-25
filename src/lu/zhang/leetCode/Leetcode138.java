package lu.zhang.leetCode;

/**
 * @author 张璐
 * @date 2022/8/11
 */
public class Leetcode138 {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		Node mid = null;
		Node next = null;
		Node random = null;
		while (cur != null) {
			next = cur.next;
			mid = new Node(cur.val);
			cur.next = mid;
			mid.next = next;
			cur = next;
		}
		cur = head;
		while(cur != null){
			mid = cur.next;
			random = cur.random;
			if (random!=null) {
				mid.random = random.next;
			}
			cur = mid.next;
		}
		Node res = head.next;
		cur = head;
		while(true){
			mid = cur.next;
			next = mid.next;
			cur.next =next;
			cur = next;
			if (next==null) {
				break;
			}
			mid.next = cur.next;
		}
		return res;
	}
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
