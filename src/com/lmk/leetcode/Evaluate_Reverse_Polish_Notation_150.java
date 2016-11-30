package com.lmk.leetcode;

import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation_150 {

	public int evalRPN(String[] tokens) {
        int result;
        Stack<Integer> stack = new Stack<Integer>();
        Set<String> operator = new HashSet<String>();
        operator.add( "+");operator.add( "-");
        operator.add( "*");operator.add( "/");
        
        int x;
        int y;
        String op;
        
        for (int i = 0; i < tokens.length; i++) {
			if (!operator.contains(tokens[i])){
				stack.push(new Integer(tokens[i]));
			}else{
//				try {
					x = stack.pop();
					y = stack.pop();
//				} catch (EmptyStackException e) {
//					throw new IllegalArgumentException(e);
//				}
				op = tokens[i];
				if ("+".equals(op)){
					stack.push(x + y);
				}else if ("-".equals(op)) {
					stack.push(y - x);
				}else if ("*".equals(op)) {
					stack.push(x * y);
				}else if ("/".equals(op)) {
					stack.push(y / x);
				}
//				else {
//					throw new IllegalArgumentException();
//				}
			}
		}
        result = stack.pop();
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Evaluate_Reverse_Polish_Notation_150 test = new Evaluate_Reverse_Polish_Notation_150();
		
		String[] tokens = {"18"};
		System.out.println(test.evalRPN(tokens));
	}

}
