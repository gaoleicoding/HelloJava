package com.gaolei.java_lib.binarytree.traversal;

import com.gaolei.java_lib.binarytree.BinaryTreeNode;

/**
 * Description：二叉树遍历原则：前序根左右，中序左根右，后序左右根
 */

public class TreeRecursiveTraversal {

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static BinaryTreeNode buildTree(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                BinaryTreeNode t = new BinaryTreeNode(value);
                array[index] = 0;
                t.left = buildTree(array, index * 2);
                t.right = buildTree(array, index * 2 + 1);
                return t;
            }
        }
        return null;
    }

    /**
     * 前序遍历
     */
    public void preOrderTraversal(BinaryTreeNode root) {

        if (root != null) {
            System.out.print(root.val + "、");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * 中序遍历（输出结果是有序的）
     */
    public void inOrderTraversal(BinaryTreeNode root) {

        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + "、");
            inOrderTraversal(root.right);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal(BinaryTreeNode root) {

        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val + "、");
        }
    }

    /**
     * 13
     * /  \
     * 65    5
     * /  \    \
     * 97  25   37
     * /    /\   /
     * 22   4 28 32
     */
    public static void main(String[] args) {
        int[] array = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0};
        TreeRecursiveTraversal bTree = new TreeRecursiveTraversal();
        BinaryTreeNode root = buildTree(array, 1);

        System.out.print("\n");
        System.out.println(">>>>>>递归 preOrder: ");
        bTree.preOrderTraversal(root);
        System.out.print("\n\n");
        System.out.println(">>>>>>递归 inOrder: ");
        bTree.inOrderTraversal(root);
        System.out.print("\n\n");
        System.out.println(">>>>>>递归 postOrder: ");
        bTree.postOrderTraversal(root);
        System.out.print("\n");

    }

}
