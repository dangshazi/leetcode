package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Two_sum_1 {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		boolean found = false;
        for(int i = 0;i<nums.length && !found;i++){
        	for(int j = i+1;j<nums.length;j++){
        		if(nums[i]+nums[j] == target){
        			found = true;
        			result[0]=i;
        			result[1]=j;
        			break;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		Two_sum_1 test = new Two_sum_1();
		int[] result = test.twoSum(nums, 26);
		System.out.println(result[0]+" "+ result[1]);
		
	}
}
