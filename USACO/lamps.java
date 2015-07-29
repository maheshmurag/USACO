/*
TASK: lamps
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;

public class lamps {
    static ArrayList<String> out = new ArrayList<String>();
    static ArrayList<Integer> finOn;
    static ArrayList<Integer> finOff;
    static int c;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "lamps";
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        input.nextToken();
        int n = (int) input.nval;
        input.nextToken();
        c = (int) input.nval;
        finOn = new ArrayList<Integer>();
        finOff = new ArrayList<Integer>();
        input.nextToken();
        int val = (int) input.nval;
        while (val != -1) {
            finOn.add(val);
            input.nextToken();
            val = (int) input.nval;
        }
        input.nextToken();
        val = (int) input.nval;
        while (val != -1) {
            finOff.add(val);
            input.nextToken();
            val = (int) input.nval;
        }
        String str = "";
        for (int i = 0; i < n; i++)
            str += "1";
        rec(str, 0, true, 0);
        rec(str, 0, false, 0);
        if (out.size() == 0) {
            output.println("IMPOSSIBLE");
        } else {
            String[] arr = new String[out.size()];
            out.toArray(arr);
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                output.println(arr[i]);
            }
        }
        output.close();
    }
    static void rec(String str, int count, boolean enable, int index) {
        if (out.contains(str)) return;
        if (count >= c || index == 4) {
            for (int i = 0; i < finOn.size(); i++)
                if (str.charAt(finOn.get(i) - 1) != '1')
                    return;
            for (int i = 0; i < finOff.size(); i++)
                if (str.charAt(finOff.get(i) - 1) != '0')
                    return;
            out.add(str);
            return;
        }
       if(enable == false){
           rec(str, count, true, index+1);
           rec(str, count, false, index+1);
           return;
       }
        switch(index){
            case 0: rec(state1(str), count + 1, true, index+1);rec(state1(str), count + 1, false, index+1);break;
            case 1: rec(state2(str), count + 1, true, index+1);rec(state2(str), count + 1, false, index+1);break;
            case 2: rec(state3(str), count + 1, true, index+1);rec(state3(str), count + 1, false, index+1);break;
            case 3: rec(state4(str), count + 1, true, index+1);rec(state4(str), count + 1, false, index+1);break;
        }
    }
    static String state1(String str) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') out += "1";
            else out += "0";
        }
        return out;
    }
    static String state2(String str) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 != 0) out += "" + str.charAt(i);
            else {
                if (str.charAt(i) == '0') out += "1";
                else out += "0";
            }
        }
        return out;
    }
    static String state3(String str) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) out += "" + str.charAt(i);//if even
            else {
                if (str.charAt(i) == '0') out += "1";
                else out += "0";
            }
        }
        return out;
    }
    static String state4(String str) {
        String out = "";
        int c = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 != c) out += "" + str.charAt(i);
            else {
                if (str.charAt(i) == '0') out += "1";
                else out += "0";
                c += 3;
            }
        }
        return out;
    }
}
