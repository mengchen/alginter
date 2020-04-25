package skasaher.alg.ds.btree;

import java.util.*;
import java.util.function.Consumer;

public class BTreeTraverse {

    /** (先序)递归 */
    public static <T> void preOrder(BTreeNode<T> root, Consumer<T> visitor) {
        if (root == null) return;
        visitor.accept(root.val);
        preOrder(root.left, visitor);
        preOrder(root.right, visitor);
    }

    /** (先序)迭代 */
    public static <T> void preOrder2(BTreeNode<T> root, Consumer<T> visitor) {
        Stack<BTreeNode<T>> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                visitor.accept(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    /** (中序)递归 */
    public static <T> void midOrder(BTreeNode<T> root, Consumer<T> visitor) {
        if (root == null) return;
        midOrder(root.left, visitor);
        visitor.accept(root.val);
        midOrder(root.right, visitor);
    }

    /** (中序)迭代 */
    public static <T> void midOrder2(BTreeNode<T> root, Consumer<T> visitor) {
        Stack<BTreeNode<T>> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop();
                visitor.accept(root.val);
                root = root.right;
            }
        }
    }

    /** (后序)递归 */
    public static <T> void postOrder(BTreeNode<T> root, Consumer<T> visitor) {
        if (root == null) return;
        postOrder(root.left, visitor);
        postOrder(root.right, visitor);
        visitor.accept(root.val);
    }

    /** (后序)迭代 */
    public static <T> void postOrder2(BTreeNode<T> root, Consumer<T> visitor) {
        Stack<BTreeNode<T>> stack = new Stack<>();
        BTreeNode<T> cur = root, last = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.empty()) {
                cur = stack.peek();
                if (cur.right == null || cur.right == last) {
                    visitor.accept(cur.val);
                    last = cur;
                    cur = null;
                    stack.pop();
                } else {
                    cur = cur.right;
                }
            }
        }
    }

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

    /** (层序)从上到下从左到右返回所有节点值 **/
    public static <T> List<List<T>> bfs(BTreeNode<T> root) {
        if (root == null) return Collections.emptyList();
        List<List<T>> res = new ArrayList<>();
        Queue<BTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<T> list = new ArrayList<>();
            res.add(list);
            int length = queue.size();
            while ((length--) > 0) {
                BTreeNode<T> t = queue.poll();
                list.add(t.val);
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            }
        }
        return res;
    }
}
