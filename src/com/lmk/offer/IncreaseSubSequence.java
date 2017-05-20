package com.lmk.offer;

/**
 * @author YaoZhidong
 * @version 1.0
 * @created 2017/5/14
 */

import java.util.Arrays;
public class IncreaseSubSequence {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    //方法一：
    // public int longestIncreasingSubsequence(int[] nums) {
    //     // write your code here
    //     if (nums == null || nums.length <1){return 0;}
    //     int[] L = new int[nums.length];
    //     L[0] = 1;
    //     int max = Integer.MIN_VALUE;
    //     for (int j =1;j<nums.length;j++){
    //         for (int i =0;i<j;i++){
    //             if (nums[i]<nums[j]){
    //                 L[j] = Math.max(L[j],L[i]+1);
    //             }else{
    //                 L[j] = Math.max(1,L[j]);
    //             }
    //         }
    //         if (max<L[j]){max =L[j];}
    //     }
    //     return max;
    // }
    //方法二：
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length <1){return 0;}
        int[] L = new int[nums.length];
        L[0] = nums[0];
        int index = 0;
        for (int j =1;j<nums.length;j++){
            if (nums[j]>L[index]){
                index++;
                L[index] = nums[j];
            }else{
                int returnCode = Arrays.binarySearch(L,0,index,nums[j]);
                if (returnCode>0){
                    // L[returnCode+1]=nums[j];
                }else{
                    int insertPoint = -1*(returnCode+1);
                    L[insertPoint] = nums[j];
                }
            }

        }
        return index;
    }
}
