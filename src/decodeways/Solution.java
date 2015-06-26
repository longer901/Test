package decodeways;

public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0)
        	return s.length();
        int[] nums = new int[s.length()+1];
        nums[0] = 1;
        if(s.length()==1) return s.equals("0")?0:1;
        nums[1] = s.charAt(0)=='0'?0:1;
        for(int i=2;i<=s.length();i++){
        	if(s.charAt(i-1)=='0'){
        		nums[i] = 0;
        		continue;
        	}
        	nums[i] = Integer.valueOf(s.substring(i-2, i))>26?nums[i-1]:nums[i-1]+nums[i-2];
        	System.out.println(s.substring(i-2, i)+" "+"n="+i+" "+nums[i]);
        }
        return nums[s.length()];
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numDecodings("12311312"));
	}
}
