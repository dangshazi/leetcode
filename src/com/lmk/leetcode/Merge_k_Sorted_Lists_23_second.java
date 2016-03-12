package com.lmk.leetcode;

import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists_23_second {
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        PriorityQueue<NodeWithIth> queue = new PriorityQueue<NodeWithIth>();
        boolean[] finished = new boolean[lists.length];
        //初始化
        for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null){
				queue.add(new NodeWithIth(lists[i],i));
				lists[i] = lists[i].next;
				if (lists[i] == null){
					finished[i] = true;
				}
			}else {
				finished[i] = true;
			}
		}
        ListNode tail = result;
        //主程序
        while(!queue.isEmpty()){
        	NodeWithIth min = queue.poll();
        	tail.next = min.node;
        	tail = min.node;
        	if( !finished[min.ith]){
        		queue.add(new NodeWithIth(lists[min.ith], min.ith));
        		lists[min.ith] = lists[min.ith].next;
        		if(lists[min.ith] == null){
        			finished[min.ith] = true;
        		}
        	}
        	
        }
        
        
        return result.next;
    }
	public static void main(String[] args) {
		Merge_k_Sorted_Lists_23_second test = new Merge_k_Sorted_Lists_23_second();
		int[] nums1 ={1,4,9};
		
		ListNode head = new ListNode(nums1[0]);
		ListNode l1 = head;
		for (int i = 1; i < nums1.length; i++) {
			ListNode tail= new ListNode(nums1[i]);
			head.next = tail;
			head = tail;
		}
		int[] nums2 ={0,1,3};
			
		head = new ListNode(nums2[0]);
		ListNode l2 = head;
		for (int i = 1; i < nums2.length; i++) {
			ListNode tail= new ListNode(nums2[i]);
			head.next = tail;
			head = tail;
		}
		
		int[] nums3 ={2,3,7};
		
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

class NodeWithIth implements Comparable<NodeWithIth>{
	
	int ith;
	ListNode node;
	public NodeWithIth(ListNode listNode, int i) {
		this.node = listNode;
		this.ith = i;
	}
	@Override
	public int compareTo(NodeWithIth o) {
		
		return this.node.val - o.node.val;
	}
	
	
}
