package integertoroman;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String intToRoman(int num) {
    	List<String> dict = new ArrayList<String>(); 
    	dict.add("I");
    	dict.add("V");
    	dict.add("X");
    	dict.add("L");
    	dict.add("C");
    	dict.add("D");
    	dict.add("M");
    	String res = "";
    	int mark = 0;
    	int count = 0;
    	while(count<=6&&num!=0){
    		int base = (int) Math.pow(10, mark);
	    	int n1 = num%(base*10);
	        if(n1!=0){
	        	int c = n1;
	        	int mid = 5*base;
        	    if(n1==mid){
	        		res = dict.get(count+1) + res;
	        	}else if(n1<mid){
	        		if(n1==4*base){
	        			res = dict.get(count) + dict.get(count+1) +  res;
	        		}else{
		        		while(c>0){
		        			res = dict.get(count) + res;
		        			c-=base;
		        		}
	        		}
	        	}else{
	        		if(n1==base*9){
	        			res = dict.get(count) + dict.get(count+2) +  res;
	        		}else{
		        		String t = dict.get(count+1);
		        		while(c>mid){
		        			t += dict.get(count);
		        			c-=base;
		        		}
		        		res = t+res;
	        		}
	        	}
	        }
	        mark++;
	        count += 2; 
	        num -= n1;
    	}
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		//"DCXXI" - 621
		//"MCMXCVI" - 1996
		System.out.println(s.intToRoman(621));
	}

}
