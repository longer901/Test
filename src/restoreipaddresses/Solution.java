package restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> list = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
    	backtrack(s,4,"");
    	return list;
    }
    public void backtrack(String s , int n ,String stored){
    	if(n==1||s.length()>n*3){
    		if(n==1&&check(s))
    			list.add(stored.substring(1)+"."+s);
    	}else{
    		for(int i=1;i<=3&&i<=s.length();i++){
    			String s1 = s.substring(0, i);
    			if(check(s1))
    				backtrack(s.substring(i),n-1,stored+"."+s1);
    		}
    	}
    }
    public boolean check(String s){
    	if(s.length()==0||(s.indexOf("0")==0&&s.length()!=1))
    		return false;
    	return  Integer.valueOf(s)<256?true:false;
    }
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.restoreIpAddresses("1111"));
	}
}
