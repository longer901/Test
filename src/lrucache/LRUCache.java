package lrucache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LRUCache {
    
	private static HashMap<Integer,List<Integer>> cache = null;
	private static int capacity = 0;
	private static int min = Integer.MAX_VALUE;
	private static int mark = 0;
	
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	cache = new HashMap<Integer,List<Integer>>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
        	return -1;
        }else{
    		List<Integer> t = cache.get(key);
    		t.set(1, t.get(1)+1);
        	return t.get(0);
        }
    }
    
    public void set(int key, int value) {
    	if(!cache.containsKey(key)&&capacity!=0){
    		if(cache.size()>=capacity){
            	for(Integer num : cache.keySet()){
            		if(cache.get(num).get(1)<min){
            			mark = num;
            			min = cache.get(num).get(1);
            		}
            	}
            	cache.remove(mark);
    		}
    		List<Integer> t = new ArrayList<Integer>();
    		t.add(value);
    		t.add(1);
        	cache.put(key, t);
    	}
    }
}
