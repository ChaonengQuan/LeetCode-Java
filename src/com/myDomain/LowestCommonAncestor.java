package com.myDomain;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Algorithm:
        //Step1: find path to p
        //Step2: find path to q
        //Print the node just before the mismathc of two path

        //find the path to p
        List<TreeNode> pPath = new ArrayList<TreeNode>();
        getPath(root, p, pPath);
        //find the path to q
        List<TreeNode> qPath = new ArrayList<TreeNode>();
        getPath(root, q, qPath);
        //compare two path
        int minSize = Math.min(pPath.size(), qPath.size());

        int i;
        for(i = 0; i < minSize; i++){
            if(pPath.get(i).val != qPath.get(i).val){
                return pPath.get(i-1);
            }
        }

        return pPath.get(i-1);

    }

    public boolean getPath(TreeNode root, TreeNode p, List<TreeNode> path){
        if(root == null)
            return false;

        path.add(root);

        if(root.val == p.val)
            return true;

        //goes into left subtree, then right subtree
        if(getPath(root.left, p, path) || getPath(root.right, p ,path))
            return true;

        path.remove(path.size()-1);
        return false;
    }

}
