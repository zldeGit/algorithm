package lu.zhang.code.体系班.src.class14;

import java.util.PriorityQueue;
import lu.zhang.prepare._50_贪心_金条分割的最小代价;

public class Code02_LessMoneySplitGold {

  // 纯暴力！
  public static int lessMoney1(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    return process(arr, 0);
  }

  // 等待合并的数都在arr里，pre之前的合并行为产生了多少总代价
  // arr中只剩一个数字的时候，停止合并，返回最小的总代价
  public static int process(int[] arr, int pre) {
    if (arr.length == 1) {
      return pre;
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        ans = Math.min(ans, process(copyAndMergeTwo(arr, i, j), pre + arr[i] + arr[j]));
      }
    }
    return ans;
  }

  public static int[] copyAndMergeTwo(int[] arr, int i, int j) {
    int[] ans = new int[arr.length - 1];
    int ansi = 0;
    for (int arri = 0; arri < arr.length; arri++) {
      if (arri != i && arri != j) {
        ans[ansi++] = arr[arri];
      }
    }
    ans[ansi] = arr[i] + arr[j];
    return ans;
  }

  public static int lessMoney2(int[] arr) {
    PriorityQueue<Integer> pQ = new PriorityQueue<>();
    for (int i = 0; i < arr.length; i++) {
      pQ.add(arr[i]);
    }
    int sum = 0;
    int cur = 0;
    while (pQ.size() > 1) {
      cur = pQ.poll() + pQ.poll();
      sum += cur;
      pQ.add(cur);
    }
    return sum;
  }

  // for test
  public static int[] generateRandomArray(int maxSize, int maxValue) {
    int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * (maxValue + 1));
    }
    return arr;
  }

  public static void main(String[] args) {
    int testTime = 100000;
    int maxSize = 6;
    int maxValue = 1000;
    for (int i = 0; i < testTime; i++) {
      int[] arr = generateRandomArray(maxSize, maxValue);
      int i1 = lessMoney1(arr);
      int i2 = _50_贪心_金条分割的最小代价.getMinPrice(arr);
      if (i1 != i2) {
        System.out.println("Oops!");
      }
    }
    System.out.println("finish!");
  }

}
