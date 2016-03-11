package com.lmk.leetcode;

public class Merge_Two_Sorted_Lists_21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tail = result;
        while (true){
        	if (l1 == null){
            	tail.next = l2;
            	return result.next;
            }
            if (l2 == null){
            	tail.next = l1;
            	return result.next;
            }
            
            if (l1.val > l2.val){
            	tail.next = l2;
            	l2 = l2.next;
            }else{
            	tail.next = l1;
            	l1 = l1.next;
            }
            tail = tail.next;
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Merge_Two_Sorted_Lists_21 test = new Merge_Two_Sorted_Lists_21();
		int[] nums1 ={};
		
		ListNode head = new ListNode(nums1[0]);
		ListNode l1 = head;
		for (int i = 1; i < nums1.length; i++) {
			ListNode tail= new ListNode(nums1[i]);
			head.next = tail;
			head = tail;
		}
		int[] nums2 ={};
			
		head = new ListNode(nums2[0]);
		ListNode l2 = head;
		for (int i = 1; i < nums2.length; i++) {
			ListNode tail= new ListNode(nums2[i]);
			head.next = tail;
			head = tail;
		}
		test.print(test.mergeTwoLists(l1, l2));
		
	}
	private void print(ListNode head) {
		// TODO Auto-generated method stub
		while (head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

}
