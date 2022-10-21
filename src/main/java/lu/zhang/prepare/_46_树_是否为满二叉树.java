package lu.zhang.prepare;

import lu.zhang.entity.TreeNode;

/**
 * @author 张璐
 * @date 2022/3/31
 */
public class _46_树_是否为满二叉树 {
	public boolean isFullBinaryTree(TreeNode node) {
		int[] arr = process(node);
		int height = arr[0];
		int count = arr[1];
		return count == (2 << height) - 1;
	}

	private int[] process(TreeNode node) {
		if (node == null) {
			return new int[]{0, 0};
		}
		int[] left = process(node.left);
		int[] right = process(node.right);
		return new int[]{Math.max(left[0], right[0]) + 1, left[1] + right[1] + 1};
	}
}
