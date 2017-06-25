package com.lmk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class AlibabaTest {
	public  boolean  judgeArray(int[] array) {
       if (array == null || array.length < 3) {
            return false;
        }
        int length = array.length;    
        if (length == 3) {
            return true;
        }
        Map<Integer, Integer> mapsum = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapi = new HashMap<Integer, Integer>();
        boolean flag = false;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += array[i];
            mapsum.put(sum, i);
            mapi.put(i, sum);
        }
 
        for (int j = 1; j < length; j++) {
            try {
                int increase = mapi.get(j - 1);
                int k = mapsum.get(mapi.get(j) + increase) + 1;
                int m = mapsum.get(mapi.get(k) + increase) + 1;
                int n = mapsum.get(mapi.get(m) + increase) + 1;
                if (n == length) {
                    flag = true;
                    System.out.println(increase+"--"+k+"--"+m+"--"+n);
                    break;
                }
            } catch (Exception e) {
            	System.out.println("exception");
                continue;
            }
 
        }
 
        return flag;
    }
	
	public static void main(String[] args) {
		AlibabaTest a = new AlibabaTest();
		int[] input = {2,5,1,1,1,1,4,3,7,5,7};
		System.out.println(a.judgeArray(input));
	}
}
