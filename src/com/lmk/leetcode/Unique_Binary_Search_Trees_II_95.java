package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II_95 {
	
    public List<TreeNode> generateTrees(int n) {
        return buildTree(1,n);
    }
    
    public List<TreeNode> buildTree(int head,int tail){
        if(tail<head){
            return null;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        for(int i = head;i<=tail;i++){
            List<TreeNode> leftSubTree = buildTree(head,i-1);
            List<TreeNode> rightSubTree = buildTree(i+1,tail);
            
            for (TreeNode leftNode:leftSubTree){
                for (TreeNode rightNode:rightSubTree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
		Unique_Binary_Search_Trees_II_95 test = new Unique_Binary_Search_Trees_II_95();
		test.generateTrees(0);
	}
}


 
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
 
