package hot;

import java.util.*;

/**
 * @author 张璐
 * @date 2022/8/19
 * 给定数组hard和money，长度都为N，hard[i]表示i号工作的难度， money[i]表示i号工作的收入
 * 给定数组ability，长度都为M，ability[j]表示j号人的能力，每一号工作，都可以提供无数的岗位，难度和收入都一样
 * 但是人的能力必须&gt;=这份工作的难度，才能上班。返回一个长度为M的数组ans，ans[j]表示j号人能获得的最好收入
 * [68,35,52,47,86] [67,17,1,81,3] [92,10,85,84,82] 测试结果:204 期望结果:324
 */
public class _2_最好的收入 {
	public static int[] bestEarning(int[] hard, int[] money, int[] ability) {
		TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < hard.length; i++) {
			Integer integer = map.getOrDefault(hard[i], -1);
			if (money[i]>integer) {
				map.put(hard[i], money[i]);
			}
		}
		Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
		int preMoney = -1;
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> next = iterator.next();
			if (next.getValue() <= preMoney) {
				iterator.remove();
			} else {
				preMoney = next.getValue();
			}
		}
		int[] res = new int[ability.length];
		for (int i = 0; i < res.length; i++) {
			Integer integer = map.floorKey(ability[i]);
			res[i] = integer == null ? 0 : map.get(integer);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] hard = {68,35,52,47,86};
		int[] money = {67,17,1,81,3};
		int[] ability = {92,10,85,84,82};
		bestEarning(hard, money, ability);
	}

}
