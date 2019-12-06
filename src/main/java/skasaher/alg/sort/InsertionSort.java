package skasaher.alg.sort;

/**
 * 插入排序
 */
public class InsertionSort extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
