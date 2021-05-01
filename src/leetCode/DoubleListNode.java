package leetCode;

/**
 * @author 张璐
 * @description &{description} TODO 璐哥 写点注释吧 !!!!!
 * @date 2021/2/23
 */
public class DoubleListNode {
	public int val;
	public DoubleListNode next;
	public DoubleListNode last;

	DoubleListNode() {
	}

	public DoubleListNode(int val, DoubleListNode next, DoubleListNode last) {
		this.val = val;
		this.next = next;
		this.last = last;
	}

	DoubleListNode(int val) {
		this.val = val;
	}


}
