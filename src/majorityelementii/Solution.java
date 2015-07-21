package majorityelementii;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution {
//http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html#step13
	/*
	 * 多数投票算法
	 * !最后需要再遍历一遍确认
	 */
    public List<Integer> majorityElement(int[] nums) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	//nums.lenght<=3是有一个 1个数字
    	Stack<Integer> stack0 = new Stack<Integer>();
    	Stack<Integer> stack1 = new Stack<Integer>();
    	for(int n:nums){
    		if(!stack0.isEmpty()&&stack0.peek()==n)
    			stack0.add(n);
    		else if(!stack1.isEmpty()&&stack1.peek()==n)
    			stack1.add(n);
    		else if(stack0.isEmpty())
    			stack0.add(n);
    		else if(stack1.isEmpty())
    			stack1.add(n);
    		else{
    			stack0.pop();
    			stack1.pop();
    		}
    	}
    	if(!stack0.isEmpty()){
    		int val = stack0.peek();
    		int c = 0;
    		for(int n : nums)
    			if(n==val)
    				c++;
    		if(c>nums.length/3)
    			list.add(val);
    	}
    	if(!stack1.isEmpty()){
    		int val = stack1.peek();
    		int c = 0;
    		for(int n : nums)
    			if(n==val)
    				c++;
    		if(c>nums.length/3)
    			list.add(val);
    	}
    	return list;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1,4};
		Solution s = new Solution();
		System.out.println(s.majorityElement(nums));
	}

}
