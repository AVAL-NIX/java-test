package 二个栈实现一个队列;

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
         * 获取栈
         */
        Stack<Integer> stack2 = new Stack<>();

        public void add(int value) {
            stack1.push(value);
        }

        public int get() {
            if (stack2.isEmpty() && !stack1.isEmpty()) {
                int len = stack1.size();
                for (int i = 0; i < len; i++) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int length() {
            return stack1.size() + stack2.size();
        }
    }

    public static void main(String[] args) {
        DefineStack defineStack = new DefineStack();
        defineStack.add(1);
        defineStack.add(2);
        defineStack.add(3);
        defineStack.add(4);

        int len = defineStack.length();
        for (int i = 0; i < len; i++) {
            System.out.println(defineStack.get());
            defineStack.add(5 + i);
        }
        len = defineStack.length();
        for (int i = 0; i < len; i++) {
            System.out.println(defineStack.get());
        }
    }

}
