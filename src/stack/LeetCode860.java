package stack;

/**
 * @author 张璐
 * @description &{description} TODO 璐哥 写点注释吧 !!!!!
 * @date 2020/12/9
 */
public class LeetCode860 {
	static class Solution {
		public boolean lemonadeChange(int[] bills) {
			int five = 0;
			int ten = 0;

			for (int bill : bills) {
				switch (bill) {
					case 5:
						five++;
						break;
					case 10:
						if (five > 0) {
							five--;
							ten++;
							break;
						} else {
							return false;
						}
					case 20:
						if (ten > 0 && five > 0) {
							ten--;
							five--;
							break;
						}
						if (ten < 1 && five > 2) {
							five -= 3;
							break;
						}
						return false;
					default:
						return false;
				}
			}
			return true;
		}

		public static void main(String[] args) {
			Solution solution = new Solution();
			solution.lemonadeChange(new int[]{5,5,5,5,20,20,5,5,20,5});
		}
	}


}
