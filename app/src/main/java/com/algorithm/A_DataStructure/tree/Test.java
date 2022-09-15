package com.algorithm.A_DataStructure.tree;

import java.util.List;

/**
 * @author xugang
 * @date 2022/9/15
 */
public class Test {

    /**
     * ---------------1----------------
     * ------------2-----3-------------
     * ---------4---5---6--7-----------
     * -------8--9--------------------
     * <p>
     * preorder  result
     * 1 2 4 8 9 5 3 6 7
     * <p>
     * inorder result
     * 8 4 9 2 5 1 6 3 7
     * <p>
     * postorder result
     * 8 9 4 5 2 6 7 3 1
     */
    public static void main(String[] args) {
        TreeNode l4l = new TreeNode(null, null, 8);
        TreeNode l4r = new TreeNode(null, null, 9);

        TreeNode l3l = new TreeNode(l4l, l4r, 4);
        TreeNode l3r = new TreeNode(null, null, 5);

        TreeNode r3l = new TreeNode(null, null, 6);
        TreeNode r3r = new TreeNode(null, null, 7);

        TreeNode l2l = new TreeNode(l3l, l3r, 2);

        TreeNode l2r = new TreeNode(r3l, r3r, 3);

        TreeNode root = new TreeNode(l2l, l2r, 1);


        // preorder
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        List<Integer> preorderList = preorderTraversal.preorderTraversal(root);
        for (Integer val : preorderList) {
            System.out.print(val + "___");
        }

        System.out.println("");

        // inorder
        InorderTraversal inorderTraversal = new InorderTraversal();
        List<Integer> inorderList = inorderTraversal.inorderTraversal(root);
        for (Integer val : inorderList) {
            System.out.print(val + "___");
        }

        System.out.println("");

        // postorder
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        List<Integer> postList = postorderTraversal.postorderTraversal(root);
        for (Integer val : postList) {
            System.out.print(val + "___");
        }

        System.out.println("");

        // level order
        LevelTraversal levelTraversal = new LevelTraversal();
        List<List<Integer>> order = levelTraversal.levelOrder(root);
        for (List<Integer> levelOrder : order) {
            for (int i = 0; i < levelOrder.size(); i++) {
                if (i == levelOrder.size() - 1) {
                    System.out.println(levelOrder.get(i) + "");
                } else {
                    System.out.print(levelOrder.get(i) + "");
                }
            }
        }
    }
}
