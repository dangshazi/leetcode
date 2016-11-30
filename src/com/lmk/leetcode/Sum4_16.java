package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4_16 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       Arrays.sort(nums);
//       for (int i = 0; i < nums.length; i++) {
//    	   System.out.print(nums[i]+" ");
//       }
//       System.out.println();
       
       for (int i = 0; i < nums.length-3; i++) {
    	   for (int j = i+1; j < nums.length-2; j++) {
    		   int head = j+1,tail = nums.length-1;
    		   int sum ;
    		   while (head < tail){
    			   sum = nums[i]+nums[j]+nums[head]+nums[tail];
    			   if (sum == target){
    				   List<Integer> item = new ArrayList<Integer>();
    				   item.add(nums[i]);item.add(nums[j]);item.add(nums[head]);item.add(nums[tail]);
    				   result.add(item);
    				   head++;
    				   tail--;
    			   }else{
    				   if (sum <target){
    					   head ++;
    				   }else{
    					   tail --;
    				   }
    			   }
    		   }
		}
       }
       for (int i = 0; i < result.size()-1; i++) {
    	   for (int j = result.size()-1; j >= i+1 ; j--) {
    		   if(result.get(i).equals(result.get(j))){
    			   result.remove(j);
    		   }
		}
       }
       return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum4_16 test = new Sum4_16();
		
		int[]  nums = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
		List<List<Integer>> fourSum =  test.fourSum(nums, 0);
		test.printResult(fourSum);

	}

	private void printResult(List<List<Integer>> fourSum) {
		// TODO Auto-generated method stub
		int k =0;
		for (int i = 0; i < fourSum.size(); i++) {
			for (int j = 0; j <fourSum.get(i).size(); j++) {
				k ++;
				System.out.print(fourSum.get(i).get(j)+" ");
			}
			System.out.println("");
		}
		System.out.println(k);
	}
}
