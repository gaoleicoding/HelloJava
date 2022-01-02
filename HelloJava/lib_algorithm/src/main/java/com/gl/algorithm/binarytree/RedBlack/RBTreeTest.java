package com.gl.algorithm.binarytree.RedBlack;

/**
 * 算法之红黑树（JAVA）: https://blog.csdn.net/asdf57847225/article/details/91492906
 */
public class RBTreeTest {
    private static final int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
    private static final boolean mDebugInsert = false;    // "插入"动作的检测开关(false，关闭；true，打开)
    private static final boolean mDebugDelete = false;    // "删除"动作的检测开关(false，关闭；true，打开)

    public static void main(String[] args) {
        int i, ilen = a.length;
        RBTree<Integer> tree = new RBTree<Integer>();

        System.out.printf("== 原始数据: ");
        for (i = 0; i < ilen; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        for (i = 0; i < ilen; i++) {
            tree.insert(a[i]);
            // 设置mDebugInsert=true,测试"添加函数"
            if (mDebugInsert) {
                System.out.printf("== 添加节点: %d\n", a[i]);
                System.out.printf("== 树的详细信息: \n");
                tree.print();
                System.out.printf("\n");
            }
        }

        System.out.printf("== 前序遍历: ");
        tree.preOrder();

        System.out.printf("\n== 中序遍历: ");
        tree.inOrder();

        System.out.printf("\n== 后序遍历: ");
        tree.postOrder();
        System.out.printf("\n");

        System.out.printf("== 最小值: %s\n", tree.minimum());
        System.out.printf("== 最大值: %s\n", tree.maximum());
        System.out.printf("== 树的详细信息: \n");
        tree.print();
        System.out.printf("\n");

        // 设置mDebugDelete=true,测试"删除函数"
        if (mDebugDelete) {
            for (i = 0; i < ilen; i++) {
                tree.remove(a[i]);

                System.out.printf("== 删除节点: %d\n", a[i]);
                System.out.printf("== 树的详细信息: \n");
                tree.print();
                System.out.printf("\n");
            }
        }

        // 销毁二叉树
        tree.clear();
    }
}
//下面是测试程序的运行结果：
//
//        == 原始数据: 10 40 30 60 90 70 20 50 80
//        == 前序遍历: 30 10 20 60 40 50 80 70 90
//        == 中序遍历: 10 20 30 40 50 60 70 80 90
//        == 后序遍历: 20 10 50 40 70 90 80 60 30
//        == 最小值: 10
//        == 最大值: 90
//        == 树的详细信息:
//        30(B) is root
//        10(B) is 30's   left child
//        20(R) is 10's  right child
//        60(R) is 30's  right child
//        40(B) is 60's   left child
//        50(R) is 40's  right child
//        80(B) is 60's  right child
//        70(R) is 80's   left child
//        90(R) is 80's  right child