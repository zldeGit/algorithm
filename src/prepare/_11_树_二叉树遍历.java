package prepare;

import entity.TreeNode;
import utils.Utils;

import java.util.LinkedList;

/**
 * @author 张璐
 * @date 2022/3/16
 */
public class _11_树_二叉树遍历 {
	public static void DLR(TreeNode node) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offer(node);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pollLast();
			if (treeNode != null) {
				System.out.println(treeNode.val);
				stack.offer(treeNode.right);
				stack.offer(treeNode.left);
			}
		}
	}

	public static void LDR(TreeNode node) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offer(node);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.peekLast();
			if (treeNode.left == null) {
				System.out.println(treeNode.val);
				stack.pollLast();
			} else {
				stack.offer(treeNode.left);
				continue;
			}
			if (treeNode.right != null) {
				stack.offer(treeNode.right);
			}
		}
	}

	public static void main(String[] args) {
		Integer[] integers = {1, null, 2, null, null, 3, 4};
		TreeNode treeNode = Utils.createTreeNode(integers);
		LDR(treeNode);
	}
}
