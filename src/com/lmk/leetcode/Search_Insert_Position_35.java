package com.lmk.leetcode;

import java.util.Arrays;

public class Search_Insert_Position_35 {
	 public int searchInsert(int[] nums, int target) {
	        int result;
	        int index;
	        index = Arrays.binarySearch(nums, target);
	        if(index >-1){
	        	result = index;
	        }else{
	        	result = -1*(index+1);
	        }
	        
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search_Insert_Position_35 test = new Search_Insert_Position_35();
		int[] nums = {1,3,5,6};
		System.out.println(test.searchInsert(nums, 0));
	}

}
