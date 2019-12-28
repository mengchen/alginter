package skasaher.alg.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 快速排序
 */
public class QuickSort extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i >= hi) break;
            while (less(v, a[--j])) if (j <= lo) break; //v=a[low]作为哨兵可省去这个边界判断
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}
