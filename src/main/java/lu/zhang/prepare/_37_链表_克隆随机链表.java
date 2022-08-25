package lu.zhang.prepare;

import lu.zhang.entity.RandomListNode;

/**
 * @author 张璐
 * @date 2022/3/29
 */
public class _37_链表_克隆随机链表 {
	public static RandomListNode clone(RandomListNode node) {
		RandomListNode cur = node;
		while (cur != null) {
			RandomListNode midNode = new RandomListNode(cur.val);
			RandomListNode next = cur.next;
			cur.next=midNode;
			midNode.next=next;
			cur=next;
		}
		cur= node;
		RandomListNode ans = node.next;
		while (cur != null) {
			RandomListNode mid= cur.next;
			RandomListNode next=mid.next;
			RandomListNode rand = cur.rand;
			mid.rand=rand.next;
			cur=next;
		}
		cur=node;
		while (cur != null) {
			RandomListNode mid= cur.next;
			RandomListNode next=mid.next;
			mid.next=next.next;
			cur.next=next;
			cur=next;
		}
		return ans;
	}
}
