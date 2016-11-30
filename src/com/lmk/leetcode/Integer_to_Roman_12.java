package com.lmk.leetcode;

public class Integer_to_Roman_12 {

	public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        
        String[][] trix= 
        		{{"0","I","II","III","IV","V","VI","VII","VIII","IX"},
        				{"0","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        				{"0","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        				{"0","M","MM","MMM"}};
        int x = num/1000;
        if (x != 0){
        	 result.append(trix[3][x]);
        }
       
        num = num % 1000;
        x = num/100;
        if (x != 0){
        	result.append(trix[2][x]);
        }
        num = num % 100;
        x = num/10;
        if (x != 0){
        	result.append(trix[1][x]);
        }
        num = num % 10;
        x = num;
        if (x != 0){
        	result.append(trix[0][num]);
        }
        
        return result.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer_to_Roman_12 test = new Integer_to_Roman_12();
		
		System.out.println(test.intToRoman(1010));
	}

}
