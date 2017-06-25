package com.lmk.leetcode;

import org.junit.Test;

/**
 * Created by lmk on 2017/6/25.
 */
public class PrintMinNumber_33 {

    @Test
    public void testStringCompareTo(){
        int[] test = {3,5,1,4,2};
        System.out.println(PrintMinNumber(test));
    }

    public String PrintMinNumber(int [] numbers) {
        StringBuilder result = new StringBuilder();
        boolean[] flag = new boolean[numbers.length];
        for (int i =0;i<numbers.length;i++){
            int min =  -1;int start = 0;
            //选取一个min的初始值
            for (int  j =0;j<numbers.length;j++){
                if (!flag[j]){
                    min = numbers[j];
                    start = j+1;
                    break;
                }
            }
            int index = start-1;
            for (int j= start ;j<numbers.length;j++){
                if (!flag[j] && compareToGetMin(numbers[j],min)<0){
                    min = numbers[j];
                    index = j;
                }
            }
            flag[index] = true;
            result.append(min);
        }
        return result.toString();
    }

    private int compareToGetMin(int a,int b){
        return (""+a+b).compareTo(""+b+a);
    }
}
