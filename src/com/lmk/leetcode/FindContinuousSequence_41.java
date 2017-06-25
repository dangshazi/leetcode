package com.lmk.leetcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by lmk on 2017/6/25.
 */
public class FindContinuousSequence_41 {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > results = new ArrayList<ArrayList<Integer> >();
        int[] sums = new int[sum+1];
        sums[0]=0;
        for (int i=1;i<=sum;i++){
            sums[i] =sums[i-1]+i;
        }
        for (int i = 1;i<=sum;i++){
            for (int j =i;j<=sum;j++){
                if (getSum(i,j,sums) == sum){
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    results.add(generateResult(result,i,j));
                }
            }
        }
        return results;
    }

    private int getSum(int i,int j,int[] sums){
        return sums[j]-sums[i-1];
    }

    private ArrayList<Integer> generateResult(ArrayList<Integer> result, int i, int j){
        for(int k = i;k<=j;k++){
            result.add(k);
        }
        return result;
    }

    @Test
    public void test(){
//        FindContinuousSequence(1);
        System.out.println("lmk".re);
    }

}
