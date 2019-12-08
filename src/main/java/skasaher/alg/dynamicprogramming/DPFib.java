package skasaher.alg.dynamicprogramming;

/**
 * 斐波那契数列
 */
public class DPFib {
    /**
     * 分治法计算数列
     */
    public static long fib(int n) {
        if (n == 0 || n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 动态规划计算数列
     */
    public static long fib2(int n) {
        int[] f = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) f[i] = 0;
            else if (i == 1) f[i] = 1;
            else f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    /**
     * 动态规划计算数列
     * 使用长度为2的数组
     */
    public static long fib3(int n) {
        int[] f = {0, 1};
        int fib;
        for (int i = 2; i <= n; i++) {
            fib = f[0] + f[1];
            f[0] = f[1];
            f[1] = fib;
        }
        return f[1];
    }

    public static void main(String[] args) {
        System.out.println(fib(30));
        System.out.println(fib2(30));
        System.out.println(fib3(30));
    }
}
