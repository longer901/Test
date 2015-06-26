package palindromenumber;

//fail::1147557411
//fail::-123
public class Solution {
	 //Runtime: 532 ms Space: O(n)
	 public static boolean isPalindrome2(int x) {
		   StringBuilder s = new StringBuilder(""+x);
		   String res = s.reverse().toString();
	       return res.equals(""+x);
	 }
	//Runtime: 468 ms Space: O(1)
	 public static boolean isPalindrome(int x) {
         if(x<0) return false;
	       int reverse = reverse(x);
	       return reverse==x;
	 }
	 public static int reverse(int x) {
		 	if(x==0) 
	     		return 0;
	     	int[] maxInt = {2,1,4,7,4,8,3,6,4,7};
	     	int res = 0;
	     	int flag = 0;
	     	for(int i=0;i<10;i++){
	     		int t = x%10;
	     		res = res*10 + t;
	     		if(flag==0){
	     			flag=t>maxInt[i]?1:(t<maxInt[i]?-1:0);
	     		}
	     		if(i==9&&flag==1){
	     			return 0;
	     		}
	     		x=x/10;
	     		if(x==0)
	     			break;
	     	}
	 		return res;    
	    }
	 
	    public static void main(String[] args){
	    	System.out.println(isPalindrome2(1147557411));
	    }
}
