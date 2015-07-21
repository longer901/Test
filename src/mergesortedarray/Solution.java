package mergesortedarray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int last = m-1;
        for(int p=0;p<n;p++){
        	if(m==0){
        		nums1[p]=nums2[p];
        		continue;
        	}
        	int num2 = nums2[p];
        	if(num2>=nums1[last]){
        		last++;
        		nums1[last] = num2; 
        	}else{
        		//count the pos of insertion
        		int k= 0;
        		for(;k<=last;k++){
        			if(num2<nums1[k])
        				break;
        		}
        		for(int i=last;i>=k;i--){
        			nums1[i+1] = nums1[i];
        		}
        		nums1[k] = num2;
        		last++;
        	}
        }
    }
	public static void main(String[] args) {
//		int[] nums1 = {1,3,5,7,9,0,0,0,0};
//		int[] nums2 = {2,4,6,8};
		int[] nums1 = {0,0,0,0,0,0,0,0,0};
		int[] nums2 = {1,2,3,4};
		Solution s = new Solution();
		s.merge(nums1,0,nums2,0);
		System.out.println(nums1);
	}
}
