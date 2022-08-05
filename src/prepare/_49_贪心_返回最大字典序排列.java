package prepare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 张璐
 * @date 2022/7/26
 */
//给定一个字符串数组,将它们排列组合成字典序最大的字符串
public class _49_贪心_返回最大字典序排列 {
	private  class MyComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return (o1 + o2).compareTo(o2 + o1);
		}
	}

	public String getMaxDicSort(String[] strings) {
		Arrays.sort(strings, new MyComparator());
		StringBuilder res = new StringBuilder();
		for (int i = strings.length - 1; i >= 0; i--) {
			res.append(strings[i]);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		_49_贪心_返回最大字典序排列 obj = new _49_贪心_返回最大字典序排列();

//		obj.getMaxDicSort()
	}
}
