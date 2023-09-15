package lu.zhang.entity;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode leftRotate(TreeNode node) {
    TreeNode r = node.right;
    if (r == null) {
      throw new NullPointerException("left tree must be not null");
    }
    node.right = r.left;
    r.left = node;
    return r;
  }
}