package prepare;

import entity.TreeNode;
import utils.Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 张璐
 * @date 2022/3/16
 */
public class _11_树_二叉树遍历 {
	//先序
	public static void DLR(TreeNode node) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offer(node);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pollLast();
			if (treeNode != null) {
				System.out.print(treeNode.val +" -> ");
				stack.offer(treeNode.right);
				stack.offer(treeNode.left);
			}
		}
		System.out.println();
	}
	//中序
	public static void LDR(TreeNode node) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			System.out.print(node.val+" -> ");
			node = node.right;
		}
		System.out.println();

	}

	//后序
	public static void LRD(TreeNode node) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		LinkedList<TreeNode> printStack = new LinkedList<TreeNode>();
		stack.offer(node);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pollLast();
			if (treeNode != null) {
				printStack.offer(treeNode);
				stack.offer(treeNode.left);
				stack.offer(treeNode.right);
			}
		}
		while (!printStack.isEmpty()) {
			TreeNode printNode = printStack.pollLast();
			if (printNode != null) {
				System.out.print(printNode.val +" -> ");
			}
		}
		System.out.println();
	}

	public static void levelOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			TreeNode poll = queue.poll();
			System.out.print(poll.val+ " -> ");
			if (poll.left != null) {
				queue.offer(poll.left);
			}
			if (poll.right != null) {
				queue.offer(poll.right);
			}
		}
		System.out.println();

	}

//	    1
//	   / \
//	  2   3
//	 / \ / \
//	4  5 6  7
	public static void main(String[] args) {
		Integer[] integers = {1, 2, 3,4,5 , 6, 7};
		TreeNode treeNode = Utils.createTreeNode(integers);
		DLR(treeNode);
		LDR(treeNode);
		LRD(treeNode);
		levelOrder(treeNode);
	}
}
