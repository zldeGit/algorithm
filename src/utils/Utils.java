package utils;

import entity.ListNode;
import entity.TreeNode;

/**
 * @author 张璐
 * @date 2022/3/16
 */
public  class Utils {
	public static TreeNode createTreeNode(Integer[] array) {
		TreeNode root = createTreeNode(array, 1);
		return root;
	}

	private static TreeNode createTreeNode(Integer[] array, int index) {
		if (index > array.length) {
			return null;
		}
		Integer value = array[index - 1];
		if (value == null) {
			return null;
		}
		TreeNode node = new TreeNode(value);
		node.left = createTreeNode(array, index * 2);
		node.right = createTreeNode(array, index * 2 + 1);
		return node;
	}
	public static ListNode arrayToListNode(int[] arr) {
		if (arr==null||arr.length==0) {
			return null;
		}
		ListNode head = new ListNode();
		ListNode cur =head;
		for (int i = 0; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			cur.next=node;
			cur=node;
		}
		return head.next;
	}
}
