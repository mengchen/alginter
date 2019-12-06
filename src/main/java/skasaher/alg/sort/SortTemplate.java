package skasaher.alg.sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.stream.IntStream;

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
        Arrays.stream(a).forEach((Comparable t) -> System.out.print(t + " "));
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

    public static void test(int n, SortTemplate... template) {
        Integer[] a = IntStream.generate(() -> StdRandom.uniform(1000000))
                .limit(n)
                .boxed()
                .toArray(Integer[]::new);

        System.out.println("array length = " + a.length);
        Arrays.stream(template)
                .forEach(t -> {
                    Integer[] copy = Arrays.copyOf(a, a.length);
                    long begin = System.currentTimeMillis();
                    t.sort(copy);
                    double time = (System.currentTimeMillis() - begin) / 1000.0;
                    boolean sorted = isSorted(copy);
                    System.out.println(t.getClass().getSimpleName() + ": isSorted = " + sorted + ", time = " + time + "s");
                });
    }

    public static void main(String[] args) {
        int n = 100000;
        test(n, new ShellSort(),
                new MergeSort(),
                new MergeSortBU(),
                new QuickSort(),
                new InsertionSort(),
                new SelectionSort());
    }
}
