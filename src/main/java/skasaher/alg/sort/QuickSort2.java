package skasaher.alg.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 快速排序2
 * partition更多的交换
 */
public class QuickSort2 extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], v)) exch(a, i, ++j);
        }
        exch(a, lo, j);
        return j;
    }
}
