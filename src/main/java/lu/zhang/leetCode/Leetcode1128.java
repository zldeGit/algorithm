package lu.zhang.leetCode;

import java.util.HashMap;

public class Leetcode1128 {

  public int numEquivDominoPairs(int[][] dominoes) {
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < dominoes.length; i++) {
      if (map.containsKey(dominoes[i][0] + "" + dominoes[i][1]) || map.containsKey(
          dominoes[i][1] + "" + dominoes[i][0])) {
        continue;
      }
      for (int j = i + 1; j < dominoes.length; j++) {
        boolean equals = equals(dominoes[i], dominoes[j]);
        if (equals) {
          Integer integer = map.get(dominoes[i]);
          String key = dominoes[i][0] + "" + dominoes[i][1];
          map.put(key, integer == null ? 2 : integer + 1);
        }
      }
    }
    int result = 0;
    for (String ints : map.keySet()) {
      int n = map.get(ints);
      result += (n * (n - 1) / 2);
    }
    return result;
  }

  public boolean equals(int[] a, int[] b) {
    if ((a[0] == b[0] && a[1] == b[1]) || a[0] == b[1] && a[1] == b[0]) {
      return true;
    }
    return false;
  }

  public int[] reverse(int[] a) {
    return new int[]{a[1], a[0]};
  }

  public static void main(String[] args) {
    int[][] ints = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
    Leetcode1128 leetCode1128 = new Leetcode1128();
    int i = leetCode1128.numEquivDominoPairs(ints);
  }
}
