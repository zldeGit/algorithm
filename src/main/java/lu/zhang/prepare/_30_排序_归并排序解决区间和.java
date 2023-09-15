package lu.zhang.prepare;

/**
 * @author 张璐
 * @date 2022/3/23
 */
public class _30_排序_归并排序解决区间和 {

  public static int countRangeSum(int[] nums, int lower, int upper) {
    long[] sums = new long[nums.length + 1];
    sums[0] = 0;
    for (int i = 0; i < nums.length; i++) {
      sums[i + 1] = sums[i] + nums[i];
    }
    int mergeSize = 1;
    int ans = 0;
    while (mergeSize < sums.length) {
      for (int j = 0; j < sums.length - mergeSize; j += (mergeSize << 1)) {
        ans += merge(sums, j, j + mergeSize, Math.min(j + (mergeSize << 1) - 1, sums.length - 1),
            lower, upper);
      }
      mergeSize <<= 1;
    }
    return ans;
  }

  private static int merge(long[] arr, int L, int M, int R, int lower, int upper) {
    int l = M;
    int r = M;
    int ans = 0;
    for (int i = L; i < M; i++) {
      long l1 = arr[i] + lower;
      long l2 = arr[i] + upper;
      while (l <= R && arr[l] < l1) {
        l++;
      }
      while (r <= R && arr[r] <= l2) {
        r++;
      }
      ans += (r - l);
    }
    long[] help = new long[R - L + 1];
    int leftL = L;
    int rightL = M;
    int i = 0;
    while (leftL < M && rightL <= R) {
      help[i++] = (arr[leftL] <= arr[rightL] ? arr[leftL++] : arr[rightL++]);
    }
    while (leftL < M) {
      help[i++] = arr[leftL++];
    }
    while (rightL <= R) {
      help[i++] = arr[rightL++];
    }
    for (int j = 0; j < help.length; j++) {
      arr[j + L] = help[j];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {-2, 5, -1};
    countRangeSum(arr, -2, 2);
  }

}
