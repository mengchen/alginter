package skasaher.alg.ds.btree;

import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.*;

public class BTreeTraverseTest {

    private Integer[] treeArr = {1, 2, 3, 4, 5, 6, 7};
    private BTreeNode<Integer> tree = new BTreeNode<>(treeArr, false);
    private Consumer<Integer> visitor = (Integer x) -> System.out.print(x + " ");

    @Test
    public void preOrder() {
        BTreeTraverse.preOrder(tree, visitor);
    }

    @Test
    public void preOrder2() {
        BTreeTraverse.preOrder2(tree, visitor);
    }

    @Test
    public void midOrder() {
        BTreeTraverse.midOrder(tree, visitor);
    }

    @Test
    public void midOrder2() {
        BTreeTraverse.midOrder2(tree, visitor);
    }

    @Test
    public void postOrder() {
        BTreeTraverse.postOrder(tree, visitor);
    }

    @Test
    public void postOrder2() {
        BTreeTraverse.postOrder2(tree, visitor);
    }

    @Test
    public void dfs() {
        //完全二叉树
        Integer[] arr = {null, 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1};
        BTreeNode<Integer> root = new BTreeNode<>(arr, true);
        BTreeTraverse.dfs(root, visitor);
        System.out.print("\n---------------------------------\n");
        BTreeTraverse.bfs(root, visitor);
        System.out.print("\n---------------------------------\n");

        //非完全二叉树
        arr = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        root = new BTreeNode<>(arr, false);
        BTreeTraverse.dfs2(root, visitor);
        System.out.print("\n---------------------------------\n");
        BTreeTraverse.bfs(root, visitor);
        System.out.print("\n---------------------------------\n");

        //完全跟非完全表示的不同之处
        arr = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1};
        root = new BTreeNode<>(arr, false);
        BTreeTraverse.dfs2(root, visitor);
        System.out.print("\n---------------------------------\n");
        BTreeTraverse.bfs(root, visitor);
        System.out.print("\n---------------------------------\n");
    }

    @Test
    public void dfs2() {
        BTreeTraverse.dfs2(tree, visitor);
    }

    @Test
    public void bfs() {
        BTreeTraverse.bfs(tree, visitor);
    }
}
