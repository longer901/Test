package ReverseInteger;

public class Solution {

    public static int reverse(int x) {
    	//1563847412
    	if(x==0) 
     		return 0;
     	int[] maxInt = {2,1,4,7,4,8,3,6,4,7};
     	int[] minInt = {-2,-1,-4,-7,-4,-8,-3,-6,-4,-8};
     	int res = 0;
     	int flag = 0;
     	for(int i=0;i<10;i++){
     		int t = x%10;
     		res = res*10 + t;
     		if(flag==0){
     			if(x>0){
     				flag=t>maxInt[i]?1:(t<maxInt[i]?-1:0);
     			}else if(x<0){
     				flag=t<minInt[i]?1:(t>minInt[i]?-1:0);
     			}
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
    	System.out.println(reverse(1363847412));
    
    }
}
