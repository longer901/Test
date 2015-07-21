package uniquebinarysearchtrees;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	//µÝ¹é  19 limit out
//    public int numTrees(int n) {
//    	if(n<0)
//    		return 0;
//    	if(n<=1)
//    		return 1;
//    	if(n==2)
//    		return 2;
//        int sum = 0;
//        for(int i =1;i<=n;i++){
//        	int left = numTrees((i-1)-1+1);
//        	int right = numTrees(n-(i+1)+1);
//        	sum += left*right;
//        }
//    	return sum;
//    }
	//µü´ú
    public int numTrees(int n) {
    	if(n<=0)
    		return 0;
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);res.add(1);res.add(2);
        if(res.size()>n)
        	return res.get(n);
        int f = 3;
        while(f<=n){
        	int sum = 0;
        	for(int i = 1 ;i<=f;i++){
        		int left = (i-1)-1+1;
        		int leftnum = left<=0?1:res.get(left);
        		int right = f-(i+1)+1;
        		int rightnum = right<=0?1:res.get(right);
        		sum += leftnum*rightnum;
        	}
        	res.add(sum);
        	f++;
        }
        return res.get(n);	
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numTrees(19));
	}
}
