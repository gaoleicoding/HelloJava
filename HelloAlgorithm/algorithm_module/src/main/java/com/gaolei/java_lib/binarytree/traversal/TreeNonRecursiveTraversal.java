package com.gaolei.java_lib.binarytree.traversal;

import com.gaolei.java_lib.binarytree.BinaryTreeNode;

import java.util.Stack;

/**
 * Description：二叉树遍历原则：前序根左右，中序左根右，后序左右根
 */

public class TreeNonRecursiveTraversal {

    private BinaryTreeNode root;
    public TreeNonRecursiveTraversal() {
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
    public void preOrder(BinaryTreeNode treeNode) {

        if (treeNode == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.val + " ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 中序遍历（输出结果是有序的）
     */
    public void inOrder(BinaryTreeNode node) {

        Stack<BinaryTreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                System.out.print(node.val + "   ");
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> output = new Stack<>();//构造一个中间栈来存储逆后续遍历的结果
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }

        while (output.size() > 0) {
            System.out.print(output.pop() + "   ");
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 12, 45, 21, 6, 111};
        TreeNonRecursiveTraversal bTree = new TreeNonRecursiveTraversal();
        for (int i = 0; i < a.length; i++) {
            bTree.buildTree(bTree.root, a[i]);
        }

        System.out.println("非递归 preOrder--------");
        bTree.preOrder(bTree.root);
        System.out.println("非递归 inOrder--------");
        bTree.inOrder(bTree.root);
        System.out.println("非递归 postOrder--------");
        bTree.postOrder(bTree.root);
    }

}
