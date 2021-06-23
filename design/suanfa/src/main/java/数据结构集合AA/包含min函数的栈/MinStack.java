package 数据结构集合AA.包含min函数的栈;

import java.util.Stack;

class MinStack {
    Stack<Integer> min = new Stack<>();
    Stack<Integer> v = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        v.push(x);
        if (!min.isEmpty() && min.peek() >= x) {
            min.push(x);
        }else if(min.isEmpty()){
            min.push(x);
        }
    }

    public void pop() {
        if (!v.isEmpty()) {
            if (!min.isEmpty() && min.peek().equals(v.peek())) {
                min.pop();
            }
            v.pop();
        }
    }

    public int top() {
        if (!v.isEmpty()) {
            return v.peek();
        }
        return -1;
    }

    public int min() {
        if (!min.isEmpty()) {
            return min.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */