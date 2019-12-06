package skasaher.alg.sort;

/**
 * 合并排序顶底向上
 */
public class MergeSortBU extends MergeSort {
    private static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];
        for (int sz = 1; sz < n; sz *= 2) {
            for (int lo = 0; lo < n - sz; lo += 2 * sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, n - 1));
            }
        }
    }
}
