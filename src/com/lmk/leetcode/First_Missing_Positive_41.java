package com.lmk.leetcode;

public class First_Missing_Positive_41 {
	public int firstMissingPositive(int[] nums) {
        int result = 1;
		int LENGTH = 100000000;
        boolean[] appeared = new boolean[LENGTH];
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0){
				appeared[nums[i]] = true;
			}
		}
		
		for (int i = 1; i < LENGTH; i++) {
			if (!appeared[i]){
				result = i;
				return result;
			}
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		First_Missing_Positive_41 test = new First_Missing_Positive_41();
		
		int[] nums = {3,5,-3,-10,3,-4,9,7,-3,-1};
		int result = test.firstMissingPositive(nums);
		System.out.println(result);
	}

}
