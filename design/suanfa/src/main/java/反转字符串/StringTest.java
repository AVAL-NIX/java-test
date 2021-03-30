import java.util.Stack;

/**
 * @author zhengxin
 * @date 2021/3/17
 */
public class StringTest {

    /**
     * 反转字符串
     * 用堆栈  或者双指针法
     *
     * @param str string字符串
     * @return string字符串
     */
    public static String solve(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }

        Stack<Character> result = new Stack<>();
        char[] a = str.toCharArray();
        for (char c : a) {
            result.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : a) {
            sb.append(result.pop());
        }
//        sb.reverse();
        return sb.toString();
    }

    public static String solve2(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        char temp = ' ';
        char[] s = str.toCharArray();
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        return String.valueOf(s);
    }


    public static void main(String[] args) {
        System.out.println(solve("asdfgfghghjjk"));
        System.out.println(solve2("asdfgfghghjjk"));
    }
}
