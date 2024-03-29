package lu.zhang.prepare;

/**
 * @author 张璐
 * @date 2022/7/29 给定一个字符串str，只由'X'和'.'两种字符构成 'X'表示墙，不能放灯，也不需要点亮；'.'表示居民点，可以放灯，需要点亮
 * 如果灯放在i位置，可以让i-1，i和i+1三个位置被点亮 返回如果点亮str中所有需要点亮的位置，至少需要几盏灯
 */
public class _52_贪心_点亮所有的灯 {

  public static int getMinD(String str) {
    int res = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == 'X') {
        continue;
      }
      res++;
      if (i + 1 < str.length() && str.charAt(i + 1) == '.') {
        i += 2;
      }
    }
    return res;


  }
}
