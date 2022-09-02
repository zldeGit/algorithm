import java.util.*;

class Solution {
	public int[][] merge(int[][] arr) {
		if(arr.length<2) return arr;
		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
		List<int[]> ans = new LinkedList<>();
		int[] merge=arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i][0]>merge[1]){
				ans.add(merge);
				merge = arr[i];
			}else{
				merge[1]=Math.max(merge[1],arr[i][1]);
			}
		}
		ans.add(merge);
		return ans.toArray(new int[ans.size()][]);
	}
}