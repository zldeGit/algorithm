package lu.zhang.prepare;

import java.util.Arrays;
import java.util.LinkedList;
import lu.zhang.utils.Utils;

/**
 * @author 张璐
 * @date 2022/3/17
 */
public class _21_排序_快排 {

  //荷兰国旗
  public static void splitNum(int[] arr) {
    int p = -1;
    int target = arr[arr.length - 1];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] <= target) {
        Utils.swap(++p, i, arr);
      }
    }
  }

  public static void splitNum2(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    int L = -1;
    int R = arr.length - 1;
    int i = 0;
    int target = arr[arr.length - 1];
    while (i < R) {
      if (arr[i] < target) {
        Utils.swap(++L, i++, arr);
      } else if (arr[i] > target) {
        Utils.swap(--R, i, arr);
      } else {
        i++;
      }
    }
    Utils.swap(R, arr.length - 1, arr);
  }

  public static int[] partition(int[] arr, int less, int more) {
    int i = less;
    int L = less - 1;
    int R = more;
    int target = arr[more];
    while (i < R) {
      if (arr[i] < target) {
        Utils.swap(++L, i++, arr);
      } else if (arr[i] > target) {
        Utils.swap(--R, i, arr);
      } else {
        i++;
      }
    }
    Utils.swap(R, more, arr);
    return new int[]{L + 1, R};
  }

  public static void quickSort(int[] arr) {
    process(arr, 0, arr.length - 1);
  }

  private static void process(int[] arr, int L, int R) {
    if (L >= R) {
      return;
    }
    int[] equals = partition(arr, L, R);
    process(arr, L, equals[0] - 1);
    process(arr, equals[1] + 1, R);
  }

  public static void quickSort2(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    LinkedList<Integer> stackL = new LinkedList<>();
    LinkedList<Integer> stackR = new LinkedList<>();
    stackL.push(0);
    stackR.push(arr.length - 1);
    while (!stackL.isEmpty()) {
      Integer L = stackL.pop();
      Integer R = stackR.pop();
      if (L < R) {
        int[] equals = partition(arr, L, R);
        stackL.push(L);
        stackR.push(equals[0] - 1);
        stackL.push(equals[1] + 1);
        stackR.push(R);
      }
    }
  }


  public static void main(String[] args) {
    circle:
    for (int i = 0; i < 1000; i++) {
      int[] arr = Utils.generateRandomIntArr(1000, 1000);
      quickSort2(arr);
      for (int j = 1; j < arr.length; j++) {
        if (arr[j] < arr[j - 1]) {
          System.out.println("error");
          System.out.println(Arrays.toString(arr));
          break circle;
        }
      }
    }
  }
}
