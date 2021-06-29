package 字符串集合AA.表示数值的字符串;

import java.util.*;


public class Solution {
    public boolean isNumeric(String str) {
        //1) 若干空格,去掉
        str = str.trim();
        //标记是否出现数字
        boolean showNum = false;
        //标记是否出现点
        boolean showDot = false;
        //标记是否出现E
        boolean showE = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= '0' && c <= '9') {
                //5) 标记出现数字
                showNum = true;
            } else if (c == 'e' || c == 'E') {
                //2) 只能出现一个 'e' 或 'E' ，后面跟着一个 整数，且e前面必须有数字
                if (showE || !showNum) {
                    return false;
                }
                //标记E出现
                showE = true;
                //E不能结尾，如12e这样的，在把showNum标记为false
                showNum = false;
            } else if (c == '.') {
                //3) . 之前不能出现e，且必须出现数字，且点只能出现一次
                if (showDot || showE) {
                    return false;
                }
                //标记.出现了
                showDot = true;
                //. 点可以作为结尾， 这里showNum不用变成false   3. = true
            } else if (c == '-' || c == '+') {
                //4) +- 出现在0位置或者e/E的后第一个位置
                if (i != 0 && str.charAt(i - 1) != 'E' && str.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }

        }
        // 5) 至少出现一次数字
        return showNum;
    }


    public boolean isNumber(String str) {
        //先定义几个字符
        // s = sign = +- 号
        // d = 数字
        // . = .
        // e = e

        // 第0种， 前空格
        HashMap<Character, Integer> zero = new HashMap<>();
        //可以转移的状态
        zero.put(' ', 0);  // 前空格
        zero.put('s', 1);  // +-号
        zero.put('d', 2);  // 整数
        zero.put('.', 4);  // 左边没有整数的小数点

        // 第1种， +-号
        HashMap<Character, Integer> one = new HashMap<>();
        //可以转移的状态
        one.put('d', 2);  // 整数
        one.put('.', 4);  // 左边没有整数的小数点

        // 第2种， 整数
        HashMap<Character, Integer> two = new HashMap<>();
        //可以转移的状态
        two.put('d', 2);  // 整数
        two.put('.', 3);  // 左边有整数的小数点
        two.put('e', 6);  // e
        two.put(' ', 9);  // 后空格

        // 第3种， 左边有整数的小数点
        HashMap<Character, Integer> three = new HashMap<>();
        //可以转移的状态
        three.put('d', 5);  // 小数
        three.put('e', 6);  // e
        three.put(' ', 9);  // 后空格

        // 第4种， 左边没有整数的小数点
        HashMap<Character, Integer> four = new HashMap<>();
        //可以转移的状态
        four.put('d', 5);  // 小数

        // 第5种， 小数
        HashMap<Character, Integer> five = new HashMap<>();
        //可以转移的状态
        five.put('d', 5);  // 小数
        five.put('e', 6);  // e
        five.put(' ', 9);  // 后空格

        // 第6种， e
        HashMap<Character, Integer> six = new HashMap<>();
        //可以转移的状态
        six.put('s', 7);  // e后面的+-
        six.put('d', 8);  // e后面的数字

        // 第7种，e后面的+-
        HashMap<Character, Integer> seven = new HashMap<>();
        //可以转移的状态
        seven.put('d', 8);  // e后面的数字

        // 第8种，e后面的数字
        HashMap<Character, Integer> eight = new HashMap<>();
        //可以转移的状态
        eight.put('d', 8);  // e后面的数字
        eight.put(' ', 9);  // 后空格

        // 第8种，e后面的数字
        HashMap<Character, Integer> nine = new HashMap<>();
        //可以转移的状态
        nine.put(' ', 9);  // 后空格

        //先定义一个状态数组 用来标识上面10种状态
        Map[] states = {zero, one, two, three, four, five, six, seven, eight, nine};
        int index = 0;
        char key;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                key = 'd';
            } else if (c == '+' || c == '-') {
                key = 's';
            } else if (c == 'e' || c == 'E') {
                key = 'e';
            } else if (c == '.' || c == ' ') {
                key = c;
            } else {
                key = '?';
            }
            if (!states[index].containsKey(key)) {
                return false;
            }

            index = (int) states[index].get(key);
        }
        //合法的结束状态
        return index == 2 || index == 3 || index == 5 || index == 8;
    }


    public boolean isNumber2(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END
    }

    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isNumeric("e"));
    }
}