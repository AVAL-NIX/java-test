package 二个栈实现最小栈值;

import java.util.Stack;

/**
 * 二个栈实现一个队列
 * @author zhengxin
 * @date 2021/4/19
 */
public class Main {

    public static class DefineStack {
        /**
         * 添加栈
         */
        Stack<Integer> stack1 = new Stack<>();
        /**
         * 最小栈
         */
        Stack<Integer> minStack = new Stack<>();

        public void add(int value) {
            if (!minStack.isEmpty()) {
                 if(minStack.peek() >= value){
                     minStack.push(value);
                 }
            }else{
                minStack.push(value);
            }
            stack1.push(value);
        }

        public int get() {
            int value = stack1.peek();
            int minValue = minStack.peek();
            if(value == minValue){
                minStack.pop();
            }
            return stack1.pop();
        }

        public int length() {
            return stack1.size();
        }

        public int getMin(){
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        DefineStack defineStack = new DefineStack();

        defineStack.add(2);
        defineStack.add(3);
        defineStack.add(4);

        int len = defineStack.length();
        for (int i = 0; i < len; i++) {
            System.out.println(defineStack.getMin());
            defineStack.add(5 + i);
        }
        defineStack.add(1);
        len = defineStack.length();
        for (int i = 0; i < len; i++) {
            System.out.println(defineStack.get());
        }
    }

}
