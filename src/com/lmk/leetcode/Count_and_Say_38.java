package com.lmk.leetcode;

public class Count_and_Say_38 {
	public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
        	char c = result.charAt(0);
        	int index = 1;
        	int num = 1;
        	StringBuffer temp = new StringBuffer();
        	while (index < result.length()){
        		if (result.charAt(index) != c){
        			temp.append(num+""+c);
        			num = 1;
        			c =  result.charAt(index) ;
        			index ++;
        		}else {
					num ++;
					index ++;
				}
        	}
        	temp.append(num+""+c);
        	
        	result = temp.toString();
		}
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Count_and_Say_38 test = new Count_and_Say_38();
		System.out.println(test.countAndSay(5));
	}

}
