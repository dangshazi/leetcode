package com.lmk.leetcode;

import java.util.Stack;

public class Longest_Valid_Parentheses_32_Method2 {
	int[][] bracketNum;
	public int longestValidParentheses(String s) {
        int result = 0;
        int[] flags = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
			if (isLeftBracket(s.charAt(i))){
				stack.push(i);
			}else{
				if(!stack.isEmpty()){
					flags[i] = 1;
					flags[stack.pop()] = 1;
				}
			}
		}
        int temp =0;
        for (int i = 0; i < s.length(); i++) {
        	
			if (flags[i] == 1){
				temp++;
			}else{
				if( temp > result){
					result = temp;
				}
				temp =0;
			}
		}
        if( temp > result){
			result = temp;
		}
        return result;
    }
	
	private boolean isLeftBracket(char c) {
		if (c == '('){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_Valid_Parentheses_32_Method2 test = new Longest_Valid_Parentheses_32_Method2();
		String s = ")(()(()))()";
		System.out.println(test.longestValidParentheses(s));
	}

}
