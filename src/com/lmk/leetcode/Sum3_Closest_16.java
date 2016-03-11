package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sum3_Closest_16 {
	
	List<Struct> sums = new ArrayList<Struct>();
	int[] nums ;
	int target;
	public int threeSumClosest(int[] nums, int target) {
		this.nums = nums;
		this.target = target;
		
		
		int result =0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j){
					sums.add(new Struct(i,j,nums[i]+nums[j]));
				}
				
			}
		}
		
		Collections.sort(sums);
		
		List<Integer> objs = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			objs.add(target - nums[i]);
		}
		int gap = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int index = Collections.binarySearch(sums,new Struct(objs.get(i)));
			Struct closedStruct = new Struct();
			if (index == sums.size()){
				closedStruct = getTheClosedSum(objs.get(i),0,i);
			}
			if (index >=0){
				if (i != sums.get(index).i && i != sums.get(index).j){
					if (Math.abs(sums.get(index).sum + nums[i]-target)<gap){
						gap = Math.abs(sums.get(index).sum + nums[i]-target);
						result = sums.get(index).sum + nums[i];
					}
				}else{
					closedStruct = getTheClosedSum(objs.get(i),index,i);
				}
				
			}else{
				closedStruct = getTheClosedSum(objs.get(i),-1*(index+1),i);
			}
			result = closedStruct.sum + nums[i];
			
		}
		return result;
    }
	private Struct getTheClosedSum(Integer obj, int index,int i) {
		// TODO Auto-generated method stub
		Struct sum = sums.get(index);
		
		if ( sum.sum + nums[i] == target){
			if (i != sums.get(index).i && i != sums.get(index).j){
				return sum;
			}
		}else{
			boolean finded = false;
			while (!finded){
				
			}
		}
		
		
		
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Struct implements Comparable<Struct>{
	public int i;
	public int j;
	public int sum;
	public Struct(int sum) {
		// TODO Auto-generated constructor stub\
		this.sum = sum;
	}
	public Struct(int i,int j, int sum) {
		// TODO Auto-generated constructor stub
		this.i = i;
		this.j = j;
		this.sum = sum;
	}
	public Struct() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Struct o) {
		// TODO Auto-generated method stub
		return sum - o.sum;
	}
	
	
}
