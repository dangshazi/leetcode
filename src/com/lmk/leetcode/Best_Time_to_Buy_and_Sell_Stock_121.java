package com.lmk.leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_121 {

	 public int maxProfit(int[] prices) {
        if (prices.length <2){
            return 0;
        }
        int maxProfit = 0;
        int profit =0;
        int min = prices[0];
        
        for (int i = 1;i<prices.length;i++){
            if (prices[i]>=min){
                if(prices[i]-min > profit){
                    profit = prices[i]-min;
                }
            }else{
                if (profit>maxProfit){
                    maxProfit = profit;
                }
                min = prices[i];
                
            }
    	}
        if (profit>maxProfit){
        	maxProfit = profit;
        }
        return maxProfit;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Best_Time_to_Buy_and_Sell_Stock_121 best = new Best_Time_to_Buy_and_Sell_Stock_121();
		int[] prices = {7, 6, 4, 3, 1};
		int maxProfit = best.maxProfit(prices);
		System.out.println(maxProfit);
	}

}
