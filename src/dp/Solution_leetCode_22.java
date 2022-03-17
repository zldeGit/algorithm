package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_leetCode_22 {
    public List<String> generateParenthesis(int n) {
		ArrayList<String> strings = new ArrayList<>();
		process(strings, 1, 0, n, "(");
		return strings;
    }

	public void process(List<String> res, int left, int right, int n,String cur) {
		if (left == right && left == n) {
			res.add(cur);
		}
		if (right>left) {
			return;
		}
		if (left<n) {
			process(res, left + 1, right, n, cur + "(");
		}
		process(res, left, right + 1, n, cur + ")");
	}

	public static void main(String[] args) {
		Solution_leetCode_22 solution_leetCode_22 = new Solution_leetCode_22();
		List<String> strings = solution_leetCode_22.generateParenthesis(8);
		for (String string : strings) {
			System.out.println(string);
		}
	}
}