package Combinations;

import java.util.ArrayList;
import java.util.List;
//fail: 1,1
public class Solution {
	
	public int maxNum = 0;
	public int len = 0;
	public List<Integer> one = new ArrayList<Integer>();
	public List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> combine(int n, int k) {
		if(k==0||n<1){
			return res;
		}
		maxNum = n;
		len = k;
		backTrack(0);
		return res;
	}
	
	public void backTrack(int k){
		if(k>maxNum||one.size()==len){
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(one);
			res.add(temp);
		}else{
			for(int i=k+1;i<=maxNum;i++){
				one.add(i);
				backTrack(i);
				one.remove(one.size()-1);
			}
		}
	}
	 
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.combine(1, 1));
	}
}
