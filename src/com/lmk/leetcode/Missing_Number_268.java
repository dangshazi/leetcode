package com.lmk.leetcode;

public class Missing_Number_268 {
	public int missingNumber(int[] nums) {
		int result = 0;
        boolean[] appeared = new boolean[nums.length+1];
		
		for (int i = 0; i < nums.length; i++) {
				appeared[nums[i]] = true;
		}
		
		for (int i = 0; i < nums.length+1; i++) {
			if (!appeared[i]){
				result = i;
				return result;
			}
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Missing_Number_268 test = new Missing_Number_268();
		int[] nums = { 1, 3,2,4};
		System.out.println(test.missingNumber(nums));
		
	}

}
