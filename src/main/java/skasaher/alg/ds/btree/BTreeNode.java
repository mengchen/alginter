package skasaher.alg.ds.btree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BTreeNode<T> {
    T val;
    BTreeNode<T> left;
    BTreeNode<T> right;

    public BTreeNode(T val) {
        this.val = val;
    }

    /**
     * 从数组构建二叉树
     * @param arr 二叉树存储数组
     * @param complete 是否完全二叉树
     */
    public BTreeNode(T[] arr, boolean complete) {
        if (complete) buildComplete(arr);
        else build(arr);
    }

    /**
     * 利用完全二叉树性质+深度优先遍历构建二叉树
     * @param arr 二叉树存储数组,第0个元素不作为存储用
     */
    private void buildComplete(T[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("illegal argument");
        }
        val = arr[1];
        buildComplete(this, 1, arr);
    }

    private void buildComplete(BTreeNode<T> t, int i, T[] arr) {
        if (t != null) {
            int n = arr.length;
            if (2 * i < n && arr[2 * i] != null) t.left = new BTreeNode<>(arr[2 * i]);
            if (2 * i + 1 < n && arr[2 * i + 1] != null) t.right = new BTreeNode<>(arr[2 * i + 1]);
            buildComplete(t.left, 2 * i, arr);
            buildComplete(t.right, 2 * i + 1, arr);
        }
    }

    /**
     * 利用层序遍历+双指针+广度优先遍历构建二叉树
     * @param arr 二叉树存储数组,使用第0个元素
     */
    private void build(T[] arr) {
        if (arr == null || arr.length < 1 || arr[0] == null) {
            throw new IllegalArgumentException("illegal argument");
        }
        Queue<BTreeNode<T>> queue = new LinkedList<>();
        val = arr[0];
        queue.offer(this);
        int i = 0;
        while (!queue.isEmpty() && i < arr.length) {
            BTreeNode<T> t = queue.poll();
            if (t == null) continue;
            if (++i < arr.length) {
                t.left = Objects.nonNull(arr[i]) ? new BTreeNode<>(arr[i]) : null;
                queue.offer(t.left);
            }
            if (++i < arr.length) {
                t.right = Objects.nonNull(arr[i]) ? new BTreeNode<>(arr[i]) : null;
                queue.offer(t.right);
            }
        }
    }
}
