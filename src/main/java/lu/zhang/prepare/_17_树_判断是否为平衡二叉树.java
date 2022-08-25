package lu.zhang.prepare;

import lu.zhang.entity.TreeNode;

/**
 * @author 张璐
 * @date 2022/3/17
 */
//https://leetcode-cn.com/problems/balanced-binary-tree/submissions/
public class _17_树_判断是否为平衡二叉树 {
	public boolean isBalanced(TreeNode root) {
		return height(root)>=0;
	}

	public static int height(TreeNode root){
		if(root == null) return 0;
		int LH= height(root.left);
		if (LH<0) return -1;
		int LR= height(root.right);
		if (LR<0) return -1;
		if(Math.abs(LH-LR)>1) return -1;
		return 1+ Math.max(LH,LR);
	}
}
