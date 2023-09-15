package lu.zhang.prepare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 张璐
 * @date 2022/7/28
 * <p>
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲，给你每一个项目开始的时间和结束的时间 你来安排宣讲的日程，要求会议室进行的宣讲的场次最多，返回最多的宣讲场次
 * <p>
 * 1 1 2 2 3 4 7 8 5 4 4 5 8
 */
public class _48_贪心_最大会议宣讲次数 {

  public static int getMaxMeets(int[][] arr) {
    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });
    int res = 0;
    int time = 0;
    for (int[] ints : arr) {
      if (time <= ints[0]) {
        time = ints[1];
        res++;
      }
    }
    return res;
  }
}
