package com.lmk.leetcode;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }

public class Add_Two_Numbers_2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int jinwei = 0;
        int num =0;
        ListNode head = result;
        ListNode tail = null;
        while (l1 != null || l2 != null){
        	num++;
        	
        	int x1 =0;
            int x2 =0;
        	if (l1 != null){
        		x1 = l1.val;
        	}
        	if (l2 != null){
        		x2 = l2.val;
        	}
        	tail = new ListNode((x1+x2+jinwei)%10);
        	jinwei = (x1+x2+jinwei)/10;
        	head.next = tail;
        	
        	if (l1 != null){
        		l1 = l1.next;
        	}
        	if (l2 != null){
        		l2 = l2.next;
        	}
        	head = tail;
        }
        if (jinwei != 0){
        	tail = new ListNode(1);
        	head.next= tail;
        }
        return result.next;
    }
	
	public static void main(String[] args) {
		int[] a = {2,3,4};
		int[] b = {4,5,6,9};
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		ListNode head = l1;
        ListNode tail = null;
		for(int i = 0;i<a.length;i++){
			tail = new ListNode(a[i]);
			head.next = tail;
			head = tail;
		}
		head = l2;
        tail = null;
		for(int i = 0;i<b.length;i++){
			tail = new ListNode(b[i]);
			head.next = tail;
			head = tail;
		}
		
		Add_Two_Numbers_2 test = new Add_Two_Numbers_2();
		ListNode result = test.addTwoNumbers(l1.next, l2.next);
		
		while (result != null){
			System.out.print(result.val+"->");
			
			result = result.next;
			
		}
	}
	
}
