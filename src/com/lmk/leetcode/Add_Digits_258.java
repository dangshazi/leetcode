package com.lmk.leetcode;

public class Add_Digits_258 {
	public int addDigits(int num) {
		if (num == 0){
			return 0;
		}
		
		if (num % 9 == 0){
			return 9;
		}
        return num % 9;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add_Digits_258 test = new Add_Digits_258();
		System.out.println(test.addDigits(108));
	}

}
