package com.algor.dp;

/**
 * @Author: MaiJinQiang
 * @Date: 2020/8/19 16:26
 */
public class Test2 {

    //给定一组数组求非相邻的数的最大值
    public static void main(String[] args) {
        int[] arrs = new int[]{1, 4, 1, 1, 9};
        System.out.println(getMaxValue(arrs));
        System.out.println(getMaxValue2(arrs, arrs.length-1));
    }

    //dp
    static int getMaxValue(int[] arrs) {

        if (arrs.length == 1) {
            return arrs[0];
        } else if (arrs.length <= 0) {
            throw new IllegalArgumentException();
        }
        int[] opt = new int[arrs.length];

        opt[0] = arrs[0];
        opt[1] = Math.max(arrs[0], arrs[1]);
        for (int i = 2; i < arrs.length; i++) {
            opt[i] = Math.max(opt[i - 1], opt[i - 2] + arrs[i]);
        }

        return opt[arrs.length - 1];
    }

    //递归
    static int getMaxValue2(int[] arrs, int i) {
        if (i == 0) {
            return arrs[0];
        } else if (i == 1) {
            return Math.max(arrs[0], arrs[1]);
        } else {
            int a = getMaxValue2(arrs, i - 1);
            int b = getMaxValue2(arrs, i - 2) + arrs[i];
            return Math.max(a, b);
        }
    }
}
