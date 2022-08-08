package prepare;

import java.util.ArrayList;

/**
 * @author 张璐
 * @date 2022/8/2 日常修改
 */
public class _53_并查集 {
	public static class Node<V> {
		V value;
		Node<V> parent;
		int rank ;

		public Node(V value) {
			this.value = value;
			this.parent = this;
		}

		public  Node find() {
			if (parent != this) {
				parent = parent.find();
			}
			return parent;
		}

		public void union(Node node) {
			parent = find();
			node.parent = node.find();
			if (parent != node.parent) {
				Node large = parent.rank > node.parent.rank ? parent : node.parent;
				Node small = parent.rank > node.parent.rank ? node.parent : parent;
				small.parent = large;
				if (small.rank == large.rank) {
					large.rank += 1;
				}
			}
			String s = "";
			ArrayList<Object> list = new ArrayList<>();
			for (int j=0, k = 0; j < list.size() && k < s.length(); j++, k++) {

			}
		}
	}
}
