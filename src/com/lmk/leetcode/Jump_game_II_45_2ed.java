package com.lmk.leetcode;

/**
 * time limit exceeds
 * @author lmk
 *
 */
public class Jump_game_II_45_2ed {

	 public int canJump(int[] nums) {
		 	int reachable = 0;
		 	int[] jumpNum = new int[nums.length];
		 	if (nums == null || nums.length < 1){
	            return 0;
	        }
		 	jumpNum[0] = 0;
		    for (int i=0; i<nums.length; ++i) {
		        if (i > reachable) return 0;
		        if (i + nums[i]>reachable){
		        	reachable = i + nums[i];
		        	
		        }
		        
		    }
//		    return true;
		    return 2;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jump_game_II_45_2ed a = new Jump_game_II_45_2ed();
		int[] nums = {3,0,8,2,0,0,1};
		System.out.println(a.canJump(nums));
		
				
	}

}
