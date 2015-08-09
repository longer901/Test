package dividetwointegers;

public class Solution {
	public double shang = 0;
    public int divide(int dividend, int divisor) {
    	if(divisor==0)
    		return Integer.MAX_VALUE;
        if(dividend==0||divisor==1)
        	return dividend;
        boolean flag = ((dividend>0&&divisor>0)||(dividend<0&&divisor<0))?true:false;
        if(divisor==Integer.MIN_VALUE){//保证Math.abs(divisor)
        	return dividend==divisor?1:0;
        }
        int mark = 0;
        if(dividend==Integer.MIN_VALUE){//保证Math.abs(dividend)
        	if(divisor>0){
        		dividend +=divisor;
        		mark--;
        	}else{
        		dividend -=divisor;
        		mark++;
        	}
        }
        dividesam(Math.abs(dividend),Math.abs(divisor));
        double res = flag?shang+mark:-shang+mark;
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE)
        	return Integer.MAX_VALUE;
        return (int) res;
    }
    public void dividesam(int dividend,int divisor){
        if(dividend>0&&dividend<divisor)
        	return ;
        int max = divisor;
        double count = 1;
        while(max<=dividend-max){//max+max<=dividend max会溢出
        	count = count+count;
        	max = max + max;
        }
        shang += count;
        if(dividend-max!=0)
        	dividesam(dividend-max,divisor);
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		//2147483647, 2
		//-1010369383, -2147483648
		//-1,1
		System.out.println(s.divide(-2147483648, 2));
	}
}
