package com.lmk.leetcode;

public class Reverse_Integer_7 {
	public int reverse(int x) {
        int result = 0;
        boolean flag = false;
        if (x == 0 || x == Integer.MIN_VALUE){
            return 0;
        }
        
        if (x < 0){
            x = -1 * x;
            flag = true;
        }
        StringBuffer s = new StringBuffer(x+"");
        s = s.reverse();
        if(s.length() == 10 && s.toString().compareTo(Integer.MAX_VALUE+"") > 0){
        	return 0;
        }
        result = Integer.parseInt(s.toString().trim());
        
        return flag ? -result : result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse_Integer_7 test = new Reverse_Integer_7();
		System.out.println(test.reverse(-2147483));
//		Integer.parseInt("9646324351");
//		System.out.print(-1 * 2147483647);
	}

}
