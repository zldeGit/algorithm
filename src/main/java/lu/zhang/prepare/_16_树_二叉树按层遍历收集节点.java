package lu.zhang.prepare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lu.zhang.entity.TreeNode;

/**
 * @author 张璐
 * @date 2022/3/17
 */
//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
public class _16_树_二叉树按层遍历收集节点 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      LinkedList<TreeNode> tmp = new LinkedList<>();
      ArrayList<Integer> tmpList = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        tmpList.add(node.val);
        if (node.left != null) {
          tmp.offer(node.left);
        }
        if (node.right != null) {
          tmp.offer(node.right);
        }
      }
      queue = tmp;
      ans.add(tmpList);
    }
    return ans;
  }
}
