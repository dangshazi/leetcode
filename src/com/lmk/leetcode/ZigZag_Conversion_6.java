package com.lmk.leetcode;

public class ZigZag_Conversion_6 {
	public String convert(String s, int numRows) {
		if(s == null || s.length()<1){
			return "";
		}
		if (numRows == 1){
			return s;
		}
		StringBuffer sBuffer = new StringBuffer(s);
		
        StringBuffer result = new StringBuffer();
        int loopNum = s.length()/(2*numRows-2)+1;
        int columnNum = loopNum*2;
        
        for (int i = 1;i<= loopNum;i++){
        	if ((i*2*numRows-numRows)<=sBuffer.length()){
        		sBuffer.insert(i*2*numRows-numRows, '@');
        	}
        	if ((i*2*numRows-1)<=sBuffer.length()){
        		sBuffer.insert(i*2*numRows-1, '@');
        	}
        }
        System.out.println(sBuffer.toString());
        char[][] square = new char[columnNum][numRows];
        for(int i = 0;i<numRows;i++){
        	for(int j =0;j<columnNum;j++){
        		square[j][i] = '@';
        	}
        }
        int index = 0;
        
        for(int i = 0;i<columnNum;i++){
        	for(int j =0;j<numRows;j++){
        		if(index<sBuffer.length()){
        			if((i%2 == 0)||(i == 0)){
        				square[i][j] = sBuffer.charAt(index);
        			}
        			else {
        				square[i][numRows-j-1] = sBuffer.charAt(index);
					}
        			
        			
        		}
        		index++;
        	}
        }
        for(int i = 0;i<columnNum;i++){
        	for(int j =0;j<numRows;j++){
        		System.out.print(square[i][j]+ " ");
        	}
        	System.out.println();
        }
        
        for(int i = 0;i<numRows;i++){
        	for(int j =0;j<columnNum;j++){
        		if ((square[j][i] != '@')){
        			result.append(square[j][i]);
        		}
        	}
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		String s = "A";
		
		ZigZag_Conversion_6 test = new ZigZag_Conversion_6();
		
		System.out.println(test.convert(s, 1));
	}
}
