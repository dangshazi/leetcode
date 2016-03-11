package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Remove_Nth_Node_From_End_of_List_19 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        if (head == null || head.next == null){
        	return null;
        }
        
        List<ListNode> nodes = new ArrayList<ListNode>();
        nodes.add(new ListNode(0));
        int index =-1;
        while (head != null){
        	index ++;
        	
        	nodes.add(head);
        	head = head.next;
        }
        if( index+1 == n){
        	return result.next;
        }
        nodes.add(new ListNode(0));
        nodes.get(index - n+1).next = nodes.get(index -n +2).next;
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remove_Nth_Node_From_End_of_List_19 test = new  Remove_Nth_Node_From_End_of_List_19();
		
		int[] nums ={1,2};
		
		ListNode head = new ListNode(nums[0]);
		ListNode ls = head;
		for (int i = 1; i < nums.length; i++) {
			ListNode tail= new ListNode(nums[i]);
			head.next = tail;
			head = tail;
		}
		
		test.print(test.removeNthFromEnd(ls, 2));
	}
	
	private void print(ListNode head) {
		// TODO Auto-generated method stub
		while (head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

}
