package com.lmk.lintcode;

/**
 * Created by lmk on 2017/6/24.
 * 题目：中位数
 */
public class FindMid {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        int midPos = (nums.length)/2;
        return find(midPos,nums);

    }

    private int find(int index,int[] nums){
        int start =0;int end = nums.length-1;
        int pos =0;
        while ((pos = partition(nums,start,end)) != index){
            if (pos<index){
                start = pos+1;
            }else{
                end = pos-1;
            }
        }
        return nums[pos];
    }

    private int partition(int[] array,int start,int end){
        int mid = array[start];
        while (start<end){
            while(start<end && mid<=array[end]){
                end--;
            }
            swap(array,start,end);
            while(start<end && mid>=array[start]){
                start++;
            }
            swap(array,start,end);
        }
        return start;
    }
    private void swap (int[] array,int a,int b){
        int temp = array[a];
        array[a]=array[b];
        array[b]=temp;
    }
    public static void main(String[] args){
        FindMid findMid = new FindMid();
        int[] nums = {7,9,4,5};
        System.out.println(findMid.median(nums));
    }
}
