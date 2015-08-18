package adddigits;

public class Solution {

    public int addDigits(int num) {
    	if(num==0)
    		return 0;
        while(num%10==0)
        	num = num/10;
        String n = ""+num;
        int res = 0;
        for(int i=0;i<n.length();i++)
        	res += n.charAt(i)-'0';
        int len = (res/10)%9+1;
        String s = len+(res%10-1)+"";
        int p = 0;
        for(int i=0;i<s.length();i++)
        	p += s.charAt(i)-'0';
        return p;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.addDigits(0));
	}

}
