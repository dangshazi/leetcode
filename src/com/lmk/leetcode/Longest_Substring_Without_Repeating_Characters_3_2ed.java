package com.lmk.leetcode;

public class Longest_Substring_Without_Repeating_Characters_3_2ed {
	public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int head = -1;
        int[] flags = new int[256];
        for(int i =0;i<256;i++){
            flags[i]=-1;
        }
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (flags[c]>head){
                head=flags[c];
            }
            if (max<i-head){
                max = i-head;
            }
            flags[c] = i;
        }
        return max;
    }
	
	public static void main(String[] args) {
		Longest_Substring_Without_Repeating_Characters_3_2ed test = new Longest_Substring_Without_Repeating_Characters_3_2ed();
		String s ="pwwkew";
		System.out.println(test.lengthOfLongestSubstring(s));
	}
}
