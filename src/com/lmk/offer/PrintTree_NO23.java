package com.lmk.offer;

/**
 * @author YaoZhidong
 * @version 1.0
 * @created 2017/5/11
 */

import java.util.List;
        import java.util.ArrayList;
        import java.util.LinkedList;

class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
public class PrintTree_NO23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if ( root == null){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        queue.add(root);
        while(queue.size()>0){
            TreeNode tmp = queue.poll();
            result.add(tmp.val);
            if (tmp.left != null){
                queue.add(tmp.left);
            }
            if (tmp.right != null){
                queue.add(tmp.right);
            }
        }

        return result;
    }
}