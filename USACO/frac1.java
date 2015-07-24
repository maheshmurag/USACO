/*
TASK: frac1
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.io.StreamTokenizer;
import java.lang.Comparable;
import java.lang.Double;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
public class frac1 {
    static int n;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "frac1";
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        input.nextToken();
        n = (int) input.nval;
        TreeSet<Thing> list = new TreeSet<Thing>(new cmp());
        double tmp = 0.0;
        int g=0;
        list.add(new Thing(0.0, "0/1"));
        list.add(new Thing(1.0, "1/1"));

        for (int i = n; i >= 2; i--) {
            for (int j = 1; j <= n - 1; j++) {
                tmp = (1.0 * j) / (1.0 * i);
                g=gcd(j, i);
                if (tmp >= 1.0) break;
                list.add(new Thing(tmp, (j/g) + "/" + (i/g)));
            }
        }
        Thing[] arr = new Thing[list.size()];
        arr = list.toArray(arr);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            output.println(arr[i].frac);
        }
        output.close();
    }
    static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
    static class cmp implements Comparator<Thing> {
        public int compare(Thing o1, Thing o2) {
            if (o1.value > o2.value) return 1;
            if (o1.value < o2.value) return -1;
            return 0;
        }
    }
    static class Thing implements Comparable<Thing> {
        double value;
        String frac = "";
        public Thing(double v, String f) {
            value = v;
            frac = f;
        }
        public int compareTo(Thing o2) {
            if (this.value > o2.value) return 1;
            if (this.value < o2.value) return -1;
            return 0;
        }
        public String toString() {
            return frac;
        }
    }
}
