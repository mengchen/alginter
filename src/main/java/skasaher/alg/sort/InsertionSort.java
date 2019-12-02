package skasaher.alg.sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by mengchen on 2019/11/8.
 */
public class InsertionSort extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        Integer[] a = IntStream.generate(() -> StdRandom.uniform(100000))
                .limit(100000)
                .boxed()
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(a));
        System.out.println(isSorted(a));
        sort.sort(a);
        System.out.println();
        System.out.println(Arrays.toString(a));
        System.out.println(isSorted(a));
    }
}
