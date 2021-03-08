package com.gaolei.java_lib.tree.traversal;

import java.util.ArrayDeque;

/**
 * Description：二叉树广度和深度遍历
 * Java 栈(Stack)和队列(Queue)的首选 - ArrayDeque：https://blog.csdn.net/m0_46144826/article/details/105405172
 */
public class TreeWidthDepthTraversal {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    TreeNode root;

    public TreeWidthDepthTraversal(int[] array) {
        root = makeBinaryTreeByArray(array, 1);
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                TreeNode t = new TreeNode(value);
                array[index] = 0;
                t.left = makeBinaryTreeByArray(array, index * 2);
                t.right = makeBinaryTreeByArray(array, index * 2 + 1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历（先序遍历）
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            System.out.print(node.value + "    ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            System.out.println("stack.size():" + stack.size());
        }
        System.out.print("\n\n\n\n");
    }

    /**
     * 广度优先遍历（层次遍历）
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + "    ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            System.out.println("queue.size():" + queue.size());
        }
        System.out.print("\n");
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
        int[] arr = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0};
        TreeWidthDepthTraversal tree = new TreeWidthDepthTraversal(arr);
        tree.depthOrderTraversal();
        tree.levelOrderTraversal();
    }
} 