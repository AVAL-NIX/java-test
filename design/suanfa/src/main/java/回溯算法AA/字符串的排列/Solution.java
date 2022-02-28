package 回溯算法AA.字符串的排列;

import java.util.*;

class Solution {
    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        boolean[] visited = new boolean[arr.length];
        dfs(arr, "", visited);
        return list.toArray(new String[0]);
    }

    Set<String> list = new HashSet<>();

    public void dfs(char[] arr, String s, boolean[] visited) {
        if (s.length() == arr.length) {
            list.add(s);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // || (i > 0 && !visited[i - 1] && arr[i - 1] == arr[i]) 减枝  可要可不要
            if (visited[i] || (i > 0 && !visited[i - 1] && arr[i - 1] == arr[i]))
                continue;
            visited[i] = true;
            dfs(arr, s + String.valueOf(arr[i]), visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permutation("aab"));
    }

}