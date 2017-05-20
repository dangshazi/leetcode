package com.lmk.offer;

/**
 * @author YaoZhidong
 * @version 1.0
 * @created 2017/5/13
 */

import java.util.ArrayList;
public class Combination {
    public ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> tmpCombination = new  ArrayList<Integer>();
    public int m;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n<k){
            return null;
        }
        m = k;
        addCombination(n,k,1);
        return result;
    }

    public void addCombination(int n,int k,int index){
        if (n-index<k){
            ArrayList<Integer> newTmpCombination = (ArrayList<Integer>) tmpCombination.clone();
            for (int i = index;i<=n;i++){
                newTmpCombination.add(i);
            }
            result.add(newTmpCombination);
            return;
        }

        if (tmpCombination.size()<m){
            tmpCombination.add(index);
            addCombination(n,k-1,index+1);
            tmpCombination.remove(tmpCombination.size()-1);
        }
        addCombination(n,k,index+1);

        return;
    }

    public static  void main(String[] args){
        Combination c = new Combination();
        System.out.println(c.combine(4,3).toString());

    }
}