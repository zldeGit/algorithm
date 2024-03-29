import java.util.HashMap;
import java.util.Map;

public class HashMapMultiThread {

  static Map<String, String> map = new HashMap<>();

  public static class AddThread implements Runnable {

    int start;

    public AddThread(int start) {
      this.start = start;
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName());
      //添加元素
      for (int i = start; i < 10000000; i += 2) {
        map.put(Integer.toString(i), Integer.toBinaryString(i));
      }
    }
  }

  static class Test1 {

    public int val;

    public Test1(int val) {
      this.val = val;
    }

    @Override
    public int hashCode() {
      return 1 << 16;
    }


  }
}