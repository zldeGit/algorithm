package prepare;


import entity.Node;
import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 张璐
 * @date 2022/3/31
 */
public class _41_树_N叉树编码为二叉树 {
	// Encodes an n-ary tree to a binary tree.
	public static TreeNode encode(Node root) {
		if (root == null) {
			return null;
		}
		LinkedList<Node> qn = new LinkedList<>();

		LinkedList<TreeNode> qt  = new LinkedList<>();
		TreeNode rt = new TreeNode(root.val);
		qn.offer(root);
		qt.offer(rt);
		while (!qn.isEmpty()) {
			Node qnp = qn.poll();
			TreeNode qtp = qt.poll();
			List<Node> c = qnp.children;
			if (c!=null) {
//				Node node = c.get(0);
//				if (node != null) {
//					qn.offer(node);
//					TreeNode childrenT = new TreeNode(node.val);
//					qtp.left = childrenT;
//					qt.offer(childrenT);
//					for (int i = 1; i < c.size(); i++) {
//						Node qnc = c.get(i);
//						qn.offer(qnc);
//						childrenT.right = new TreeNode(qnc.val);
//						childrenT = childrenT.right;
//						qt.offer(childrenT);
//					}
					TreeNode childrenT = null;
					for (Node node1 : c) {
						if (childrenT == null) {
							childrenT = new TreeNode(node1.val);
							qtp.left = childrenT;
						} else {
							childrenT.right = new TreeNode(node1.val);
							childrenT = childrenT.right;
							qt.offer(childrenT);
						}
						qt.offer(childrenT);
						qn.offer(node1);
					}
//				}
			}
		}
		return rt;
	}

	// Decodes your binary tree to an n-ary tree.
	public static Node decode(TreeNode root) {
		if (root == null) {
			return null;
		}
		LinkedList<Node> qn = new LinkedList<>();
		LinkedList<TreeNode> qt  = new LinkedList<>();
		Node rn = new Node(root.val);
		qn.offer(rn);
		qt.offer(root);
		while (!qt.isEmpty()) {
			TreeNode qtp = qt.poll();
			Node qnp = qn.poll();
			TreeNode left = qtp.left;
			if (left != null) {
				Node node = new Node(left.val);
				qn.offer(node);
				qt.offer(left);
				ArrayList<Node> children = new ArrayList<>();
				children.add(node);
				TreeNode right = left.right;
				while (right != null) {
					Node temp = new Node(right.val);
					qn.offer(temp);
					qt.offer(right);
					children.add(new Node(right.val));
					right = right.right;
				}
				qnp.children = children;
			}
		}
		return rn;
	}







	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(node3);
		nodes.add(node2);
		nodes.add(node4);
		node1.children = nodes;
		ArrayList<Node> nodes2 = new ArrayList<Node>();
		nodes2.add(node5);
		nodes2.add(node6);
		node3.children = nodes2;
		TreeNode encode = encode(node1);
		Node decode = decode(encode);
	}
}
