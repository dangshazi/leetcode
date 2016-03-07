package com.lmk.leetcode;

public class Median_of_Two_Sorted_Arrays_4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0f;
        int length1 = 0;
        int length2 = 0;
        if (nums1 != null){
        	length1 = nums1.length;
        }
        if (nums2 != null){
        	length2 = nums2.length;
        }
        int[] mergedNums = new int[length1+length2];
        int length = mergedNums.length;
        int pointer1 =0;
        int pointer2 =0;
        
        int pointer =0;
        
        while (pointer1 < nums1.length || pointer2 <nums2.length){
        	int x,y;
        	if (pointer1 < nums1.length){
        		x = nums1[pointer1];
        	}else{
        		x = Integer.MAX_VALUE;
        	}
        	if (pointer2 < nums2.length){
        		y = nums2[pointer2];
        	}else{
        		y = Integer.MAX_VALUE;
        	}
        	
        	if( x < y){
        		mergedNums[pointer] = nums1[pointer1];
        		pointer1++;
        		pointer++;
        	}else{
        		mergedNums[pointer] = nums2[pointer2];
        		pointer2++;
        		pointer++;
        	}
        }
        for(int j = 0;j< mergedNums.length;j++){
        	System.out.println(mergedNums[j]+" ");
        }
        if (length%2 == 0){
        	median = (new Double(mergedNums[length/2]) + new Double(mergedNums[length/2-1]))/2;
        }else {
        	median = mergedNums[length/2];
		}
        return median;
    }
	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = null;
		
		Median_of_Two_Sorted_Arrays_4 test = new Median_of_Two_Sorted_Arrays_4();
		
		System.out.println(test.findMedianSortedArrays(nums1, nums2));
	}

}
