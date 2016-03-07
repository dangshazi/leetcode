package com.lmk.leetcode;

public class Longest_Palindromic_Substring_5 {

	public String longestPalindrome(String s) {
        String objectSubString ="";
        int maxLength=0;
        for(int i = 0;i<s.length();i++){
        	int append = 0;
        	int length =0;
        	String passSubString = null;
        	while((i-append>-1)&&(i+append<s.length())&&(s.charAt(i-append) == s.charAt(i+append))){
        		length++;
        		passSubString = s.substring(i-append,i+append+1);
        		append++;
        	}
        	
        	if((length*2-1) > maxLength){
        		maxLength = length*2-1;
        		objectSubString = passSubString;
        	}
        	
        	append = 0;
        	length =0;
        	passSubString = null;
        	while((i-append>-1)&&(i+append+1<s.length())&&(s.charAt(i-append) == s.charAt(i+append+1))){
        		length++;
        		passSubString = s.substring(i-append,i+append+2);
        		append++;
        	}
        	
        	if((length*2) > maxLength){
        		maxLength = length*2;
        		objectSubString = passSubString;
        	}
        }
        return objectSubString;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abadwatchdeaedhighlevel";
		Longest_Palindromic_Substring_5 test = new Longest_Palindromic_Substring_5();
		
		System.out.println(test.longestPalindrome(s));
		
	}

}
