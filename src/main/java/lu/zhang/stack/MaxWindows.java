package lu.zhang.stack;

import java.util.LinkedList;

/**
 * 有一个整型数组arr 和一个大小为w 的窗口从数组的最左边滑到最右边，窗口每次向右边 滑一个位置。 例如，数组为[4,3,5,4,3,3,6,7]，窗口大小为3 时： [4 3 5] 4 3 3
 * 6 7 窗口中最大值为5 4 [3 5 4] 3 3 6 7 窗口中最大值为5 4 3 [5 4 3] 3 6 7 窗口中最大值为5 4 3 5 [4 3 3] 6 7 窗口中最大值为4 4 3
 * 5 4 [3 3 6] 7 窗口中最大值为6 4 3 5 4 3 [3 6 7] 窗口中最大值为7 如果数组长度为n，窗口大小为w，则一共产生n-w+1 个窗口的最大值。 请实现一个函数。 
 * 输入：整型数组arr，窗口大小为w。  输出：一个长度为n-w+1 的数组res，res[i]表示每一种窗口状态下的最大值。 以本题为例，结果应该返回{5,5,5,4,6,7}。
 * <p>
 * . 思路: 维护一个队列,对头为当前窗口最大值:(循环时判断队头是否还在窗口内,不在则剔除) * 从左往右循环数组,达到窗口大小时则依次添加队头到结果集中.
 *
 * @author 张璐
 * @description &{description}
 * @date 2020/12/9
 */
public class MaxWindows {

  public int[] getMaxWindows(int[] arr, int w) {
    LinkedList<Integer> integers = new LinkedList<>();
    int[] result = new int[arr.length - w + 1];
    for (int i = 0; i < arr.length; i++) {
      while (integers.size() != 0 && integers.peekFirst() < i - w + 1) {
        integers.pollFirst();
      }
      while (integers.size() != 0 && arr[integers.peekLast()] < arr[i]) {
        integers.pollLast();
      }
      integers.add(i);
      if (i > w - 2) {
        result[i - w + 1] = arr[integers.peekFirst()];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int i = 100;
    int i1 = ~i + 1;
    System.out.println(i1);
  }
}


