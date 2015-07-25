package substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	public List<Integer> res = new ArrayList<Integer>();
	public Map<String,Integer> dict = new HashMap<String,Integer>();
	public int singlen = 0;
	public int leastlen = 0;
    public List<Integer> findSubstring(String s, String[] words) {
    	if(s==null||"".equals(s)||words==null||words.length==0)
    		return res;
    	singlen = words[0].length();
    	leastlen = words.length*singlen;
    	if(s.length()<leastlen)
    		return res;
        for(String w : words){
        	if(dict.containsKey(w)){
        		dict.put(w, dict.get(w)+1);
        	}else
        		dict.put(w, 1);
        }
//        System.out.println(dict);
        backtrack(s);
        return res;
    }
    public void backtrack(String target){
    	if(target==null||target.equals("")||target.length()<leastlen)
    		return;
    	Map<String,Integer> log = new HashMap<String,Integer>();
    	Set<String> set = new HashSet<String>();
    	int begin = 0;
    	int end = 0;
    	while(begin<=end&&end+singlen<=target.length()){
    		String t = target.substring(end, end+singlen);
    		//不存在字典中，继续遍历
    		if(!dict.containsKey(t)){
    			begin++;
    			end = begin;
    			continue;
    		}
    		//在字典中,end向后遍历
    		boolean flag = false;
    		while(dict.containsKey(t)&&end+singlen<=target.length()){
    			end = end+singlen;
        		int v = log.containsKey(t)?log.get(t):0;
        		log.put(t, v+1);
        		if(dict.get(t)>=v+1){
        			if(dict.get(t)==v+1)
        				set.add(t);
        		}else{
        			begin++;
        			end = begin;
        			break;
        		}
        		if(set.size()==dict.size()){
        			flag= true;
        			break;
        		}
        		if(end+singlen<=target.length())
        			t = target.substring(end, end+singlen);
    		}
    		if(flag){
    			res.add(begin);
    			begin++;
    			end = begin;
    		}
	    	log = new HashMap<String,Integer>();
	    	set = new HashSet<String>();
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String ss = "barfoofoobarthefoobarman";
		String[] words= {"bar","foo","the"};
//		String ss = "sdfsbarfoothefoobarman";
//		String[] words = {"foo","bar"};
//		String ss = "aaaaaaaa";
//		String[] words = {"aa","aa","aa"};
//		String ss = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
//		String[] words = {"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};
		System.out.println(s.findSubstring(ss, words));
	}

}
