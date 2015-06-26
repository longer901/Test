package wordbreakii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//DP求所有问题
public class Solution {
	//正向 超时
	public List<String> list = new ArrayList<String>();
	public List<List<String>> reslist = new ArrayList<List<String>>();
	public String[][] strs = null;
	public List<String> wordBreak1(String s, Set<String> wordDict) {
        int len = s.length();
        strs = new String[len+1][len+1];
        list.add(" ");
        for (int i=1; i<len+1; i++){
        	String one = new String();
            for (int j=0; j<i; j++){
            	strs[i][j] = s.substring(j,i);
                if ((list.get(j).length()!=0)&& wordDict.contains(strs[i][j]))
                {
                	System.out.println(strs[i][j]);
                   	one += one.length()==0?j:","+j; 
                }
            }
            list.add(one);
            System.out.println(one);
        }
        List<String> reszero = new ArrayList<String>();
        reszero.add("");
        reslist.add(reszero);
        for(int i =1;i<list.size();i++){
        	List<String> oneres = new ArrayList<String>();
        	String[] tt = list.get(i).split(",");
        	for(String h : tt){
        		if(h.length()==0)
        			continue;
        		int j = Integer.valueOf(h);
	        	for(String t :reslist.get(j)){
	        		oneres.add(t.length()==0?strs[i][j]:t+" "+strs[i][j]);
	        	}
        	}
        	reslist.add(oneres);
            //System.out.println(oneres);
        }
        return reslist.get(reslist.size()-1);
    }
    
//	逆向也超时
    public List<String> wordBreak2(String s, Set<String> dict) {
        Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();
        // initialize the valid values
        List<String> l = new ArrayList<String>();
        l.add("");
        validMap.put(s.length(), l);
        // generate solutions from the end
        for(int i = s.length() - 1; i >= 0; i--) {
            List<String> values = new ArrayList<String>();
            for(int j = i + 1; j <= s.length(); j++) {
                if (dict.contains(s.substring(i, j))) {
                    for(String word : validMap.get(j)) {
                        values.add(s.substring(i, j) + (word.isEmpty() ? "" : " ") + word);
                    }
                }
            }
            validMap.put(i, values);
        }
        return validMap.get(0);
    }
	
    HashMap<String, List<String>> map= new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> list=new ArrayList<String>();

        if(map.containsKey(s)) return map.get(s);

        for(int i=1; i<=s.length();i++){
            String left=s.substring(0,i);
            String right=s.substring(i);
            if(dict.contains(left)){
                List<String> a=wordBreak(right, dict);
                for(String b:a){
                    list.add(left+" "+b);
                }
                if(right.length()==0) list.add(left);
            }

        }

        map.put(s, list);
        return list;
        }
	public static void main(String[] args) {
		Solution s = new Solution();
		Set<String> word = new HashSet<String>();
		word.add("b");
//		word.add("a");
//		word.add("aa");
//		word.add("aaa");
//		word.add("aaaa");
//		word.add("aaaaa");
//		word.add("aaaaaa");
		word.add("aaaaaaa");
		word.add("aaaaaaab");
//		word.add("aaaaaaaaa");
		word.add("aaaaaaaaaa");
		String st = "aaaaaaab";
		
//		word.add("cat");
//		word.add("cats");
//		word.add("and");
//		word.add("sand");
//		word.add("dog");
//		String st = "catsanddog";
		System.out.println(s.wordBreak(st,word));
	}
}
