package minstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		
	}
}

class MinStack {
	
	public Stack<Integer> stack = new Stack<Integer>();
	public List<Integer> min = new ArrayList<Integer>();
	
    public void push(int x) {
    	stack.push(x);
    	if(min.size()==0){
    		min.add(x);
    	}else{
    		if(x<min.get(min.size()-1)){
    			min.add(x);
    		}else{
    			min.add(min.get(min.size()-1));
    		}
    	}
    }

    public void pop() {
    	stack.pop();
    	min.remove(min.size()-1);
    }

    public int top() {
    	return stack.peek();
    }

    public int getMin() {
    	return min.get(min.size()-1);
    }
}
