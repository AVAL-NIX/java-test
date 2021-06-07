package 数据结构集合AA.最小栈;

import java.util.Stack;

class MinStack {

    Stack<Integer> min = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (!min.isEmpty() && val <= min.peek()) {
            min.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (!min.isEmpty() && stack.peek().equals(min.peek())) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */