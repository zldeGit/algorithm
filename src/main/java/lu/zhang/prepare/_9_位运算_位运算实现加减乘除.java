package lu.zhang.prepare;

/**
 * @author 张璐
 * @date 2022/3/16
 */
public class _9_位运算_位运算实现加减乘除 {

  //加法
  public static int add(int a, int b) {
    do {
      int temp = a ^ b;
      b = (a & b) * 2;
      a = temp;
    } while ((a & b) != 0);
    return a ^ b;
  }

  //减法
  public static int sub(int a, int b) {
    return add(a, negNum(b));
  }

  private static int negNum(int b) {
    return add(~b, 1);
  }

  //乘法
  public static int multiply(int a, int b) {
    int ans = 0;
    while (b != 0) {
      if ((b & 1) == 1) {
        ans = add(ans, a);
      }
      a <<= 1;
      b >>= 1;
    }
    return ans;
  }

  public static int divide(int dividend, int divisor) {
    int x = dividend < 0 ? negNum(dividend) : dividend;
    int y = divisor < 0 ? negNum(divisor) : divisor;
    int res = 0;
    for (int i = 30; i >= 0; i = sub(i, 1)) {
      if (x >> i >= y) {
        res |= 1 << i;
        x = sub(x, y << i);
      }
    }
    return dividend < 0 ^ divisor < 0 ? negNum(res) : res;
  }

  public static int divide2(int dividend, int divisor) {
    int x = dividend < 0 ? -dividend : dividend;
    int y = divisor < 0 ? -divisor : divisor;
    int res = 0;
    for (int i = 30; i >= 0; i = sub(i, 1)) {
      if (x >> i >= y) {
        res |= 1 << i;
        x -= y << i;
      }
    }
    return dividend < 0 ^ divisor < 0 ? -res : res;
  }

  //除法
  public static int div(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException();
    }
    //Integer.MIN_VALUE 取反仍然是原值
    if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
      return 1;
    }
    if (b == Integer.MIN_VALUE) {
      return 0;
    }
    if (a == Integer.MIN_VALUE) {
      int ans = divide(add(a, 1), b);
      return add(ans, divide(sub(a, multiply(ans, b)), b));
    }
    return divide(a, b);
  }


  public static void main(String[] args) {
    int a = 100;
    int b = 2;
    System.out.println(divide(a, b));
  }
}
