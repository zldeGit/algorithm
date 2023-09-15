package lu.zhang.dp;

/**
 * @author 张璐
 * @description &{description} TODO 璐哥 写点注释吧 !!!!!
 * @date 2021/3/9
 */
public class ArrayMaxValue {

  public int getMaxValue(int[] arr) {
    return getMaxValue(arr, 0, arr.length - 1);
  }

  private int getMaxValue(int[] arr, int l, int r) {
    if (l == r) {
      return arr[l];
    }
    int mid = l + ((r - l) >> 1);
    return Math.max(getMaxValue(arr, l, mid), getMaxValue(arr, mid + 1, r));
  }

  public static void main(String[] args) {
    ArrayMaxValue arrayMaxValue = new ArrayMaxValue();
    int maxValue = arrayMaxValue.getMaxValue(new int[]{1, 2, 3, 54, 5, 2436, 273, 23447, 12});
    System.out.println("maxValue = " + maxValue);
  }
}
