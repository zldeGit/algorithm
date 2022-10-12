package lu.zhang.leetCode;

/**
 * @author 张璐
 * @date 2022/10/12
 */
public class leetcode1790 {
	public boolean areAlmostEqual(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		int count = 0;
		char c1 = 0;
		char c2 = 0;
		boolean res = true;
		while (count < s1.length()) {
			if ( s1.charAt(count) !=s2.charAt(count)){
				c1 = s1.charAt(count);
				c2 = s2.charAt(count);
				break;
			}
			count++;
		}
		if (count<s1.length()) {
			count++;
			res = false;
			while (count < s1.length()) {
				if (s1.charAt(count) != s2.charAt(count)) {
					if (res) {
						return false;
					}
					if (c1 == s2.charAt(count) && c2 == s1.charAt(count)) {
						res = true;
					} else {
						return false;
					}
				}
				count++;
			}
		}
		return res;
	}

}
