package com.gaolei.java_lib.binarytree.traversal;

import com.gaolei.java_lib.binarytree.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Description：二叉树广度和深度遍历
 * <p>
 * * 前序遍历，根节点先遍历，遍历顺序为：根节点-》左节点-》右节点
 * * 中序遍历，根节点中间遍历，遍历顺序为：左节点-》根节点-》右节点
 * * 后序遍历，根节点后遍历，遍历顺序为：左节点-》右节点-》根节点
 * <p>
 * Java 栈(Stack)和队列(Queue)的首选 - ArrayDeque：https://blog.csdn.net/m0_46144826/article/details/105405172
 */
public class TreeWidthDepthTraversal {

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
     * 深度优先遍历（先序遍历）
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public List<Integer> depthOrderTraversal(BinaryTreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        // 定义一个指针，指向根节点
        stack.push(root);
        while (root == null || !stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    /**
     * 广度优先遍历（层次遍历）
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public List<Integer> levelOrderTraversal(BinaryTreeNode root) {

        List<Integer> list = new ArrayList<>();
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (root == null || !queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }

    // 求二叉树的最小深度
    public static int minDepth(BinaryTreeNode root) {
        //当前root为空则返回0
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            //左子树为空则返回右子树的最小深度
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            //右子树为空则返回左子树最小深度
            return minDepth(root.left) + 1;
        } else {
            //左右子树均不为空则返回左右子树最小深度
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
            return Math.max(h1, h2) + 1;
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

        int[] array = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0};
        TreeWidthDepthTraversal bTree = new TreeWidthDepthTraversal();
        BinaryTreeNode root = buildTree(array, 1);

        int minDeep = minDepth(root);
        System.out.print("\n");
        System.out.println("bTree minDeep: " + minDeep);
        int deep = deep(root);
        System.out.println("bTree deep: " + deep);
        System.out.print("\n\n");

        List<Integer> depthOrderList = bTree.depthOrderTraversal(root);
        System.out.println(">>>>>>非递归 depthOrderList: " + Arrays.toString(depthOrderList.toArray()));
        System.out.print("\n\n");
        List<Integer> levelOrderList = bTree.levelOrderTraversal(root);
        System.out.println(">>>>>>非递归 levelOrderList: " + Arrays.toString(levelOrderList.toArray()));
        System.out.print("\n");

    }
} 