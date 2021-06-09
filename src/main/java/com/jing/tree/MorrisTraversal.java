package com.jing.tree;

import com.jing.tree.entity.TreeNode;

/**
 * @Version 1.0
 * @Author xuxiaojing
 * @Description Morris 实现二叉树遍历，可参考 https://zhuanlan.zhihu.com/p/101321696
 *             时间复杂度为O(N)，空间复杂度为 O(1)；
 *             空间复杂度是它突出的亮点，利用了空的叶子节点的指针，实现空间的极限压缩
 * @Date 2021/6/9 11:37
 **/

public class MorrisTraversal {

    /**
     * morris遍历的实现原则
     * 记作当前节点为cur。
     *
     * - 如果cur无左孩子，cur向右移动（cur=cur.right）
     * - 如果cur有左孩子，找到cur左子树上最右的节点，记为mostright
     *   - 如果mostright的right指针指向空，让其指向cur，cur向左移动（cur=cur.left）
     *   - 如果mostright的right指针指向cur，让其指向空，cur向右移动（cur=cur.right）
     */
    public static void main(String[] args) {
        TreeNode root = TreeNode.genenrateSimpleTree();
//        morrisPre(root);
        morrisMiddle(root);
    }

    /**
     * 先序遍历
     * @param root
     */
    public static void morrisPre(TreeNode root){
        if (root == null)
            return;
        TreeNode currNode = root;
        while (currNode != null){
            // 若左子树不为空,遍历左子树
            if(currNode.left != null){
                TreeNode tempNode = currNode.left;
                while (tempNode.right != currNode && tempNode.right != null){
                    tempNode = tempNode.right;
                }
                TreeNode mostRightNode = tempNode.right;
                if (mostRightNode == null){
                    // 左子树的最右节点的为空，当前节点肯定是第一次访问
                    System.out.println(currNode.val);
                    tempNode.right = currNode;
                    currNode = currNode.left;
                }else{
                    // 第二种情况是指向当前节点，则是第二次访问，左子树遍历完成，可遍历右子树
                    tempNode.right = null;
                    currNode = currNode.right;
                }
            }else{
                //遍历右子树
                System.out.println(currNode.val);
                currNode = currNode.right;
            }
        }
    }

    /**
     * 中序遍历
     * Tips：与上面先序遍历很相似，差别就在于，第二次遍历时，才打印输出
     * @param root
     */
    public static void morrisMiddle(TreeNode root){
        if (root == null)
            return;
        TreeNode currNode = root;
        while (currNode != null){
            if(currNode.left != null){
                TreeNode tempNode = currNode.left;
                while (tempNode.right != null && tempNode.right != currNode){
                    tempNode = tempNode.right;
                }
                TreeNode mostRightNode = tempNode.right;
                if(mostRightNode == null){
                    tempNode.right = currNode;
                    currNode = currNode.left;
                }else{
                    System.out.println(currNode.val);
                    tempNode.right = null;
                    currNode = currNode.right;
                }
            }else{
                System.out.println(currNode.val);
                currNode = currNode.right;
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static void morrisPost(TreeNode root){
        if (root == null)
            return;
    }

}
