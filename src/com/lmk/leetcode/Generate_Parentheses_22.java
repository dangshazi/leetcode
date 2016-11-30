package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_22 {
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        boolean[] flags = new boolean[1000000];
        List<StringBuffer> matrix = new ArrayList<StringBuffer>();
        matrix.add(new StringBuffer(""));
        List<StringBuffer> matrixBak = new ArrayList<StringBuffer>();
        List<StringBuffer> temp = null;
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < matrix.size(); j++) {
				StringBuffer origin = matrix.get(j);
				for (int k = 0; k < origin.length()+1; k++) {
					StringBuffer change = new StringBuffer(origin);
					change.insert(k, "01");
					int intValue = convertStringToBinary(change);
					if(! flags[intValue]){
//						System.out.print(intValue + " ");
						matrixBak.add(change);
						flags[intValue]=true;
					}
				}
			}
			temp = matrix;
			matrix = matrixBak;
			matrixBak = temp;
			matrixBak.clear();
		}
        
        for (int i = 0; i < matrix.size(); i++) {
        	StringBuffer binaryString = matrix.get(i);
        	StringBuffer quatoString = new StringBuffer();
        	for (int j = 0; j < binaryString.length(); j++) {
				if( binaryString.charAt(j) == '0'){
					quatoString.append('(');
				}else {
					quatoString.append(')');
				}
			}
        	result.add(quatoString.toString());
//			System.out.println(matrix.get(i).toString());
//        	System.out.println(quatoString.toString());
		}
        
        return result;
    }

	private int convertStringToBinary(StringBuffer change) {
		int result = Integer.parseInt(change.toString(), 2);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generate_Parentheses_22 test = new Generate_Parentheses_22();
		test.generateParenthesis(3);
	}

}
