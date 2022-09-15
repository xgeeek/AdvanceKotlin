package com.algorithm.A_DataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序： 先遍历该节点的左子树, 再遍历其右子树, 最后遍历该节点
 *
 * @author xugang
 * @date 2022/9/15
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
