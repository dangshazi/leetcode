package com.lmk.leetcode;

import java.util.Arrays;

public class Next_Permutation_31 {
	public void nextPermutation(int[] nums) {
        int minBiggerIndex = nums.length;
        boolean findFirstBigger = false;
        int changeOrderNumberIndex = nums.length -2;
        while(! findFirstBigger && changeOrderNumberIndex >=0){
        	int tail = changeOrderNumberIndex +1;
        	int min = Integer.MAX_VALUE;
        	while(tail < nums.length){
        		if (nums[tail]>nums[changeOrderNumberIndex] && min > nums[tail]){
        			min = nums[tail];
        			minBiggerIndex = tail;
        			findFirstBigger = true;
        		}
        		tail ++;
        	}
        	changeOrderNumberIndex--;
        }
        changeOrderNumberIndex++;
        System.out.println("changeOrderNumberIndex : "+changeOrderNumberIndex);
        System.out.println("firstSmallerIndex : "+minBiggerIndex);
        //特殊情况，最大的时候
        if(!findFirstBigger){
        	Arrays.sort(nums);
        	return;
        }
        //一般情况
        //交换changeOrderNumberIndex    firstSmallerIndex
        
        exchange(nums, changeOrderNumberIndex, minBiggerIndex);
        sort(nums,changeOrderNumberIndex+1,nums.length-1);
        
    }
	private void sort(int[] nums, int left,int right) {
		int dp;
		if(left < right){
			dp = partion(nums,left,right);
			sort(nums,left,dp-1);
			sort(nums,dp+1,right);
		}
		
	}
	private int partion(int[] nums, int left, int right) {
		int x = nums[right];
		int i =left-1;
		for (int j = left; j < right; j++) {
			if(nums[j]<x){
				i++;
				exchange(nums,i,j);
			}
		}
		exchange(nums, right, i+1);
		return i+1;
	}
	private void exchange(int[] nums,int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Next_Permutation_31 test = new Next_Permutation_31();
		int[] nums = {1};
		test.nextPermutation(nums);
		
		test.print(nums);
	}
	private  void print(int[] nums) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+ " ");
		}
	}

}
