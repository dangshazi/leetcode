package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Largest_Rectangle_in_Histogram_84 {
	public int largestRectangleArea(int[] heights) {
	    int result = 0;
	    List<Integer> list = new ArrayList<Integer>();
	    for (int i = 0; i < heights.length; i++) {
			list.add(heights[i]);
		}
	    list.add(0);
	    Stack<Integer> stack = new Stack<Integer>();
	    for (int i = 0; i < list.size(); i++) {
			if(stack.isEmpty() || list.get(i)>= list.get(stack.peek())){
				stack.push(i);
			}else {
				int temp = list.get(i);
				while(!stack.isEmpty() && (list.get(stack.peek())>temp)){
					int top = stack.pop();
					int leftArea;
					if (!stack.isEmpty()){
						leftArea = (top - stack.peek() -1)*list.get(top);
					}else{
						leftArea = (top)*list.get(top);
					}
					int rigthArea = (i - top)*list.get(top);
					result = Math.max(leftArea + rigthArea, result);
				}
				stack.push(i);
			}
		}
	    return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Largest_Rectangle_in_Histogram_84 test = new Largest_Rectangle_in_Histogram_84();
		int[] heights = {2,1,5,6,2,3};
		test.largestRectangleArea(heights);
		System.out.println(test.largestRectangleArea(heights));
		
	}

}
