package bestTimetoBuyandSellStockI;

public class Solution {
	//²Î¿¼´ð°¸
    public int maxProfit(int[] prices) {
    	if(prices==null||prices.length<=1)
    		return 0;
    	int low = prices[0];
    	int res = 0;
    	for(int i = 1;i<prices.length;i++){
    		int gap = prices[i]-low;
    		if(gap>res){
    			res = gap; 
    		}
    		if(gap<0){
    			low = prices[i];
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
		int[] prices = new int[]{4,2};
		System.out.println(s.maxProfit(prices));
	}

}
