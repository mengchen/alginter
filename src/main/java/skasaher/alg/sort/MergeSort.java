package skasaher.alg.sort;

/**
 * 合并排序
 */
public class MergeSort extends SortTemplate {
    private static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);       //将左半边排序
        sort(a, mid + 1, hi);   //将右半边排序
        merge(a, lo, mid, hi);  //归并结果
    }

    /**
     * 将a[lo..mid]和a[mid+1..hi]归并
     */
    protected void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
