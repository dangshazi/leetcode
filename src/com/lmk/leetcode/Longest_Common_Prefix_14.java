package com.lmk.leetcode;

public class Longest_Common_Prefix_14 {
	
	public String longestCommonPrefix(String[] strs) {
        String result ="";
        if (strs == null || strs.length <1){
        	return "";
        }
        int maxLength = strs[0].length();
        int maxIndex = 0;
        for (int i = 0; i < strs.length; i++) {
			if (strs[i] != null && strs[i].length()>0){
				if (strs[i].length()>maxLength){
					maxLength = strs[i].length();
					maxIndex = i;
				}
			}else{
				return "";
			}
		}
        
        
        boolean end = false;
        int index = -1;
        while (!end){
        	index ++;
        	if (index >= maxLength){
        		break;
        	}
        	char x = strs[maxIndex].charAt(index);
        	for (int i = 0; i < strs.length; i++) {
				if (strs[i] == null || strs[i].length()<= index || x != strs[i].charAt(index)){
					end = true;
					break;
				}
			}
        }
        
        result = strs[maxIndex].substring(0, index);
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"a"};
		
		Longest_Common_Prefix_14 test = new Longest_Common_Prefix_14();
		System.out.println(test.longestCommonPrefix(strs));
	}

}
