package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Substring_with_Concatenation_of_All_Words_30 {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int[] flags = new int[s.length()];
        //添加标识
        int flag =1;
        for (int i = 0; i < words.length; i++) {
        	int start = 0;
        	int index;
			while((index = s.indexOf(words[i],start)) > -1){
				flags[index] = flag;
				start = index +1;
			}
			flag = flag << 1;
		}
        
        
        
        int wordLength = words[0].length();
        int allWordsLength = words.length* words[0].length();
        
        for (int i = 0; i < s.length() - allWordsLength; i++) {
        	int sum = (1 << words.length)-1;//二进制的“1111111111111”
			for (int j = 0; j < words.length; j++) {
				int index = i+j*wordLength;
				if (flags[index] < 1){
					break;
				}else {
					sum = sum  ^ flags[index];
				}
			}
			if (sum == 0){
				result.add(i);
			}
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Substring_with_Concatenation_of_All_Words_30 test = new Substring_with_Concatenation_of_All_Words_30();
		String s = "barfoothbarfooefoobarfoobarman";
		String[] words = {"foo", "bar"};
		
		String out = test.findSubstring(s, words).toString();
		System.out.println(out);
	}
	private void print(List<Integer> findSubstring) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
}
