package pascalstriangleii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(rowIndex<0)
    		return res;
    	res.add(1);
    	int c = 1;
    	while(c<=rowIndex){
    		List<Integer> tem = new ArrayList<Integer>();
    		for(int i=0;i<=c;i++){
    			int l = i-1>=0?res.get(i-1):0;
    			int r = i<res.size()?res.get(i):0;
    			tem.add(l+r);
    		}
    		c++;
    		res = tem;
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s= new Solution();
		System.out.println(s.getRow(3));
	}

}
