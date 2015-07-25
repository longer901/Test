package trappingrainwater;

public class Solution {
    public int trap(int[] height) {
        int sum = 0;
    	if(height==null||height.length<=2)
    		return sum;
        int begin = 0;
        int end = height.length-1;
        while(begin<=end){
        	if(begin+1<=end&&height[begin+1]>=height[begin]){
        		begin++;
        	}
        	if(end-1>=begin&&height[end-1]>=height[end]){
        		end--;
        	}
        	if(height[begin]<=height[end]){//×óÐ¡ÓÚÓÒ
        		int scaner = begin;
        		int leftheight = height[begin];
        		while(scaner<=end&&leftheight>=height[scaner]){
        			sum += leftheight-height[scaner];
        			scaner++;
        		}
        		begin = scaner;
        	}else{//right is smaller than left ,so if scan from right,there is always a bigger num 
        		int scaner = end;
        		int rightheight = height[end];
        		while(scaner<=end&&rightheight>=height[scaner]){
        			sum += rightheight-height[scaner];
        			scaner--;
        		}
        		end = scaner;
        	}
        }
        return sum;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
//		int[] height = {4,2,4};

		int[] height = {0,0,1,0,2,1,0,1,3,2,1,2,1,0,0};
		System.out.println(s.trap(height));
	}

}
