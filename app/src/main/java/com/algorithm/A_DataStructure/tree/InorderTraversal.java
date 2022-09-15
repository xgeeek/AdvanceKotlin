package com.algorithm.A_DataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序： 先遍历该节点的左子树, 然后再遍历该节点, 最后遍历其右子树
 * @author xugang
 * @date 2022/9/15
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder (TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
