package ContainerWithMostWater;

import java.util.Map;
import java.util.TreeMap;


public class Solution {
	//O(nlogn)
    public int maxArea1(int[] height) {
    	Map<Integer,String> height_weights = new TreeMap<Integer,String>();
    	for(int i=0;i<height.length;i++){
    		if(height_weights.containsKey(height[i])){
    			height_weights.put(height[i], height_weights.get(height[i])+","+i);
    		}else
    			height_weights.put(height[i], ""+i);
    	}
    	int max = 0;
    	int begin = 0;
    	int end = height.length-1;
    	for(int h : height_weights.keySet()){
    		String[] ws = height_weights.get(h).split(",");
    		for(String w : ws){
    			int n = Integer.valueOf(w);
    			while(height[begin]==-1)
    				begin++;
    			while(height[end]==-1)
    				end--;
    			max = Math.max(h*Math.max(end-n, n-begin),max);
    			height[n] = -1;
    		}
    	}
    	return max;
    }
    //O(nlogn)
    public static int[] syn ;
    public int maxArea2(int[] height) {
    	syn = new int[height.length];
    	for(int i=0;i<height.length;i++)
    		syn[i] = i;
    	int[] sort = new int[height.length];
    	System.arraycopy(height, 0, sort, 0, height.length);
    	quickSort(sort, 0, sort.length-1);
    	int max = 0;
    	int begin = 0;
    	int end = sort.length-1;
    	for(int k=0;k<sort.length-1;k++){
			while(height[begin]==-1)
				begin++;
			while(height[end]==-1)
				end--;
			max = Math.max(sort[k]*Math.max(end-syn[k], syn[k]-begin),max);
			height[syn[k]] = -1;
    	}
    	return max;
    }
    
    public static void quickSort(int[] array,int beg,int end){
		if(beg >= end || array == null)
			return;
		int p = partition(array, beg, end);
		quickSort(array, beg, p-1);
		quickSort(array, p+1, end);
	}
    
    private static int partition(int[] array, int beg, int end) {
        int first = array[beg];
        int i = beg, j = end;
        while (i < j) {
            while (array[i] <= first && i < end) {
                i++;
            }
            while (array[j] > first && j >= beg) {
                j--;
            }
            if (i < j) {
            	int t = array[i];
                array[i] = array[j];
                array[j] = t;
            	t = syn[i];
            	syn[i] = syn[j];
            	syn[j] = t;
            }
        }
        if (j != beg) {
        	int t = array[beg];
            array[beg] = array[j];
            array[j] = t;
        	t = syn[beg];
        	syn[beg] = syn[j];
        	syn[j] = t;
        }
        return j;
    }
    
    //O(n)
    public int maxArea(int[] height) {
        int result = 0;
        for(int i=0,j=height.length-1;i<j;){
            // get current area
            int area = Math.min(height[i],height[j])*(j-i);
            result = Math.max(area,result);
            //move the pointers
            if(height[i]<height[j]){
                i++;
            }
            else {
                j--;
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] height = new int[]{4,1,2,5,3,4};
		System.out.println(s.maxArea(height));
	}
}
