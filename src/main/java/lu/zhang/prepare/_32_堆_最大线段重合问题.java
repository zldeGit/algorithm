package lu.zhang.prepare;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 张璐
 * @date 2022/3/28
 */
public class _32_堆_最大线段重合问题 {

  public static int getMaxMulti(int[][] arr) {
    if (arr.length == 0) {
      return 0;
    }
    Arrays.sort(arr, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      while (!queue.isEmpty() && queue.peek() <= arr[i][0]) {
        queue.poll();
      }
      queue.offer(arr[i][1]);
      ans = Math.max(ans, queue.size());
    }
    return ans;
  }


}
