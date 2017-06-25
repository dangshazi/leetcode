package com.lmk.leetcode.bishi;


import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for(int i =0;i<n;i++){
        	nums[i] = in.nextInt();
        }
        
        for(int i =0;i<k%(n*100);i++){
        	int num0 = nums[0];
        	for(int j =0;j<n-1;j++){
        		nums[j] = (nums[j]+nums[j+1])%100;
        	}
        	nums[n-1] = (num0+nums[n-1])%100;
        }
        
        for(int i =0;i<n-1;i++){
        	System.out.print(nums[i]+" ");
        }
        System.out.print(nums[n-1]);
    }
}