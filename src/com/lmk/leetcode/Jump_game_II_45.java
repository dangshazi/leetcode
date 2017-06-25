package com.lmk.leetcode;

/**
 * time limit exceeds
 * @author lmk
 *
 */
public class Jump_game_II_45 {

	 public int canJump(int[] nums) {
		 	boolean result = true;
	        boolean[] flags = new boolean[nums.length];
	        int[] jumpNum = new int[nums.length];
	        if (nums == null || nums.length < 1){
	            return 0;
	        }
	        jumpNum[0] = 0;
	        flags[0] = true;
	        for (int i =0;i<nums.length;i++){
	            if (flags[i]){
	                for (int j = 1;j<=nums[i];j++){
	                    if (i+j >=nums.length){
	                        result = true;
//	                        return result;
	                        break;
	                    }else{
	                    	if (!flags[i+j]){
	                    		jumpNum[i+j]=nums.length;
	                    	}
	                        flags[i+j]=true;
	                        jumpNum[i+j] = Math.min(jumpNum[i]+1, jumpNum[i+j]);
	                    }
	                }
	            }else{
	                result = true;
	                break;
	            }
	        }
	        if (flags[nums.length-1]){
	            return jumpNum[nums.length-1];
	        }else{
	            return 0;
	        }
	        
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jump_game_II_45 a = new Jump_game_II_45();
		int[] nums = {2,3,1,1,4};
		System.out.println(a.canJump(nums));
		
				
	}

}
