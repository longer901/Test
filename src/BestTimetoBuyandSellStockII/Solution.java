package BestTimetoBuyandSellStockII;

public class Solution {

    public int maxProfit(int[] prices) {
    	if(prices==null||prices.length<=1)
    		return 0;
    	int res = 0;
    	for(int i=1;i<prices.length;i++){
    		int t = prices[i]-prices[i-1];
    		if(t>0){
    			res += t;
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
		int[] prices = new int[]{1,2,1,3,2,5};
		System.out.println(s.maxProfit(prices));
	}

}
