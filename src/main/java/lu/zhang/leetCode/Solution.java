package lu.zhang.leetCode;


import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.concurrent.locks.StampedLock;

public class Solution {
	public TreeNode increasingBST(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode res = root;
		while (res.left != null) {
			res = res.left;
		}
		TreeNode pre = null;
		while (true) {
			if (root.left == null) {
				if (root.right != null) {
					pre = root;
					root = root.right;
					continue;
				} else {
					break;
				}
			}
			TreeNode left = root.left;
			TreeNode leftMinRight = root.left;
			while (leftMinRight.right!=null) {
				leftMinRight = leftMinRight.right;
			}
			leftMinRight.right = root;
			root.left = null;
			root = left;
			if (pre!=null) {
				pre.right = root;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		final boolean regularFile = Files.isRegularFile(Paths.get("608925c64df448a80c4f57fe.mp4"), new LinkOption[0]);
		System.out.println("regularFile = " + regularFile);
	}

	double x,y;
	private final StampedLock stampedLock = new StampedLock();

	void move() {
		long stamp = stampedLock.writeLock();
		try {

			x+=1;
			y+=1;
		}finally {
			stampedLock.unlockWrite(stamp);
		}
	}
	void read(){
		long l = stampedLock.tryOptimisticRead();
		double cx = x, cy = y;
		move();
		System.out.println("cx = " + cx);
		System.out.println("cy = " + cy);
		cx=x;
		cy=y;
		System.out.println("cx = " + cx);
		System.out.println("cy = " + cy);
		stampedLock.validate(l);
		cx=x;
		cy=y;
		System.out.println("cx = " + cx);
		System.out.println("cy = " + cy);
	}


}