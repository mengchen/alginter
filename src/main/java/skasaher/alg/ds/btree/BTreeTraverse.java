package skasaher.alg.ds.btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class BTreeTraverse {

    /** (先序)深度优先搜索递归版本 */
    public static <T> void dfs(BTreeNode<T> root, Consumer<T> visitor) {
        if (root == null) return;
        visitor.accept(root.val);
        dfs(root.left, visitor);
        dfs(root.right, visitor);
    }

    /** (先序)深度优先搜索迭代版本 */
    public static <T> void dfs2(BTreeNode<T> root, Consumer<T> visitor) {
        if (root == null) return;
        Stack<BTreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            visitor.accept(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
    }

    /** (层序)广度优先搜索 */
    public static <T> void bfs(BTreeNode<T> root, Consumer<T> visitor) {
        if (root == null) return;
        Queue<BTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            visitor.accept(root.val);
            if (root.left != null) queue.offer(root.left);
            if (root.right != null) queue.offer(root.right);
        }
    }
}
