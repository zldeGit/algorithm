package lu.zhang.prepare;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author 张璐
 * @date 2022/11/18
 */
public class _56_数组实现单链表 {

  int[] val = new int[101];
  int[] next = new int[101];
  int idx = 1;

  {
    Arrays.fill(next, -1);
  }

  public void insert(int k, int v) {
    val[idx] = v;
    next[idx] = next[k];
    next[k] = idx;
    ++idx;
  }

  public void insert(int v) {
    val[idx] = v;
    next[idx] = -1;
    next[idx - 1] = idx;
    ++idx;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i != -1; i = next[i]) {
      s.append(val[i] + " ");
    }
    return s.toString();
  }

  public static void main(String[] args) {
    _56_数组实现单链表 ml = new _56_数组实现单链表();
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 100; i++) {
      int random = (int) (Math.random() * 100);
      ml.insert(random);
      list.add(random);
    }
    System.out.println(ml);
    System.out.println(Arrays.toString(list.toArray()));
  }
}
