package nextpermutation;

public class Solution {
    public void nextPermutation(int[] num) {
    	if(num==null||num.length<=1)
    		return;
    	if(num[num.length-2]<num[num.length-1]){
    		reverse(num,num.length-2,num.length-1);
    		return;
    	}
    	//ÕÒpos
    	int pos = Integer.MIN_VALUE;
    	for(int i=num.length-1;i>=1;i--){
    		if(num[i-1]<num[i]){
    			pos = i-1;
    			break;
    		}
    		if(i==1){
    			reverse(num,0,num.length-1);
    			return;
    		}
    	}
    	if(num[pos]<num[num.length-1]){
    		reverse(num,pos+1,num.length-1);
    		reverse(num,pos,pos+1);
    		return;
    	}
    	int respos = Integer.MIN_VALUE;
    	for(int i=pos;i<num.length-1;i++){
    		if(num[i+1]<=num[pos]){
    			respos = i;
    			break;
    		}
    	}
    	int t = num[pos];
    	num[pos] = num[respos];
    	num[respos] = t;
    	reverse(num,pos+1,num.length-1);
    }
    public void reverse(int[] nums,int i,int j){
    	if(i>=j)
    		return;
    	while(i<j){
    		int t = nums[i];
    		nums[i] = nums[j];
    		nums[j] = t;
    		i++;
    		j--;
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = new int[]{1,1,2,5};
		while(true){
			s.nextPermutation(nums);
			for(int n: nums){
				System.out.print(" "+n);
			}
			System.out.println();
		}
	}

}
