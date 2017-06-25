package com.lmk.leetcode;

/**
 * time limit exceeds
 * @author lmk
 *
 */
public class Jump_game_55 {

	 public boolean canJump(int[] nums) {
		 boolean result = true;
	        boolean[] flags = new boolean[nums.length];
	        int[] jumpNum = new int[nums.length];
	        if (nums == null || nums.length < 1){
	            return false;
	        }
	        jumpNum[0] = 0;
	        flags[0] = true;
	        for (int i =0;i<nums.length;i++){
	            if (flags[i]){
	                for (int j = 0;j<=nums[i];j++){
	                    if (i+j >=nums.length){
	                        result = true;
	                        return result;
	                    }else{
	                        flags[i+j]=true;
	                    }
	                }
	            }else{
	                result = true;
	                break;
	            }
	        }
	        if (flags[nums.length-1]){
	            return true;
	        }else{
	            return false;
	        }
	        
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jump_game_55 a = new Jump_game_55();
		int[] nums = {3,0,8,2,0,0,1};
		System.out.println(a.canJump(nums));
		
				
	}

}
