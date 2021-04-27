package com.gaolei.java_lib.binarytree.traversal;

import com.gaolei.java_lib.binarytree.BinaryTreeNode;

/**
 * Description：二叉树遍历原则：前序根左右，中序左根右，后序左右根
 */

public class TreeRecursiveTraversal {

    private BinaryTreeNode root;

    public TreeRecursiveTraversal() {
        root = null;
    }

    /**
     * 递归创建二叉树
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
        TreeRecursiveTraversal bTree = new TreeRecursiveTraversal();
        for (int value : a) {
            bTree.buildTree(bTree.root, value);
        }

        System.out.println("递归 preOrder--------");
        bTree.preOrder(bTree.root);
        System.out.println("递归 inOrder--------");
        bTree.inOrder(bTree.root);
        System.out.println("递归 postOrder--------");
        bTree.postOrder(bTree.root);
    }

}
