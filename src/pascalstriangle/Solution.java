package pascalstriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(numRows<=0)
    		return res;
    	List<Integer> f = new ArrayList<Integer>();
    	f.add(1);
    	res.add(f);
    	int c = 1;
    	while(c<numRows){
    		List<Integer> tem = new ArrayList<Integer>();
    		for(int i=0;i<=c;i++){
    			List<Integer> pre = res.get(c-1);
    			int l = i-1>=0?pre.get(i-1):0;
    			int r = i<pre.size()?pre.get(i):0;
    			tem.add(l+r);
    		}
    		res.add(tem);
    		c++;
    	}
    	return res;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.generate(5));
	}
}
