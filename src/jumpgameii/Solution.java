package jumpgameii;

public class Solution {

	 public  int jump(int[] A) {
	        int ret = 0;//当前跳数
	        int last = 0;//上一跳可达最远距离
	        int curr = 0;//当前一跳可达最远距
	        int n = A.length;
	        for (int i = 0; i < n; ++i) {
	            //无法向前继跳直接返回
	            if(i>curr){
	                return -1;
	            }
	            //需要进行下次跳跃，则更新last和当执行的跳数ret
	            if (i > last) {
	                last = curr;
	                ++ret;
	            }
	            //记录当前可达的最远点
	            curr = Math.max(curr, i+A[i]);
	        }

	        return ret;
	    }
	public static void main(String[] args) {
		//1,2
		//2,3,1,1,4
		//3,2,1,0,4
		//1,2,3
		//1,3,2
		//2,3,1
		Solution s = new Solution();
		int[] nums = new int[]{2,3,1};
		System.out.println(s.jump(nums));
	}
}
