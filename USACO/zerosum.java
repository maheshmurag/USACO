/*
TASK: zerosum
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;

public class zerosum {
    static int n;
    static ArrayList<String> s;
    static StreamTokenizer input;

    public static void main(String[] args) throws IOException {
        String prob = "zerosum";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        n = nextInt();
        s = new ArrayList<String>();
        rec(1, 1, "1", false);
        String[] arr = new String[s.size()];
        s.toArray(arr);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++)
            output.println(arr[i]);
        output.close();
    }
    static void rec(int index, int val, String str, boolean a) {
        if (index >= n) {
            if (val == 0)
                if (!s.contains(str))
                    s.add(str);
            return;
        }
        rec(index + 1, val + (index + 1), str + "+" + (index + 1),false);
        rec(index + 1, val - (index + 1), str + "-" + (index + 1),false);
        if (a) return;
        if(index==1){
            rec(index + 1, index * 10 + (index + 1), str + " " + (index + 1), true);
            return;
        }
        if (str.lastIndexOf("+") > str.lastIndexOf("-"))
            rec(index + 1, val - index + index * 10 + (index + 1), str + " " + (index + 1), true);
        else
            rec(index + 1, val + index - (index * 10 + (index + 1)), str + " " + (index + 1),true);
    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

