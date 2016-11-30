package com.lmk.leetcode;

import java.math.BigInteger;

public class Divide_Two_Integers_29 {
	public int divide(int dividend, int divisor) {
        BigInteger bigDividend = new BigInteger(dividend+"");
        BigInteger bigDivisor = new BigInteger(divisor+"");
        
        return bigDividend.divide(bigDivisor).intValue();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Divide_Two_Integers_29 test = new Divide_Two_Integers_29();
		System.out.println(test.divide(5, 2));
	}

}
