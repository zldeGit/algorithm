package prepare;

import entity.TreeNode;

/**
 * @author 张璐
 * @date 2022/3/17
 *
 */
//https://leetcode-cn.com/problems/same-tree/
public class _12_树_判断两颗二叉树是否相同 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		while (p == null ^ q == null) {
			return false;
		}
		if (p == null && q == null) {
			return true;
		}
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
