package com.lmk.lintcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by lmk on 2017/6/25.
 */
public class JiaoJi {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
//        Set<Integer> set1 = new HashSet<Integer>();
//        for (int i=0;i<nums1.length;i++){
//            set1.add(nums1[i]);
//        }
//        Set<Integer> set2 = new HashSet<Integer>();
//        for (int i=0;i<nums2.length;i++){
//            set2.add(nums2[i]);
//        }
//        set1.retainAll(set2);
//        int[] result = new int[set1.size()];
//        int i=0;
//        while(set1.iterator().hasNext()){
//            result[i]=set1.iterator().next();
//            i++;
//        }
//        return  result;
        Arrays.sort(nums1);Arrays.sort(nums2);

        Set<Integer> set = new HashSet<Integer>();
        int k=0;
        for (int i =0;i<nums1.length;i++){
            if  (Arrays.binarySearch(nums2,nums1[i])>-1){
                set.add(nums1[i]);
            }
        }
        int[] result = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        for (int i=0;i<result.length;i++){
            result[i]= iterator.next();
        }
        return result;
    }
}
