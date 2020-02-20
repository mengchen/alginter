package skasaher.alg.search;

public class BinarySearch {
    public static int bsearch1(int[] arr, int key, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        int comp = key - arr[mid];
        System.out.println("lo = " + lo + ", hi = " + hi + ", mid = " + mid + ", comp = " + comp);
        if (comp > 0) return bsearch1(arr, key, mid + 1, hi);
        else if (comp < 0) return bsearch1(arr, key, lo, mid - 1);
        else return mid;
    }

    public static int bsearch2(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println("lo = " + lo + ", hi = " + hi + ", mid = " + mid);
            int comp = key - arr[mid];
            if (comp > 0) lo = mid + 1;
            else if (comp < 0) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static int bsearch2(int[] arr, int key, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int comp = key - arr[mid];
            if (comp > 0) lo = mid + 1;
            else if (comp < 0) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = bsearch2(arr, 5);
        System.out.println(index);

        index = bsearch2(arr, 5, 0, arr.length - 1);
        System.out.println(index);

        index = bsearch1(arr, 5, 0, arr.length - 1);
        System.out.println(index);
    }
}
