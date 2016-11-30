package com.lmk.leetcode;

public class Merge_k_Sorted_Lists_23 {
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        for (int i = 0; i < lists.length; i++) {
			result = mergeTwoLists(result, lists[i]);
		}
        return result.next;
    }
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
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
		Merge_k_Sorted_Lists_23 test = new Merge_k_Sorted_Lists_23();
		int[] nums1 ={1};
		
		ListNode head = new ListNode(nums1[0]);
		ListNode l1 = head;
		for (int i = 1; i < nums1.length; i++) {
			ListNode tail= new ListNode(nums1[i]);
			head.next = tail;
			head = tail;
		}
		int[] nums2 ={0};
			
		head = new ListNode(nums2[0]);
		ListNode l2 = head;
		for (int i = 1; i < nums2.length; i++) {
			ListNode tail= new ListNode(nums2[i]);
			head.next = tail;
			head = tail;
		}
		
		int[] nums3 ={2};
		
		head = new ListNode(nums3[0]);
		ListNode l3 = head;
		for (int i = 1; i < nums3.length; i++) {
			ListNode tail= new ListNode(nums3[i]);
			head.next = tail;
			head = tail;
		}
		
		ListNode[] lists = {l1,l2,l3};
		test.print(test.mergeKLists(lists));
		
	}
	private void print(ListNode head) {
		// TODO Auto-generated method stub
		while (head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}
