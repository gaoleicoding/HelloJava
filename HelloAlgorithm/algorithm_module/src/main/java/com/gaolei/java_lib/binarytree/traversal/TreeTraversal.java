package com.gaolei.java_lib.binarytree.traversal;

import com.gaolei.java_lib.binarytree.BinaryTreeNode;

/**
 * Description：二叉树遍历原则：前序根左右，中序左根右，后序左右根
 */

public class TreeTraversal {

    private BinaryTreeNode root;

    /**
     * 内部节点类
     *
     * @author yhh
     */


    public TreeTraversal() {
        root = null;
    }

    /**
     * 递归创建二叉树
     *
     * @param node
     * @param data
     */
    public void buildTree(BinaryTreeNode node, int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
        } else {
            if (data < node.val) {
                if (node.left == null) {
                    node.left = new BinaryTreeNode(data);
                } else {
                    buildTree(node.left, data);
                }
            } else {
                if (node.right == null) {
                    node.right = new BinaryTreeNode(data);
                } else {
                    buildTree(node.right, data);
                }
            }
        }
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public void preOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历（输出结果是有序的）
     *
     * @param node
     */
    public void inOrder(BinaryTreeNode node) {

        if (node != null) {
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 12, 45, 21, 6, 111};
        TreeTraversal bTree = new TreeTraversal();
        for (int i = 0; i < a.length; i++) {
            bTree.buildTree(bTree.root, a[i]);
        }

        System.out.println("preOrder--------");
        bTree.preOrder(bTree.root);
        System.out.println("inOrder--------");
        bTree.inOrder(bTree.root);
        System.out.println("postOrder--------");
        bTree.postOrder(bTree.root);
    }

}
