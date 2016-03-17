package com.lmk.leetcode;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array_26 {
	public int removeDuplicates(int[] nums) {
        int result;
		Arrays.sort(nums);
		
		if (nums.length == 1){
			return 1;
		}
        int number =1;
        
        for (int i = 1; i < nums.length; i++) {
        	if(nums[i] != nums[i-1]){
        		number++;
        	}else{
        		nums[i-1] = Integer.MAX_VALUE;
        	}
		}
        Arrays.sort(nums);
        result = number;
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remove_Duplicates_from_Sorted_Array_26 test = new Remove_Duplicates_from_Sorted_Array_26();
		int[] nums = {1,1,1};
		System.out.println(test.removeDuplicates(nums));
		
		
	}

}
