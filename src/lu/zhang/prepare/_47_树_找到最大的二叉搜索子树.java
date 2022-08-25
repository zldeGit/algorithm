package lu.zhang.prepare;

import lu.zhang.entity.TreeNode;

/**
 * @author 张璐
 * @date 2022/3/31
 */
public class _47_树_找到最大的二叉搜索子树 {
	public static int findMaxSearchBinaryTree(TreeNode node) {
		int[] arr = process(node);
		return arr[0];
	}

	private static int[] process(TreeNode node) {
		if (node == null) {
			return new int[]{0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE};
		}
		int[] left = process(node.left);
		int[] right = process(node.right);
		int TreeCount = 1 + left[1] + right[1];
		int max = Math.max(node.val, Math.max(left[2], right[2]));
		int min = Math.min(node.val, Math.min(left[3], right[3]));
		int maxSearchTreeCount = Math.max(Math.max(left[0], right[0]),
				left[0] == left[1]
						&&
						right[0] == right[1] //左右两侧如果最大二叉搜索树的数量等于所有节点的数量 则左右两侧都为二叉搜索树
						&&
						left[2] < node.val
						&& node.val < right[3] ? TreeCount : Integer.MIN_VALUE);

		return new int[]{maxSearchTreeCount, TreeCount, max, min};
	}


}
