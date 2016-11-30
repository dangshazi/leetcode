package com.lmk.leetcode;

import java.util.Stack;

public class Valid_Parentheses_20 {
	public boolean isValid(String s) {
        boolean result = true;
        Stack<Character> stack = new Stack<Character>();
        if(s == null || s.length()<1){
        	return result;
        }
        
        for (int i = 0; i < s.length(); i++) {
        	Character c = s.charAt(i);
        	
        	if(c== '('||c=='{'||c=='['){
        		stack.push(c);
        		continue;
        	}
        	
        	if(c== ')'||c=='}'||c==']'){
        		if (stack.isEmpty() || !duiying(stack.peek(),c)){
        			result = false;
        			break;
        		}else{
        			stack.pop();
        		}
        	}
		}
        if (!stack.isEmpty()){
        	result =false;
        }
        return result;
    }
	private boolean duiying(char peek, char c) {
		if(c-peek <3 && c-peek >0){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Valid_Parentheses_20 test = new Valid_Parentheses_20();
		String s = "{}[(){}]";
		System.out.println(test.isValid(s));
	}

}
