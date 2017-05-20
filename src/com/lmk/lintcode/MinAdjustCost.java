package com.lmk.lintcode;

import java.util.ArrayList;

/**
 * @author YaoZhidong
 * @version 1.0
 * @created 2017/5/20
 */

public class MinAdjustCost {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<A.size();i++){
            if (A.get(i)>max){max = A.get(i);}
            if (A.get(i)<min){min = A.get(i);}
        }
        int[][] f = new int[A.size()][101];
        for (int i=0;i<A.size();i++){
            for (int j = 1;j<=100;j++){
                f[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i=min;i<=max;i++){
            f[0][i] = Math.abs(i-A.get(0));
        }
        for (int i=1;i<A.size();i++){
            for (int j = min;j<=max;j++){
                int head = j-target>=min?j-target:min;
                int tail = j+target<=max?j+target:max;
                for (int k = head;k<=tail;k++){
                    f[i][j]= Math.min(f[i][j],f[i-1][k]+Math.abs(A.get(i)-j));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i=min;i<=max;i++){
            if (result>f[A.size()-1][i]){
                result=f[A.size()-1][i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        MinAdjustCost tmp = new MinAdjustCost();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);list.add(4);list.add(2);list.add(3);
        System.out.println(tmp.MinAdjustmentCost(list,1));
    }
}