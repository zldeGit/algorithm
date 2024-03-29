package lu.zhang.prepare;

import java.util.Arrays;
import lu.zhang.utils.Utils;

/**
 * @author 张璐
 * @date 2022/3/22
 */
public class _29_排序_归并排序解决i位置后乘2小于i的个数的问题 {

  //先计算再merge TODO
  public static int merge(int[] arr, int L, int M, int R) {
    int ans = 0;
    return ans;
  }

  public static int getSmallSumByMergeSort(int[] arr) {
//		arr = Arrays.copyOf(arr, arr.length);
    int ans = 0;
    int mergeSize = 1;
    while (mergeSize < arr.length) {
      for (int i = 0; i < arr.length - mergeSize; i += (mergeSize << 1)) {
        ans += merge(arr, i, i + mergeSize, Math.min(arr.length - 1, i + 2 * mergeSize - 1));
      }
      mergeSize <<= 1;
    }
    return ans;
  }

  public static int check(int[] arr) {
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          ans += arr[j];
        }
      }
    }
    return ans;
  }


  public static void main(String[] args) {
//		System.out.println(4 + 3 + 4 + 3 + 5 + 4 + 3 + 5 + 7 + 2 + 4 + 3 + 5 + 2 + 3 + 2);
    for (int i = 0; i < 10000; i++) {
      int[] ints = Utils.generateRandomIntArr(1000, 1000);
//			int[] ints = {4, 3, 5, 7, 2, 8, 6, 4};
      try {
        int check = check(ints);
        int smallSumByMergeSort = getSmallSumByMergeSort(ints);
        if (smallSumByMergeSort != check) {
          System.out.println("error");
          System.out.println(Arrays.toString(ints));
          break;
        }
      } catch (Exception e) {
        System.out.println(Arrays.toString(ints));
        break;
      }
    }
  }

	/*
	*
	*
	*
 ["http://source.wengegroup.com/mam2/video_cut_623da0d1e4b01894022cd3b3.mp4","mam2"]
	*
	* */
}
