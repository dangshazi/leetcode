package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sum3_15 {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> orderedNums = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
			orderedNums.add(nums[i]);
		}
        Collections.sort(orderedNums);
        int old1 = Integer.MIN_VALUE;
        int old2= Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < orderedNums.size()-2; i++) {
        	if (old1 != orderedNums.get(i)){
        		old1 = orderedNums.get(i);
        	}else {
				continue;
			}
        	old2= Integer.MIN_VALUE;
			for (int j = i+1; j < orderedNums.size()-1; j++) {
				//非重复的 a1,a2的话
				if (old2 != orderedNums.get(j)){
					old2 = orderedNums.get(j);
					//如果找到，则说明可以组成triples
					index = Collections.binarySearch(orderedNums.subList(j+1, orderedNums.size()), -1*(old1+old2));
					if (index >= 0){
						List<Integer> triples = new ArrayList<Integer>();
						triples.add(old1);triples.add(old2);triples.add(orderedNums.get(index+j+1));
						result.add(triples);
					}
					
				}else {
					continue;
				}
			}
		}
       
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum3_15 test = new Sum3_15();
		int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		
		test.printResult(test.threeSum(nums));
	}
	private void printResult(List<List<Integer>> threeSum) {
		// TODO Auto-generated method stub
		for (int i = 0; i < threeSum.size(); i++) {
			for (int j = 0; j < threeSum.get(i).size(); j++) {
				System.out.print(threeSum.get(i).get(j)+" ");
			}
			System.out.println("");
		}
	}
	

}
