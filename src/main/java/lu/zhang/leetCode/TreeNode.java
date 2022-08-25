package lu.zhang.leetCode;

import java.util.LinkedList;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	TreeNode(Integer[] arr, int index) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(this);
		this.val = arr[index];
		while (index < arr.length) {
			TreeNode poll = queue.poll();
			if (poll == null) {
				continue;
			}
			poll.left = ++index < arr.length && arr[index] != null ? new TreeNode(arr[index]) : null;
			queue.offer(poll.left);
			poll.right = ++index < arr.length && arr[index] != null ? new TreeNode(arr[index]) : null;
			queue.offer(poll.right);
		}
	}



}