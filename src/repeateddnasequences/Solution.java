package repeateddnasequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        if(s.length()<10)
        	return res;
        for(int i=0;i<=s.length()-10;i++){
        	String str = s.substring(i, i+10);
        	map.put(str, map.containsKey(str)?map.get(str)+1:1);
        }
        for(String t : map.keySet()){
        	if(map.get(t)>1)
        		res.add(t);
        }
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

}
