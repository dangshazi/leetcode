package com.lmk.leetcode;

import java.util.Arrays;

public class Search_in_Rotated_Sorted_Array_33 {
	public int search(int[] nums, int target) {
        int result;
        int pivot = findPivot(nums,0,nums.length-1);
        if (pivot == 0) {
        	result = Arrays.binarySearch(nums, target);
        	if (result <-1){
            	return -1;
            }else{
            	return result;
            }
        }
        result = Arrays.binarySearch(nums, 0, pivot, target);
        int temp = Arrays.binarySearch(nums, pivot, nums.length, target);
        if (result < temp ){
        	result = temp;
        }
        if (result <-1){
        	return -1;
        }
        return result;
    }
	private int findPivot(int[] nums, int left, int right) {
		int mid = (left + right)/2;
		
		if (left == mid){
			if (nums[left]<nums[right]){
				return left;
			}else {
				return right;
			}
			
		}
		
		if(nums[mid]< nums[right] && nums[mid]<nums[left]){
			if (nums[mid] < nums[mid -1]){
				return findPivot(nums, mid, right);
			}else{
				return findPivot(nums, left, mid -1);
			}
		}
		if(nums[mid]>nums[left] && nums[mid]>nums[right]){
				return findPivot(nums, mid+1, right);
		}
		return left;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search_in_Rotated_Sorted_Array_33 test = new Search_in_Rotated_Sorted_Array_33();
		int[] nums = {1};
		
		System.out.println(test.search(nums, 2));
		
		
	}

}
