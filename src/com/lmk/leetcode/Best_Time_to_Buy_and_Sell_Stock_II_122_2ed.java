package com.lmk.leetcode;

import java.util.Stack;

public class Best_Time_to_Buy_and_Sell_Stock_II_122_2ed {
	
	public int maxProfit(int[] prices) {
        int maxProfit = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0;i<prices.length;i++){
			if (stack.isEmpty()){
				stack.push(prices[i]);
			}else{
				if (stack.peek()<= prices[i]){
					stack.push(prices[i]);
				}else{
					int tail = stack.peek();
					int head = tail;
					while (!stack.isEmpty()){
						head = stack.pop();
					}
					maxProfit+= tail-head;
					stack.push(prices[i]);
				}
			}
		}
		if (!stack.isEmpty()){
			int tail = stack.peek();
			int head = tail;
			while (!stack.isEmpty()){
				head = stack.pop();
			}
			maxProfit+= tail-head;
		}
		return maxProfit;
        
    }
	
	public static void main(String[] args) {
		Best_Time_to_Buy_and_Sell_Stock_II_122_2ed test = new Best_Time_to_Buy_and_Sell_Stock_II_122_2ed();
		int[] prices = {4,1,2,3,5,2,1,6,2};
		System.out.println(test.maxProfit(prices));
	}

}
