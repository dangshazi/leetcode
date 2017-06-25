package com.lmk.leetcode;

import org.junit.Test;

/**
 * Created by lmk on 2017/6/25.
 */
public class GetUglyNumber_34 {
    public int GetUglyNumber_Solution(int index) {
        if (index == 1){
            return 1;
        }
        int[] uglyNumberArr = new int[index];
        uglyNumberArr[0] = 1;
        int nextUglyIndex = 1;
        int p2=0;int p3=0;int p5=0;
        while(nextUglyIndex<index){
            int min= getMin(uglyNumberArr[p2]*2,uglyNumberArr[p3]*3,uglyNumberArr[p5]*5);
            uglyNumberArr[nextUglyIndex]= min;
            while (p2*2<=min){p2++;}
            while (p3*3<=min){p3++;}
            while (p5*5<=min){p5++;}
            nextUglyIndex++;
        }
        for (int i:uglyNumberArr
             ) {
            System.out.println(i);
        }
        return uglyNumberArr[index-1];
    }
    private int getMin(int a,int b,int c){
        int tmp = Math.min(a,b);
        return Math.min(tmp,c);
    }
    @Test
    public void test(){
        System.out.println(GetUglyNumber_Solution(3));
    }
}
