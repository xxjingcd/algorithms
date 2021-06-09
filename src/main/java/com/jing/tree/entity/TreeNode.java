package com.jing.tree.entity;

/**
 * @Version 1.0
 * @Author xuxiaojing
 * @Description //TODO
 * @Date 2021/6/9 11:56
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this(val, null, null);
    }

    /**
     * 二叉树
     *          1
     *   2          3
     * 4   5      6   7
     *       8
     */
    public static TreeNode genenrateSimpleTree() {
        TreeNode node8 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5, null, node8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2,node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        return node1;
    }


}
