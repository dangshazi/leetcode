package com.lmk.leetcode;

public class Roman_to_Integer_13 {

	public int romanToInt(String s) {
        int result = 0;
        String[][] trix= 
    		{{"0","I","II","III","IV","V","VI","VII","VIII","IX"},
    				{"0","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
    				{"0","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
    				{"0","M","MM","MMM","@","@","@","@","@","@"}};
        while (s.length()>0){
        	boolean findFlag = false;
        	
        	for (int i = 3; i >-1&& !findFlag; i--) {
				for (int j = 9; j >-1 && trix[i][j].length()>0; j--) {
					if(s.startsWith(trix[i][j])){
						result += j * Math.pow(10, i);
						s = s.substring(trix[i][j].length());
						findFlag = true;
						break;
					}
				}
			}
        }
        
        return result;
    }
	public static void main(String[] args) {
		
		String s = "DCXXI";
		Roman_to_Integer_13 test = new Roman_to_Integer_13();
		System.out.println(test.romanToInt(s));
//		s = s.substring(6);
//		System.out.println(s.length());
	}

}
