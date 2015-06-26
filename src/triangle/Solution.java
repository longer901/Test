package triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle.size()>1){
	        for(int i=triangle.size()-2;i>=0;i--){
	        	for(int j=0;j<triangle.get(i).size();j++){
	        		int m = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1))+triangle.get(i).get(j);
	        		triangle.get(i).set(j, m);
	        	}
	        }
    	}
        return triangle.get(0).get(0);
    }
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(2);l2.add(3);
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(l1);triangle.add(l2);
		Solution s = new Solution();
		System.out.println(s.minimumTotal(triangle));
	}
}
