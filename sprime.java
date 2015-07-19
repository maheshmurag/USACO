/*
TASK: sprime
LANG: JAVA
ID: maheshm2
 */

import java.io.*;

public class sprime {
    static int n;
    static int[] parr = {2, 3, 5, 7};
    static int[] parr1 = {1, 3, 7, 9};
    static PrintWriter output;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "sprime";
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        output = new PrintWriter(new FileWriter(prob + ".out"));
        input.nextToken();
        n = (int) input.nval;
        boolean a = true;
        int k;
        char x;
        rec(0, 1);
        output.close();
    }

    public static void rec(int val, int layer) {
        if (layer == n + 1) {
            if (isPrime(val))
                output.println(val);
            return;
        }
        if (layer == 1) {
            for (int i = 0; i < parr.length; i++) {
                rec(parr[i], layer + 1);
            }
        } else {
            for (int i = 0; i < parr1.length; i++) {
                if (isPrime(val)) {
                    rec(val * 10 + parr1[i], layer + 1);
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }

}
