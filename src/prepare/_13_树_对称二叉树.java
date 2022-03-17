package prepare;

import entity.TreeNode;

/**
 * @author 张璐
 * @date 2022/3/17
 *
 */
//https://leetcode-cn.com/problems/symmetric-tree/
public class _13_树_对称二叉树 {
	public boolean isSymmetric(TreeNode root) {
		if (root==null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null ^ right == null) {
			return false;
		}
		if (left==null&&right==null) {
			return true;
		}
		return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}

}
