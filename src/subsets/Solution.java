package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	
	
    public List<List<Integer>> subsets(int[] nums) {
    	Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        ArrayList<Integer> t = new ArrayList<Integer>();
        queue.add(t);
		Arrays.sort(nums);
		for(int n : nums){
			int len = queue.size();
			for(int i=0;i<len;i++){
				List<Integer> tem = queue.poll();
				queue.add(new ArrayList<Integer>(tem));
				tem.add(n);
				queue.add(tem);
			}
		}
    	return (LinkedList<List<Integer>>)queue;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[]  nums = new int[]{4,3,1};
		System.out.println(s.subsets(nums));
	}
}
