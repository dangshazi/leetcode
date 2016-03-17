package com.lmk.leetcode;

import java.util.Arrays;

public class Search_for_a_Range_34 {
	public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int index = Arrays.binarySearch(nums, target);
        if( index <0 ){
        	result[0] = -1; result[1]=-1;
        	return result;
        }
        int head = index, tail=index;
        while( head-1 >-1 && nums[head-1] == target){
        	head--;
        }
        while( tail+1<nums.length  &&nums[tail+1] == target){
        	tail++;
        }
        result[0] = head; result[1]=tail;
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search_for_a_Range_34 test = new Search_for_a_Range_34();
		int[] nums = {2,2};
		
		int[] result =test.searchRange(nums, 2);
		System.out.println(result[0]+"-"+result[1]);
		
	}

}
