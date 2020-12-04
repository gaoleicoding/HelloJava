package com.gaolei.java_lib.tree_traversal;

/**
 * Description：二叉树遍历
 */

public class TreeTraversal {

    private Node root;

    /**
     * 内部节点类
     *
     * @author yhh
     */
    private class Node {
        private Node left;
        private Node right;
        private int data;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    public TreeTraversal() {
        root = null;
    }

    /**
     * 递归创建二叉树
     *
     * @param node
     * @param data
     */
    public void buildTree(Node node, int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            if (data < node.data) {
                if (node.left == null) {
                    node.left = new Node(data);
                } else {
                    buildTree(node.left, data);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node(data);
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
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 12, 45, 21, 6, 111};
        TreeTraversal bTree = new TreeTraversal();
        for (int i = 0; i < a.length; i++) {
            bTree.buildTree(bTree.root, a[i]);
        }
        bTree.preOrder(bTree.root);
        bTree.inOrder(bTree.root);
        bTree.postOrder(bTree.root);
    }

}
