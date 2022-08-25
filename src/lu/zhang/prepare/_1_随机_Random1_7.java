package lu.zhang.prepare;

/**
 * @author 张璐
 * @date 2022/3/10
 */
public class _1_随机_Random1_7 {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(random1_7());
		}
	}

	public static int random1_7() {
		int result=0;
		for (int i = 0; i < 7; i++) {
			int a = 0;
			do {
				 a = random1_5();
			} while (a == 3);
			result += (a > 3 ? 1 : 0);
		}
		return result;
	}

	public static int random1_5() {
		double random = Math.random();
		int i = (int) (random * 5);
		return i + 1;
	}
}
