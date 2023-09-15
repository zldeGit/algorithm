package lu.zhang.prepare;

import lu.zhang.entity.TreeNode;

/**
 * @author 张璐
 * @date 2022/3/31
 */
//给定一棵二叉树的头节点head，任何两个节点之间都存在距离，返回整棵二叉树的最大距离
/*
 *
 * 递归:求当前左右节点的最大深度和sum,以及左右节点的最大距离 maxl,maxr ,结果为Math.max(sum+1,Math.max(maxl,maxr))
 * */
public class _45_树_二叉树的最大距离 {

  public static int[] maxLengths(TreeNode node) {
    if (node == null) {
      return new int[]{0, 0};
    }
    int[] maxL = maxLengths(node.left);
    int[] maxR = maxLengths(node.right);
    int sum = maxL[0] + maxR[0] + 1;
    return new int[]{1 + Math.max(maxL[0], maxR[0]), Math.max(sum, Math.max(maxL[1], maxR[1]))};
  }

  public static int maxLength(TreeNode node) {
    int[] arr = maxLengths(node);
    return Math.max(arr[0], arr[1]);
  }

}
