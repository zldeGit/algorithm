package prepare;

import entity.TreeNode;

/**
 * @author 张璐
 * @date 2022/3/17
 */
public class _14_树_树的最大深度 {
	public static int maxDepth(TreeNode node){
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}
}
