package lu.zhang.prepare;

/**
 * @author 张璐
 * @date 2022/3/31
 */
public class _43_树_折纸问题 {
	public static void process(int n) {
		process(n, "down");
	}

	public static void process(int n, String print) {
		if (n == 0) {
			return;
		}
		process(n - 1, "down");
		System.out.println(print);
		process(n - 1, "up");
	}

	public static void main(String[] args) {
		process(10);
	}
}
