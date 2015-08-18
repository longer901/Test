package permutationsequence;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	
    public String getPermutation(int n, int k) {
    	//n digits
    	String res = ""; 
    	int jiecheng = 1;
    	List<String> nums = new LinkedList<String>();
        for(int i=1;i<=n;i++){
        	nums.add(""+i);
        	jiecheng *= i;
        }
        int next = k-1;
        jiecheng /= n;  
        for(int i=0;i<n-1;i++){
        	int index = next/jiecheng;
        	res += nums.get(index);
        	nums.remove(index);
        	next %= jiecheng;
        	jiecheng /=n-i-1;
        }
        res +=nums.get(0);
        return res;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.getPermutation(9, 3));
	}
}
