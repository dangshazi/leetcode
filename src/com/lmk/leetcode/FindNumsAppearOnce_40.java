package com.lmk.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmk on 2017/6/25.
 */
public class FindNumsAppearOnce_40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = array[0];
        for (int i =1;i<array.length;i++){
            temp ^= array[i];
        }
        System.out.println("temp = "+ temp);
        //find k
        int k = 1;
        while ( (k & temp) == 0){
            k = k << 1;
        }
        System.out.println("k = "+k);
        // 分组
        List<Integer> zu1 = new ArrayList<Integer>();
        List<Integer> zu2 = new ArrayList<Integer>();
        for (int i = 0;i<array.length;i++){
            if ((k & array[i]) == 0){
                zu1.add(array[i]);
            }else{
                zu2.add(array[i]);
            }
        }

        for (int t: zu1
             ) {
            System.out.print(t + " ");
        }
        System.out.println();
        for (int t: zu2
                ) {
            System.out.print(t + " ");
        }

        num1[0] = find(zu1);
        num2[0] = find(zu2);
        return;
    }

    private int find(List<Integer> list){
        if (list.size() <=1){
            return list.get(0);
        }
        int temp = list.get(0);
        for (int k:list){
            temp ^= k;
        }
        return temp;
    }

    @Test
    public void test(){
        int[] array =  {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]+"   "+num2[0]);
    }
}
