package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Substring_with_Concatenation_of_All_Words_30_Method2 {
	int wordLength;
	int length;
	int[] random;
	String[] words;
	List<Integer> wordsHash;
	public List<Integer> findSubstring(String s, String[] words) {
		this.words = words;
		
        List<Integer> result = new ArrayList<Integer>();
        wordsHash = new ArrayList<Integer>();
        
        length = words.length;
        wordLength = words[0].length();
        int allWordsLength = words.length* words[0].length();
        StringBuffer sBuffer = new StringBuffer();
        random = new int[length];
        for (int i = 0; i < words.length; i++) {
        	sBuffer.append(words[i]);
        	random[i] = (int) (1+Math.random()*10);
        	wordsHash.add(wordHash(words[i]));
        	
		}
        	
        List<Integer> objectHashValue = hash(sBuffer.toString());
        for (int i = 0; i < s.length() - allWordsLength +1; i++) {
        	List<Integer> tempHashValue = hash(s.substring(i, i+allWordsLength));
        	//满足该条件的只是有可能解
        	if (objectHashValue.equals(tempHashValue)){
        		if (isOk(new StringBuffer(s.substring(i, i+allWordsLength)))){
        			result.add(i);
        		}
        	}
		}
        return result;
    }
	private Integer wordHash(String string) {
		int sum =0;
		for (int i = 0; i < string.length(); i++) {
			sum += (i+1)* string.charAt(i);
		}
		return sum;
	}
	private boolean isOk(StringBuffer substring) {
//		for (int i = 0; i < length; i++) {
//			int index = substring.indexOf(words[i]);
//			if (index <0){
//				return false;
//			}
//			substring.delete(index, index + wordLength);
//		}
//		return true;
		/**上面的判重方法是错误
		 * Input:
			"ababaab"
			["ab","ba","ba"]
			Output:
			[]
			Expected:
			[1]
		 * 
		 */
		List<Integer> tempHash = new ArrayList<Integer>();
		for (int i = 0; i < length; i++) {
			tempHash.add(wordHash(substring.substring(i*wordLength, (i+1)*wordLength)));
		}
		if (wordsHash.containsAll(tempHash)){
			return true;
		}
		return false;
		
	}
	private List<Integer> hash(String string) {
		List<Integer> hashList = new ArrayList<Integer>();
		for (int i = 0; i < wordLength; i++) {
			int sum = 0;
			for (int j = 0; j < length; j++) {
				int index = j*wordLength+i;
//				sum += Math.pow(string.charAt(index),2) ;//超时
				sum += string.charAt(index) ;
				/**\
				 * 对样例
				 * "abaababbaba"
					["ab","ba","ab","ba"]
					Output:
					[0,1,2,3]
					Expected:
					[1,3]     因为 abab = aabb
				 */
//				sum += string.charAt(index) * random[j] ;//按顺序来给每个权值也不可以
				/**
				 * 因为 "ab","ba","ab","ba" 只能找到 abbaabba  ,相当于对 words 排了序
				 */
			}
			hashList.add(sum);
		}
		return hashList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Substring_with_Concatenation_of_All_Words_30_Method2 test = new Substring_with_Concatenation_of_All_Words_30_Method2();
		
//		String s = "abaababbaba";
//		String[] words = {"ab","ba","ab","ba"};
		
		String s = "ababaab";
		String[] words = {"ab","ba","ba"};
		
		String out = test.findSubstring(s, words).toString();
		System.out.println(out);
	}

}
