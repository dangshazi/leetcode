package com.lmk.leetcode;

/**
 * Created by lmk on 2017/6/24.
 */
public class InversePair_36 {

    public long reversePairs(int[] A) {
    // Write your code here
    return sort(A,0,A.length-1);
}

    private long merge(int[] array,int start,int mid,int end){
        log(array,start,mid,end);
        int[] temp = new int[end-start+1];
        int i= start;int j = mid+1;int k =0; long count =0;
        while (i<=mid && j<=end){
            if (array[i]<=array[j]){
                temp[k++]=array[j++];
            }else{
                temp[k++]=array[i++];
                count += end-j+1;
            }
        }
        while (i<=mid){
            temp[k++]=array[i++];
//            count+= end-mid;
        }
        while(j<=end){
            temp[k++]=array[j++];
        }
        for (int t =0;t<temp.length;t++){
            array[start+t]=temp[t];
        }
        log(array,start,mid,end);
        System.out.println(count);
        return count;
    }

    private long sort (int[] array,int start,int end){
        if (start >= end) return 0;
        int mid = (start+end)/2;
        long leftnum = sort(array,start,mid);
        long rightnum = sort(array,mid+1,end);
        long mergeNum = merge(array,start,mid,end);

        return leftnum+rightnum+mergeNum;
    }

    private void log(int[] A,int start,int mid,int end){
        System.out.println(start+"-"+mid+"-"+end+"   ");
        for (int i=0;i<A.length;i++) {
            System.out.print(A[i]);
        }
        System.out.println();
    }
    public static void main(String[] args){
        InversePair_36 tmp = new InversePair_36();
        int[] nums = {4,3,2,1};
        System.out.println(tmp.reversePairs(nums));
    }


    /**
     * 错误的如下
     * public int InversePairs(int [] array) {
     return sort(array,0,array.length-1)%1000000007;
     }

     public int sort(int[] arr,int start,int end){
     if (start>=end){
     return 0;
     }
     int mid = (start+end)/2;
     int leftNum = sort(arr,start,mid);
     int rightNum = sort(arr,mid+1,end);
     int mergeNum = merge(arr,start,mid,end);
     return (leftNum+rightNum+mergeNum)%1000000007;
     }

     public int merge(int[] arr,int start,int mid,int end){
     if (start>=end){
     return 0;
     }
     int[] temp = new int[end-start+1];
     int i = start;int j = mid+1;int k = 0;int count=0;
     while (i<=mid && j<= end){
     if (arr[i]<=arr[j]){
     temp[k++]= arr[j++];
     }else{
     temp[k++]= arr[i++];
     count += end-j+1;
     }
     }
     while (i<=mid){
     temp[k++]= arr[i++];
     }
     while (j<=end){
     temp[k++] = arr[j++];
     }
     for ( int t=0;t<temp.length;t++){
     arr[start+t] = temp[t];
     }
     return count;
     }
     */

}
