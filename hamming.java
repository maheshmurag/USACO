/*
TASK: hamming
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class hamming {
    public static void main(String[] args) throws java.io.IOException {
        String prob = "hamming";
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        input.nextToken();int N = (int)input.nval;input.nextToken();int B = (int)input.nval;input.nextToken();int D = (int)input.nval;
        ArrayList<Integer> arr = new ArrayList<Integer>();arr.add(0);
        int c = 1;
        while(arr.size()!=N && c<=Math.pow(2, B)){
            boolean add = true;
            for (int i = 0; i < arr.size(); i++) {
                if(!(hammingDistance(arr.get(i),c) >= D)) {
                    add = false;
                    break;
                }
            }
            if(add)
                arr.add(c);
            c++;
        }
        for (int i = 0; i < arr.size(); i++) {
            output.print(arr.get(i)+ ((i!=arr.size()-1 && (i+1)%10!=0)?" ":""));
            if((i+1)%10==0&&(i!=arr.size()-1))output.println();
        }
        output.println();
        output.close();

    }

    static int hammingDistance(int a, int b) {
        String stra = new BigInteger("" + a).toString(2);
        String strb = new BigInteger("" + b).toString(2);
        stra = String.format("%16s", stra).replace(' ', '0');
        strb = String.format("%16s", strb).replace(' ', '0');
        int ret = 0;
        for (int i = 0; i < stra.length(); i++)
            if (stra.charAt(i) != strb.charAt(i))
                ret++;
        return ret;
    }
}

