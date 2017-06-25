package com.lmk.leetcode;

/**
 * time limit exceeds
 * @author lmk
 *
 */
public class Jump_game_55_2ed {

	 public boolean canJump(int[] nums) {
		 int reachable = 0;
		    for (int i=0; i<nums.length; ++i) {
		        if (i > reachable) return false;
		        reachable = Math.max(reachable, i + nums[i]);
		    }
		    return true;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jump_game_55_2ed a = new Jump_game_55_2ed();
		int[] nums = {3,0,8,2,0,0,1};
		System.out.println(a.canJump(nums));
		
				
	}

}
