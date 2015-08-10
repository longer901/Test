package besttimetobuyandsellstockiii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
//超时
//    public int maxProfit(int[] prices) {
//    	if(prices==null||prices.length<=1)
//    		return 0;
//    	int res = 0;
//    	for(int i=0;i<prices.length-1;i++){
//    		int sum = profit(prices,0,i)+((i+1<=prices.length-1)?profit(prices,i+1,prices.length-1):0);
//    		res = Math.max(res, sum);
//    	}
//    	return res;
//    }
//    public int profit(int[] prices,int b,int e) {
//    	if(prices==null||e-b<=1)
//    		return 0;
//    	int low = prices[b];
//    	int res = 0;
//    	for(int i=b+1;i<=e;i++){
//    		int gap = prices[i]-low;
//    		if(gap>res){
//    			res = gap; 
//    		}
//    		if(gap<0){
//    			low = prices[i];
//    		}
//    	}
//    	return res;
//    }
	
	//参考答案
	 public int maxProfit(int[] prices) {
	        if (prices == null || prices.length == 0)
	            return 0;
	        int max = 0;
	        int[] left = new int[prices.length];//left[i]：从start->i天的最大利润
	        int[] right = new int[prices.length];//right[i]：从i->last天的最大利润
	        int minPrice = prices[0];
	        for (int i = 1; i < prices.length; i++) {
	            if (prices[i]-minPrice >0 ) {
	                left[i] = Math.max(left[i - 1], prices[i] - minPrice);
	            } else {
	                left[i] = left[i - 1];
	                minPrice = prices[i];
	            }
	        }
	        int maxPrice = prices[prices.length - 1];
	        for (int i = prices.length - 2; i >= 0; i--) {
	            if (maxPrice - prices[i] >0 ) {
	                right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
	            } else {
	                right[i] = right[i + 1];
	                maxPrice = prices[i];
	            }
	        }

	        for (int i = 0; i < prices.length; i++) {
	            max = Math.max(max, left[i] + right[i]);
	        }
	        return max;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		//[1,2,4,2,5,7,2,4,9,0]--13
		//1,4,1,3,2,5
		int[] prices = new int[]{1,4,1,3,2,5};
		System.out.println(s.maxProfit(prices));
	}

}
