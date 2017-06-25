package com.lmk.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lmk on 2017/6/25.
 */
public class FirstNotRepeatingChar_35 {
    public int FirstNotRepeatingChar(String str) {

        Map<Character,Integer> pos = new HashMap<Character,Integer>();
        Map<Character,Integer> showNum = new HashMap<Character,Integer>();
        for (int i =0;i<str.length();i++){
            char temp = str.charAt(i);
            if (pos.get(temp) == null){
                pos.put(temp,i);
                showNum.put(temp,1);
            }else{
                showNum.put(temp,showNum.get(temp)+1);
            }

        }
        int min = 100000;
        for (Character c:showNum.keySet()){
            if (showNum.get(c) == 1 && pos.get(c)<min){
                min = pos.get(c);
            }
        }
        return min;
    }

    @Test
    public void test(){
        System.out.println(FirstNotRepeatingChar("sPeYjppjOPHoiYdzlTUufOOzlnSudHuHzbWXzZnyPWrnkFfmQX"));
    }
}
