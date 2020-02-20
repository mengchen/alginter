package skasaher.alg.dynamic;

/**
 * 二项式系数
 */
public class DPBin {
    /**
     * 分治法计算二项式系数C(n,k)
     */
    public static long bin(int n, int k) {
        if (k == 0 || k == n) return 1;
        return bin(n - 1, k - 1) + bin(n - 1, k);
    }

    /**
     * 动态规划计算二项式系数C(n,k)
     */
    public static long bin2(int n, int k) {
        long[][] b = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(k, i); j++) {
                if (j == 0 || j == i) b[i][j] = 1;
                else b[i][j] = b[i - 1][j] + b[i - 1][j - 1];
            }
        }
        return b[n][k];
    }

    /**
     * 动态规划计算二项式系数C(n,k)
     * 仅适用索引范围0至k的一维数组
     */
    public static long bin3(int n, int k) {
        long[] b = new long[k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = Math.min(k, i); j >= 0; j--) {
                if (j == 0 || j == i) b[j] = 1;
                else b[j] = b[j] + b[j - 1];
            }
        }
        return b[k];
    }

    public static void main(String[] args) {
        int n = 70, k = 7;
        long l1 = System.currentTimeMillis();
        System.out.println(bin(n, k));
        long l2 = System.currentTimeMillis();
        System.out.println((l2 - l1) / 1000.0 + "s");

        System.out.println(bin2(n, k));
        long l3 = System.currentTimeMillis();
        System.out.println((l3 - l2) / 1000.0 + "s");

        System.out.println(bin3(n, k));
        long l4 = System.currentTimeMillis();
        System.out.println((l4 - l3) / 1000.0 + "s");
    }
}
