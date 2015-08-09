package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	
    public List<String> anagrams(String[] strs) {
    	List<String> res = new ArrayList<String>();
    	if(strs==null)
    		return res;
    	HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
    	for(String t : strs){
    		char[] array = t.toCharArray();
    		Arrays.sort(array);
    		String sorted = new String(array);
    		ArrayList<String> vs = map.get(sorted);
    		if(vs!=null){
    			vs.add(t);
    		}else{
    			vs = new ArrayList<String>();
    			vs.add(t);
    			map.put(sorted, vs);
    		}
    	}
    	for(String s : map.keySet()){
    		if(map.get(s).size()>1)
    			res.addAll(map.get(s));
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] strs = {"eat","aet","","asdas",""};
		System.out.println(s.anagrams(strs));
	}

}
