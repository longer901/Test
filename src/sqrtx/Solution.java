package sqrtx;

public class Solution {
    public int mySqrt(int x) {
    	if(x<=1)
    		return x;
        int start = 0;
        int end = x;
        while(start<=end){
    		int res = (start+end)/2;
        	if(x/res<res){
        		end = res-1;
        	}else if(x/res>res){
        		start = res +1;
        	}else
        		return res;
        }
        return end;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.mySqrt(3));
	}

}
