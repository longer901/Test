package summaryranges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
    	List<String> res = new ArrayList<String>();
    	if(nums==null)
    		return res;
    	if(nums.length==1){
    		res.add(""+nums[0]);
    		return res;
    	}
    	int start = 0;
    	int end = 0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]+1==nums[i+1]){
    			end = i+1;
    		}else{
    			res.add(start==end?""+nums[start]:nums[start]+"->"+nums[end]);
    			start =i+1;
    			end = i+1;
    		}
    		if(i==nums.length-2){
    			res.add(start==end?""+nums[start]:nums[start]+"->"+nums[end]);
    			break;
    		}
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = new int[]{-1};
		System.out.println(s.summaryRanges(nums));
	}

}
