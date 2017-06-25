package com.lmk.leetcode;

public class Single_Number_136 {
	public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
			result = result ^ nums[i];
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Single_Number_136 test = new Single_Number_136();
		
		int[] nums = {3,4,5,3,5,4,3,4,5,2};
		int result = test.singleNumber(nums);
		System.out.println(result);
	}

}
