package minimumwindowsubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        String res = "";
    	//特殊值
        if(t==null||t.equals("")||s==null||"".equals(s)||t.length()>s.length())
        	return res;
        //hashTable
        Map<Character,Integer> standerdmap = new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
        	char tem = t.charAt(i);
        	if(!standerdmap.containsKey(tem))
        		standerdmap.put(tem, 1);
        	else
        		standerdmap.put(tem, standerdmap.get(tem)+1);
        }
        int standerdlen = standerdmap.size();
        //检测是否包含所有字母
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        Set<Character> set = new HashSet<Character>();
        int begin = 0;
        int end = 0;
        while(begin<=end&&end<s.length()){
        	while(end<s.length()){
        		char tar = s.charAt(end);
        		if(standerdmap.containsKey(tar)){
        			int v = (map.containsKey(tar)?map.get(tar):0)+1;
        			map.put(tar, v);
        			if(v>=standerdmap.get(tar))
        				set.add(tar);
            		if(set.size()==standerdlen)
            			break;
        		}
       			end++;
        	}
        	if(end==s.length())
        		return res;
        	if(min>end-begin+1){//这里说明s存在t所有字母，更新min
        		min = end-begin+1;
        		res = s.substring(begin, end+1);
        	}
        	while(begin<=end&&end<s.length()){
        		char tar = s.charAt(begin);
        		if(set.size()<standerdlen){//不包含所有字母则推出
        			if(map.containsKey(tar))
        					break;
        		}else if(set.size()==standerdlen&&map.containsKey(tar)){
                	if(min>end-begin+1){//这里说明s存在t所有字母，更新min
                		min = end-begin+1;
                		res = s.substring(begin, end+1);
                	}
                	int d = map.get(tar)-1;
                	map.put(s.charAt(begin), d);
                	if(d<standerdmap.get(tar))
                		set.remove(tar);
        		}
        		begin++;
        	}
//        	System.out.println(begin+"--"+end);
        	end++;
        }
        return res;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		String sc = "ADOBECODEBANC";
		String t = "OOEE";
//		String sc = "a";
//		String t = "aa";
//		String sc ="baAabbBBB";String t ="Bbbb";
		System.out.println(s.minWindow(sc, t));
	}
}
