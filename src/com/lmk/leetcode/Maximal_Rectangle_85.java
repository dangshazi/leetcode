package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Maximal_Rectangle_85 {
	public int largestRectangleArea(List<Integer> list) {
	    int result = 0;
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
	public int maximalRectangle(char[][] matrix) {
        int result = 0;
        if (matrix == null || matrix.length <1){
        	return result;
        }
        int column = matrix.length;
        int row = matrix[0].length;
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < row; i++) {
			list.add(0);
		}
        for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				int top = i;
				int height =0;
				while (top >= 0 && matrix[top][j] == '1'){
					height++;
					top --;
				}
				list.set(j, height);
			}
			result = Math.max(largestRectangleArea(list), result);
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximal_Rectangle_85 test = new Maximal_Rectangle_85();
		char[][] matrix = {{'0','1','0'},
							{'0','1','0'},
							{'0','0','1'}};
		System.out.println(test.maximalRectangle(matrix));
	}

}
