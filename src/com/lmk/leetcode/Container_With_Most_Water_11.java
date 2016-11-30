package com.lmk.leetcode;

public class Container_With_Most_Water_11 {
	public int maxArea(int[] height) {
		if(height.length < 2){
			return 0;
		}
		
        int result = 0;
        int head =0, tail = height.length-1;
        int area =0;
        while(head < tail){
        	area = (tail -head )* Math.min(height[head], height[tail]);
        	if(area > result){
        		result = area;
        	}
        	if (height[head]>height[tail]){
        		tail--;
        	}else{
        		head ++;
        	}
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container_With_Most_Water_11 test = new Container_With_Most_Water_11();
		
		int[] height ={2,1,2};
		System.out.println(test.maxArea(height));
	}

}
