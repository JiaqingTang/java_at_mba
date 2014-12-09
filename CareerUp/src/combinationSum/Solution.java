package combinationSum;

public class Solution {
	public boolean isCombinSum(int[] num, int target) {
		if(num == null || num.length == 0) {
			return false;
		}
		boolean[] table = new boolean[target+1];
		table[0] = true;
		for(int i = 0; i < num.length; ++i) {
			for(int j = num[i]; j <= target; ++j) {
				table[j] |= table[j-num[i]];
			}
		}
		return table[target];
	}
	
	public static void main(String[] args) {
		int[] num = {2, 3, 6, 7};
		Solution s = new Solution();
		System.out.println(s.isCombinSum(num, 1));
	}
}
