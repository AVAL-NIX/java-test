package 寻找第K大;

import java.util.*;

public class Solution {
    public int findKth(int[] a, int n, int K) {
        // write co{de here
        if (n == 0) {
            return 0;
        }
        quickSort(a, 0, a.length-1);

        System.out.println(Arrays.toString(a));
        return a[n-K];
    }

    private void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int f = sortFn(a, left, right);
            quickSort(a, left, f);
            quickSort(a, f + 1, right);
        }
    }

    private int sortFn(int[] arr, int left, int right) {
        int ltemp = left;
        int rtemp = right;

        int f = arr[left];
        while(ltemp < rtemp){
            //右边找
            while(ltemp < rtemp && arr[rtemp] >= f){
                rtemp--;
            }
            arr[ltemp] = arr[rtemp];

            //左边
            while(ltemp < rtemp && arr[ltemp] <= f){
                ltemp++;
            }
            arr[rtemp] = arr[ltemp];

        }
        arr[ltemp] = f;
        return ltemp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKth(new int[]{1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663}, 49,24));
    }
}
