package prepare;

/**
 * @author 张璐
 * @date 2022/3/21
 */
public class _23_数组_用数组实现有限队列 {
	static class RingArray{

		private int[] arr;
		private int size;
		private int push;
		private int pop;

		public RingArray(int size) {
			arr = new int[size];
		}

		public void add(int i) {
			if (size < arr.length) {
				arr[push] = i;
				size++;
				push = nextIndex(push);
			} else {
				throw new RuntimeException("array is full!");
			}
		}

		public int pop() {
			if (size == 0) {
				throw new RuntimeException("array is null");
			}
			int ans = arr[pop];
			size--;
			pop = nextIndex(pop);
			return ans;
		}

		private int nextIndex(int i) {
			return i < arr.length - 1 ? ++i : 0;
		}
	}

	public static void main(String[] args) {
		RingArray ringArray = new RingArray(3);
		ringArray.add(1);
		ringArray.add(2);
		ringArray.add(3);
		System.out.println(ringArray.pop());
		System.out.println(ringArray.pop());
		System.out.println(ringArray.pop());
		ringArray.add(5);
		ringArray.add(6);
		ringArray.add(7);
		ringArray.add(7);
		System.out.println(ringArray.pop());
		System.out.println(ringArray.pop());
		System.out.println(ringArray.pop());
	}

}
