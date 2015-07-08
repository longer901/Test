package lrucache;

import java.util.LinkedHashMap;

public class LRUCache {
    
	private static LinkedHashMap<Integer,Integer> cache = null;
	private static int capacity = 0;
	
    public LRUCache(int len) {
    	capacity = len;
    	cache = new LinkedHashMap<Integer,Integer>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
        	return -1;
        }else{
        	int val = cache.get(key);
        	cache.remove(key);
        	cache.put(key, val);
        	return val;
        }
    }
    
    public void set(int key, int value) {
    	if(!cache.containsKey(key)&&capacity!=0){
    		if(cache.size()>=capacity){
    			int i=0;
    			int t = 0;
    			for(Integer dataKey : cache.keySet()) {
    				i++;
    				if(i==1){
    					t = dataKey;
    					break;
    				}
    			}
    			cache.remove(t);
    		}
        	cache.put(key, value);
    	}else{
        	cache.remove(key);
        	cache.put(key, value);
    	}
    }
    
    
    public static void main(String[] args) {
    	LRUCache c = new LRUCache(2);
    	c.set(2, 1);c.set(1, 1);c.set(2, 3);c.set(4, 1);
    	System.out.println(c.get(1));
    	System.out.println(c.get(2));
	}
}
