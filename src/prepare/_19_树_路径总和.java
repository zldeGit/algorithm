package prepare;

import entity.TreeNode;

/**
 * @author 张璐
 * @date 2022/3/17
 */
//https://leetcode-cn.com/problems/path-sum/
public class _19_树_路径总和 {
	public boolean hasPathSum(TreeNode root, int targetSum) {
		return hasSum(root,targetSum,0);
	}
	public boolean hasSum(TreeNode root, int targetSum, int curSum){
		if(root==null) return false;
		curSum+=root.val;
		if(root.left==null&&root.right==null && curSum== targetSum) return true;
		return hasSum(root.left,targetSum,curSum)||hasSum(root.right,targetSum,curSum);
	}

}