package numberofdigitone;

public class Solution {
    public int countDigitOne(int n) {
    	if(n<=0)
    		return 0;
    	int sum = 0;
    	Long h =10l;//Beware of overflow
    	while(true){
    		int chu = (int) (n/h);
    		int yu = (int) (n%h);
    		sum += chu*(h/10);
    		if(yu>=2*(h/10)){
    			sum += h/10;
    		}else if(yu>=h/10){
    			sum += yu-h/10+1;
    		}
    		if(chu==0)
    			break;
    		h *= 10;
    	}
    	return sum;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		//1410065408-->1779393982

		System.out.println(s.countDigitOne(1410065408));
	}
}
