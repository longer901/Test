package implementqueueusingstacks;

import java.util.Stack;

import listnode.ListNode;

public class Solution {
	
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.push(1);
		q.pop();
//    	while(!q.empty()){
//    		System.out.println(q.peek());
//    		q.pop();
//    	}
    	System.out.println(q.empty());
	}
}
class MyQueue {
	
	public static Stack<Integer> stack = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	Stack<Integer> tem_stack = new Stack<Integer>();
    	while(!stack.empty()){
    		tem_stack.push(stack.pop());
    	}
    	tem_stack.pop();
    	while(!tem_stack.empty()){
    		stack.push(tem_stack.pop());
    	}
    }

    // Get the front element.
    public int peek() {
    	Stack<Integer> tem_stack = new Stack<Integer>();
    	while(!stack.empty()){
    		tem_stack.push(stack.pop());
    	}
    	int res = tem_stack.peek();
    	while(!tem_stack.empty()){
    		stack.push(tem_stack.pop());
    	}
    	return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}

