package 数组集合AA.杨辉三角;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            //大于1 找之前的
            if (i > 0) {
                List<Integer> pre = res.get(i - 1);
                for (int j = 0; j < pre.size() + 1; j++) {
                    int value;
                    //处理左边界
                    if (j - 1 < 0 || j -1>= pre.size()) {
                        value = 0;
                    } else {
                        value = pre.get(j - 1);
                    }
                    //处理右边界
                    int value1 = 0;
                    if (j >= pre.size()) {
                        value1 = 0;
                    } else {
                        value1 = pre.get(j);
                    }
                    temp.add(value + value1);
                }
                res.add(temp);
            } else if (i == 0) {
                temp.add(1);
                res.add(temp);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().generate(4);
    }
}