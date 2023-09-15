package lu.zhang.prepare;

/**
 * @author 张璐 位图
 * @date 2022/3/15
 */
public class _10_位运算_位图BitMap {

  private long[] bits;

  public _10_位运算_位图BitMap(int max) {
    //(max+64>/64
    bits = new long[(max + 64) >> 6];
  }

  private void add(int num) {
    //num & 63 = num % 64
    long l = 1L << (num & 63);
    bits[num >> 6] |= l;
  }

  public boolean contains(int num) {
    long l = bits[num >> 6] & (1L << (num & 63));
    return l != 0;
  }

  public void remove(int num) {
    bits[num >> 6] &= ~(1L << (num & 63));
  }

  public static void main(String[] args) {
    _10_位运算_位图BitMap bitMap = new _10_位运算_位图BitMap(13010);
    bitMap.add(5);
    bitMap.add(6);
    bitMap.add(7);
    bitMap.add(1);
    bitMap.add(9);
    bitMap.add(13010);

    System.out.println(bitMap.contains(1));
    System.out.println(bitMap.contains(1000));
    System.out.println(bitMap.contains(13010));
    bitMap.remove(13010);
    System.out.println(bitMap.contains(13010));

  }
}
