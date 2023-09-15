package lu.zhang.prepare;

import java.util.Arrays;

/**
 * @author 张璐
 * @date 2022/3/10
 */
//插入排序
public class _2_排序_插入排序 {

  public static void main(String[] args) {
    int[] a = {5, 1, 53, 176, 126, 710, 12367, 172, 10};
    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
        swap(j, j - 1, a);
      }
    }
    System.out.println(Arrays.toString(a));
  }

  public static void swap(int a, int b, int[] arr) {
    if (a == b) {
      return;
    }
    arr[a] ^= arr[b];
    arr[b] ^= arr[a];
    arr[a] ^= arr[b];
  }
}
