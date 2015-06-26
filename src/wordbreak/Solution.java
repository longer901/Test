package wordbreak;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	//µÝ¹é  ³¬Ê±
	public String str = "";
	Set<String> wordDict = null;
    public boolean wordBreak1(String s, Set<String> dict) {
        str = s;
        wordDict = dict;
    	return wbreak(0,s.length());
    }
    public boolean wbreak(int i,int j){
    	String sk = str.substring(i, j);
    	if(wordDict.contains(sk)){
    		return true;
    	}
    	for(int k=i;k<j-1;k++){
    		String s1=str.substring(i,k+1);
    		String s2=str.substring(k+1,j);
    		System.out.println(s1+"--"+s2);
    		boolean flag = wbreak(i,k+1)&&wbreak(k+1,j);
    		if(flag)
    			return true;
    	}
    	return false;
    }
    
    //µü´ú O(n3)
    public boolean wordBreak(String s, Set<String> dict) {
    	if(s.length()==0)
    		return false;
    	boolean[][] mark = new boolean[s.length()][s.length()];
    	for(int r=0;r<s.length();r++){
    		for(int i=0;i<s.length()-r;i++){
    			int j =i+r;
    			if(dict.contains(s.substring(i, j+1))){
    				mark[i][j]=true;
    				continue;
    			}
    			System.out.println(i+"---"+j);
    			int k = i;
    			while(k<j){
    				System.out.print(k+" ");
    				if(mark[i][k]&&mark[k+1][j]){
    					mark[i][j] = true;
    					break;
    				}
    				k++;
    			}
    			System.out.println();
    		}
    	}
    	return mark[0][s.length()-1];
    }
    
    
    
	public static void main(String[] args) {
		Solution s = new Solution();
		Set<String> word = new HashSet<String>();
		word.add("cat");
		word.add("cats");
		word.add("and");
		word.add("sand");
		word.add("dog");
		String st = "catsanddog";
		System.out.println(s.wordBreak(st,word));
	}
}
