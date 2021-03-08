package com.gaolei.java_lib.binarytree.traversal;

import com.gaolei.java_lib.binarytree.BinaryTreeNode;

import java.util.ArrayDeque;

import javax.swing.tree.TreeNode;

/**
 * Description：二叉树广度和深度遍历
 * Java 栈(Stack)和队列(Queue)的首选 - ArrayDeque：https://blog.csdn.net/m0_46144826/article/details/105405172
 */
public class TreeWidthDepthTraversal {

    BinaryTreeNode root;

    public TreeWidthDepthTraversal(int[] array) {
        root = makeBinaryTreeByArray(array, 1);
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static BinaryTreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                BinaryTreeNode t = new BinaryTreeNode(value);
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
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.poll();
            System.out.print(node.val + "    ");
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
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.val + "    ");
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

    // 求二叉树的最小深度
    public static int minDepth(BinaryTreeNode root) {
        //当前root为空则返回0
        if (root == null) {
            return 0;
        }
        //左子树为空则返回右子树的最小深度
        else if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        //右子树为空则返回左子树最小深度
        else if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        //左右子树均不为空则返回左右子树最小深度
        else {
            return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
        }
    }

    // 求二叉树的高度
    public static int deep(BinaryTreeNode node) {
        int h1, h2;
        if (node == null) {
            return 0;
        } else {
            h1 = deep(node.left);
            h2 = deep(node.right);
            return (h1 < h2) ? h2 + 1 : h1 + 1;
        }

    }

    // 求二叉树的节点数
    public int getSize(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.left) + getSize(node.right);
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
        int minDeep = minDepth(tree.root);
        System.out.println("minDeep: " + minDeep);
        int deep = deep(tree.root);
        System.out.println("deep: " + deep);

//        tree.depthOrderTraversal();
//        tree.levelOrderTraversal();
    }
} 