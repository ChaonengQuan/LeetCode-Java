package com.myDomain;

public class MaximumBinaryTree {

    //Memory Limit Exceeded

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null) return null;   //edge case

        //construct root first
        int start = 0;
        int end = nums.length;
        TreeNode root = makeTree(nums, start, end);

        return root;
    }

    //----helper methods----//

    // public int findMaxIndex(int[] arr, int start, int end){
    //     int resultIndex = 0;
    //     int max = arr[0];
    //     for(int i = start; i < end; i++){
    //         if(arr[i] > max){
    //             resultIndex++;
    //             max = arr[i];
    //         }
    //     }
    //     return resultIndex;
    // }

    public TreeNode makeTree(int[] nums, int start, int end){
        if(start > end)
            return null;

        //int currMaxIndex = findMaxIndex(nums, start, end);
        int currMaxIndex = start;
        int max = nums[start];
        for(int i = start; i < end; i++){
            if(nums[i] > max){
                currMaxIndex++;
                max = nums[i];
            }
        }


        TreeNode node = new TreeNode(nums[currMaxIndex], null, null);

        node.left = makeTree(nums, start, end - currMaxIndex);
        node.right = makeTree(nums, currMaxIndex+1, end);

        return node;
    }

}
