package prepare;

import entity.TreeNode;

import java.util.HashMap;

/**
 * @author 张璐
 * @date 2022/3/17
 */
//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class _15_树_用先序遍历和中序遍历构建二叉树 {
	public static TreeNode getByDLR(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> preMap = new HashMap<>();
		HashMap<Integer, Integer> inMap = new HashMap<>();

		for (int i = 0; i < preorder.length; i++) {
			preMap.put(preorder[i], i);
			inMap.put(inorder[i], i);
		}
		return getByDLR(preorder, inMap, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	public static TreeNode getByDLR(int[] preorder,
									HashMap<Integer, Integer> inMap,
									int preL, int preR,
									int inL, int inR) {
		if (preL == preR) {
			return new TreeNode(preorder[preL]);
		}
		int rootVal = preorder[preL];
		int inOrderRootIndex = inMap.get(rootVal);
		int leftLength = inOrderRootIndex - inL - 1;
		int rightLength = inR - inOrderRootIndex - 1;
		TreeNode root = new TreeNode(rootVal);
		if (leftLength>=0) {
			root.left = getByDLR(preorder, inMap, preL + 1, preL + 1 + leftLength, inL, inL + leftLength);
		}
		if (rightLength>0) {
			root.right = getByDLR(preorder, inMap, preR - rightLength, preR, inR - rightLength, inR);
		}
		return root;

	}

	public static void main(String[] args) {
		int[] p = {1, 2};
		int[] q = {2, 1};
		TreeNode byDLR = getByDLR(p, q);
	}
}
