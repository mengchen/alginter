package skasaher.alg.sort;

import java.util.Arrays;

/**
 * Created by mengchen on 2019/11/8.
 */
public abstract class SortTemplate {
    public abstract void sort(Comparable[] a);

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        Arrays.stream(a).forEach((Comparable t) -> System.out.println(t + " "));
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for(int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
