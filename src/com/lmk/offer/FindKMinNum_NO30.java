package com.lmk.offer;

/**
 * @author YaoZhidong
 * @version 1.0
 * @created 2017/5/13
 */

import java.util.Arrays;
        import java.util.ArrayList;
public class FindKMinNum_NO30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length<k){return result;}

        int start =0;int end = input.length-1;
        int index = partition(input,start,end);

        while (index != k-1){
            if (index >k-1){
                end = index-1;
            }else{
                start = index+1;
            }
            index = partition(input,start,end);
//            System.out.println(index);
        }
        for (int i =0;i<k;i++){
            result.add(input[i]);
            System.out.println(input[i]);
        }
        return result;
    }

    public int partition(int[] input,int start,int end){
        int mid = input[start];
        while (start<end){
            while(input[end]>=mid && start<end){
                end--;
            }
            swap(input,start,end);
            while(input[start]<=mid && start<end){
                start++;
            }
            swap(input,start,end);
        }
        return start;
    }

    public void swap(int[] input,int i,int j){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
        return;
    }


    public static void main(String[] args){
        int[] ceshi = {3,2,1,4};
        FindKMinNum_NO30 test = new FindKMinNum_NO30();
        test.GetLeastNumbers_Solution(ceshi,0);
    }
}