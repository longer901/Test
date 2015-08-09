package happynumber;

public class Solution {
    public boolean isHappy(int n) {
    	if(n<=1)
    		return n==1;
        int[] table = {0,1,4,9,16,25,36,49,64,81};
        String num = ""+n;
        int sum = 0;
        for(int i=0;i<num.length();){
        	int t = num.charAt(i)-'0';
        	sum += table[t];
        	if(i==num.length()-1){
        		if(sum==1||sum<10)
        			break;
        		i=0;
        		num = ""+sum;
        		sum = 0;
        	}else{
        		i++;
        	}
        }
        return sum==1;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isHappy(19));
	}
}
