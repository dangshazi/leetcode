package com.lmk.offer;

/**
 * @author YaoZhidong
 * @version 1.0
 * @created 2017/5/14
 */


public class NO31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if ( array==null || array.length <1){
            return 0;
        }

        int[] f = new int[array.length];
        f[0] = array[0];
        int max = Integer.MAX_VALUE;
        for(int i =1;i<array.length;i++){
            f[i] = Math.max(f[i-1]+array[i],array[i]);
            if (f[i]>max){max =f[i];}
        }
        return max;
    }
}