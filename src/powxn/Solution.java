package powxn;

public class Solution {
    public double myPow(double x, int n) {
    	double res = 0;
    	if(n==0)
    		return 1;
    	if(n==1)
    		return x;
    	if(x==-0||x==0||x==1)
    		return x;
    	if(x==-1){
    		return n%2==0?1:-1;
    	}
    	if(n==-1)
    		return 1/x;
    	if(n<0){
    		n = -n;
    		x = 1/x;
    	}
    	double one = myPow(x,n/2);
    	res = one*one;
    	if((n/2)*2!=n)
    		res *= x;
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		//0.00001, 2147483647
		//0.44894, -5
		//-0.00001, 2147483647
		//-0.99999, 221620  0.10902
		System.out.println(s.myPow(-1.00000, -2147483648));
	}

}
