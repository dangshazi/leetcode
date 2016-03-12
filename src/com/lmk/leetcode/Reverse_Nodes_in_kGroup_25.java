package com.lmk.leetcode;

public class Reverse_Nodes_in_kGroup_25 {
	 public ListNode reverseKGroup(ListNode head, int k) {
	     ListNode result = new ListNode(0);
	     if (k == 1 || head == null || head.next == null ){
	    	 return head;
	     }
	     ListNode lastHead = head;
	     ListNode tail = head;
	     int loop =0;
	     int count = 0;
	     while(tail != null){
	    	 count ++;
	    	 tail = tail.next;
	    	 
	    	 if (count == k){
	    		 loop ++;
	    		 count =0;
	    		 lastHead = tail;
	    	 }
	     }
	     
	     ListNode thisLoopHead = head;
	     tail = head.next;
	     ListNode temp;
	     ListNode formerLooptail = result;//上一个循环的尾部
	     for (int i = 0; i < loop; i++) {
	    	 ListNode reservedHead = thisLoopHead;
			for (int j = 0; j < k -1; j++) {
				temp = tail;
				tail = tail.next;
				temp.next = thisLoopHead;
				thisLoopHead = temp;
			}
			formerLooptail.next = thisLoopHead;
			formerLooptail = reservedHead;
			thisLoopHead = tail;
			if ( tail != null){
				tail = tail.next;
			}
			
		}
	     formerLooptail.next = lastHead;
	     return result.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse_Nodes_in_kGroup_25 test = new Reverse_Nodes_in_kGroup_25();
		
		
		int[] nums1 ={1,2,3,4,5,6,7,8,9,10};
		
		ListNode head = new ListNode(nums1[0]);
		ListNode l1 = head;
		for (int i = 1; i < nums1.length; i++) {
			ListNode tail= new ListNode(nums1[i]);
			head.next = tail;
			head = tail;
		}
		
		test.print(test.reverseKGroup(l1, 5));
		
	}
	private void print(ListNode head) {
		// TODO Auto-generated method stub
		while (head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

}
