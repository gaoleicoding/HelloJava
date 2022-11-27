package com.gl.algorithm.binarytree.traversal;

import com.gl.algorithm.binarytree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Description：二叉树遍历原则：前序根左右，中序左根右，后序左右根
 * <p>
 * 前序遍历，父节点先遍历，遍历顺序为：父节点-》左节点-》右节点
 * 中序遍历，父节点中间遍历，遍历顺序为：左节点-》父节点-》右节点
 * 后序遍历，父节点后遍历，遍历顺序为：左节点-》右节点-》父节点
 */

public class TreeNonRecursiveTraversal {

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
     * 前序遍历- 根、左、右
     */
    public List<Integer> preOrderTraversal(BinaryTreeNode head) {

        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        // 定义一个指针，指向根节点
        stack.push(head);
        while (!stack.isEmpty()) {
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
     * 中序遍历（输出结果是有序的）- 左、根、右
     */
    public List<Integer> inOrderTraversal(BinaryTreeNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                // 当前节点不为空, 将自己压进栈并将自己的左孩子作为当前节点（压入左边界）
                stack.push(head);
                head = head.left;
            } else {
                // 当前节点为空（没有左孩子了）, 将栈顶元素弹出作为当前节点, 并将当前节点的右孩子压进栈
                head = stack.pop();
                list.add(head.val);
                head = head.right;
            }
        }
        return list;
    }

    /**
     * 后序遍历- 左、右、根
     */
    public LinkedList<Integer> postOrderTraversal(BinaryTreeNode head) {
        if (head == null) return null;
        LinkedList<Integer> list = new LinkedList<>();
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        // 辅助栈，存储 根 -> 右 -> 左 的结果
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            // 有左孩子就先压入左孩子
            if (head.left != null)
                stack1.push(head.left);
            // 有右孩子就后压入右孩子
            if (head.right != null)
                stack1.push(head.right);
        }
        // 逆序打印 根 -> 右 -> 左 的结果，就是后序遍历的结果
        while (!stack2.isEmpty())
            list.add(stack2.pop().val);
        return list;
    }

    /**
     * 前序遍历- 根、左、右
     */
    public List<Integer> preOrderTraversal2(BinaryTreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        // 申请一个栈空间，保存节点
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // 当前节点的左节点深度遍历
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            // 当前节点的左节点访问完毕，访问右节点，对右节点的左节点继续深度遍历
            cur = stack.pop();
            cur = cur.right;

        }
        return list;
    }

    /**
     * 中序遍历（输出结果是有序的）- 左、根、右
     */
    public List<Integer> inOrderTraversal2(BinaryTreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        // 申请一个栈空间，保存节点
        Stack<BinaryTreeNode> stack = new Stack<>();
        // 定义一个指针，指向根节点
        BinaryTreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // 每指向一个节点，把该节点push到栈中，且将左节点push到栈中
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 左节点不存在，因为是中序遍历，栈中最后一个元素出栈并访问
            cur = stack.pop();
            list.add(cur.val);
            // 指针指向右节点，开始下一个循环，访问该右节点的左节点
            cur = cur.right;
        }
        return list;
    }

    /**
     * 后序遍历- 左、右、根
     */
    public List<Integer> postOrderTraversal2(BinaryTreeNode root) {
        if (root == null) return null;
        LinkedList<Integer> list = new LinkedList<>();
        // 定义一个栈
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // 当前节点的右节点深度遍历
            while (cur != null) {
                list.addFirst(cur.val);
                stack.push(cur);
                cur = cur.right;
            }
            // 当前节点的左节点访问完毕，访问右节点，对右节点的左节点继续深度遍历
            cur = stack.pop();
            cur = cur.left;
        }
        return list;
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
        TreeNonRecursiveTraversal bTree = new TreeNonRecursiveTraversal();
        BinaryTreeNode root = buildTree(array, 1);

        System.out.print("\n");
        List<Integer> preOrderList = bTree.preOrderTraversal(root);
        System.out.println(">>>>>>非递归 preOrder: " + Arrays.toString(preOrderList.toArray()));
        System.out.print("\n\n");
        List<Integer> inOrderList = bTree.inOrderTraversal(root);
        System.out.println(">>>>>>非递归 inOrder: " + Arrays.toString(inOrderList.toArray()));
        System.out.print("\n\n");
        List<Integer> postOrderList = bTree.postOrderTraversal(root);
        System.out.println(">>>>>>非递归 postOrder: " + Arrays.toString(postOrderList.toArray()));
        System.out.print("\n");

    }
}
