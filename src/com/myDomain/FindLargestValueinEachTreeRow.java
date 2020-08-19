package com.myDomain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow {

    //Use BFS algorithm to produce a level order traversal of the binary tree

    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new LinkedList<Integer>();

        Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
        List<Integer> result = new LinkedList<Integer>();

        myQueue.add(root);
        while(!myQueue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int currSize = myQueue.size();

            //find the max value of all nodes in the curret queue
            //i.e all nodes at the same level
            for(int i = 0; i < currSize; i++){
                TreeNode curr = myQueue.remove();
                max = Math.max(max, curr.val);

                if(curr.left != null) myQueue.add(curr.left);
                if(curr.right != null) myQueue.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }


}
