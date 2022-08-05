package prepare;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author 张璐
 * @date 2022/7/28
输入正数数组costs、正数数组profits、正数K和正数M
costs[i]表示i号项目的花费
profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
K表示你只能串行的最多做k个项目
M表示你初始的资金
说明：每做完一个项目，马上获得的收益，可以支持你去做下一个项目，不能并行的做项目。
输出：最后获得的最大钱数
 */
public class _51_贪心_获取最大的钱数 {
	public int getMaxMoney(int[] costs, int[] profits, int K, int M) {
		PriorityQueue<Project> minCostsQueue = new PriorityQueue<>((o1, o2) -> o1.costs - o2.costs);
		PriorityQueue<Project> maxProfitsQueue = new PriorityQueue<>((a, b) -> b.profits - a.profits);

		for (int i = 0; i < costs.length; i++) {
			Project project = new Project(costs[i], profits[i]);
			minCostsQueue.add(project);
		}
		for (int i = 0; i < K; i++) {
			while (!minCostsQueue.isEmpty() && minCostsQueue.peek().costs <= M) {
				maxProfitsQueue.add(minCostsQueue.poll());
			}
			if (maxProfitsQueue.isEmpty()) {
				return M;
			}
			Project poll = maxProfitsQueue.poll();
			M +=poll.costs;
		}
		return M;
	}
	public class Project  {
		int costs;
		int profits;

		public Project(int costs, int profits) {
			this.costs = costs;
			this.profits = profits;
		}
	}

}
