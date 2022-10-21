package lu.zhang.prepare;

import java.util.HashMap;
import java.util.List;

/**
 * @author 张璐
 * @date 2022/10/10
 */
public class _55_图 {
	/**
	 *
	 *   邻接表法
	 *	 邻接矩阵法
	 */
}

 class Node{
	public int value;
	public int in;
	public int out;
	public List<Node> nexts;
	public List<Edge> edges;

	 public Node(int value, int in, int out, List<Node> nexts, List<Edge> edges) {
		 this.value = value;
		 this.in = in;
		 this.out = out;
		 this.nexts = nexts;
		 this.edges = edges;
	 }
 }
class Edge{
	public Node from;
	public Node to;
	public int value;

	public Edge(Node from, Node to, int value) {
		this.from = from;
		this.to = to;
		this.value = value;
	}
}
class Graph{
	public HashMap<Integer,Node> nodes;
	public HashMap<Edge,Object> edges;

	public Graph(HashMap<Integer, Node> nodes, HashMap<Edge, Object> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}
}

