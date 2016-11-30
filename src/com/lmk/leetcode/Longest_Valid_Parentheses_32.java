package com.lmk.leetcode;

public class Longest_Valid_Parentheses_32 {
	int[][] bracketNum;
	public int longestValidParentheses(String s) {
        int result = 0;
        String resultStr = "";
        int resultI;
        int resultJ;
        
        int length = s.length();
        if (s == null || s.length() < 2){
        	return result;
        }
        bracketNum = new int[length][length];//记录i-j左括号的的数量 包括 i，j
        for (int i = 0; i < length; i++) {
        	 if (isLeftBracket(s.charAt(i))){
             	bracketNum[i][i] = 1;
             }else {
             	bracketNum[i][i] = 0;
     		}
		}
       int maxVaildParenthesesLength = Integer.MIN_VALUE;
       
        for (int i = 0; i < length; i++) {
			for (int j = i+1; j < length; j++) {
				if (isLeftBracket(s.charAt(j))){
					bracketNum[i][j] = bracketNum[i][j-1] + 1;
				}else {
					bracketNum[i][j] = bracketNum[i][j-1];
				}
				
				if (leftEqualsRight(bracketNum[i][j],i,j)){
					if (isValid(i,j)){
						if (maxVaildParenthesesLength < j-i+1){
							maxVaildParenthesesLength = j-i+1;
							resultI = i;
							resultJ = j;
							resultStr = s.substring(i, j+1);
						}
					}
				}
			}
		}
        
        result = maxVaildParenthesesLength;
        System.out.println(resultStr);
        return result;
    }
	
	//检查 s的子字符串（head -tail）是否有效
	private boolean isValid(int head, int tail) {
		if (bracketNum[head][head]<0){
			return false;
		}
		for (int i = head; i < tail; i++) {
			if (!leftBiggerOrEqualsRight(head,i)){
				return false;
			}
		}
		return true;
	}
	
	//检查 s的子字符串（i -j) 中 左括号的个数是否大于等于 右括号的个数
	private boolean leftBiggerOrEqualsRight(int i, int j) {
		int leftNum = bracketNum[i][j];
		int rigthNum = j-i +1 -leftNum;
		if (leftNum >= rigthNum){
			return true;
		}
		return false;
	}
	//检查 s的子字符串（i -j) 中 左括号的个数是否等于 右括号的个数
	private boolean leftEqualsRight(int leftNum,int i, int j) {
		int rigthNum = j-i +1 -leftNum;
		if (leftNum == rigthNum){
			return true;
		}
		return false;
	}
	
	private boolean isLeftBracket(char c) {
		if (c == '('){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_Valid_Parentheses_32 test = new Longest_Valid_Parentheses_32();
		String s = ")(()(()))()";
		System.out.println(test.longestValidParentheses(s));
	}

}
