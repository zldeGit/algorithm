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

	public static int[] generateRandomIntArr(int maxsize, int maxValue) {
		int[] arr = new int[(int) (Math.random() * (maxsize + 1))];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
		}
		return arr;
	}

	public static void swap(int a, int b, int[] arr) {
		if (a == b) {
			return;
		}
		arr[a] ^= arr[b];
		arr[b] ^= arr[a];
		arr[a] ^= arr[b];
	}

	public static void swap(int a, int b, Object[] arr) {
		if (a == b) {
			return;
		}
		Object temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
