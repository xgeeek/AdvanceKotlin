package com.algorithm.A_DataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序： 先遍历该节点,然后再遍历其左子树,最后遍历其右子树
 *
 * @author xugang
 * @date 2022/9/15
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        preorder(root, arr);
        return arr;
    }

    public void preorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        arr.add(root.val);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }

}
