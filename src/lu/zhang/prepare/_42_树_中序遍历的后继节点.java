package lu.zhang.prepare;

/**
 * @author 张璐
 * @date 2022/3/31
 */
public class _42_树_中序遍历的后继节点 {

	class Node{
		int value;
		Node left;
		Node right;
		Node parent;
	}

	public static Node findNext(Node node) {
		Node right= node.right;
		if (right != null) {
			while (right.left != null) {
				right = right.left;
			}
			return right;
		} else {
			Node cur = node;
			Node parent = cur.parent;
			while (parent != null) {
				if (parent.left == cur) {
					return parent;
				} else {
					cur = parent;
					parent = cur.parent;
				}
			}
		}
		return null;
	}
}

