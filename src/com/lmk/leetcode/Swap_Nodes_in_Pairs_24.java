package com.lmk.leetcode;

public class Swap_Nodes_in_Pairs_24 {
	public ListNode swapPairs(ListNode head) {
       ListNode result = new ListNode(0);
       ListNode tail = result;
       if (head != null && head.next == null){
    	   return head;
       }
       while (head != null && head.next != null){
    	   tail.next = head.next;
    	   head.next = head.next.next;
    	   tail.next.next = head;
    	   tail = head;
    	   head = head.next;
    	   
       }
       
       
       return result.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Swap_Nodes_in_Pairs_24 test = new Swap_Nodes_in_Pairs_24();
		
		int[] nums1 ={1,2,3,4,5};
		
		ListNode head = new ListNode(nums1[0]);
		ListNode l1 = head;
		for (int i = 1; i < nums1.length; i++) {
			ListNode tail= new ListNode(nums1[i]);
			head.next = tail;
			head = tail;
		}
		test.print(l1);
		test.print(test.swapPairs(l1));
	}
	private void print(ListNode head) {
		// TODO Auto-generated method stub
		while (head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}
