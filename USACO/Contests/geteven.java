import java.io.*;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class geteven {
    public static void main(String[] args) throws java.io.IOException {
        String prob = "geteven";
        Scanner input = new Scanner(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        int n = input.nextInt();
        long start = System.currentTimeMillis();
        long out=0;
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> e = new ArrayList<Integer>();
        ArrayList<Integer> s = new ArrayList<Integer>();
        ArrayList<Integer> i = new ArrayList<Integer>();
        ArrayList<Integer> g = new ArrayList<Integer>();
        ArrayList<Integer> o = new ArrayList<Integer>();
        ArrayList<Integer> m = new ArrayList<Integer>();

        for (int a = 0; a < n; a++) {
            switch (input.next().charAt(0)){
                case 'B': b.add(input.nextInt()); break;
                case 'E': e.add(input.nextInt()); break;
                case 'S': s.add(input.nextInt()); break;
                case 'I': i.add(input.nextInt()); break;
                case 'G': g.add(input.nextInt()); break;
                case 'O': o.add(input.nextInt()); break;
                case 'M': m.add(input.nextInt()); break;
            }
        }
        int o1=0,o2=0,o3=0;
        for (int B = 0; B < b.size(); B++)
            for (int I = 0; I < i.size(); I++)
                    if((b.get(B)+i.get(I))%2==1)
                        o1++;
        for (int G = 0; G < g.size(); G++)
            for (int O = 0; O < o.size(); O++)
                for (int E = 0; E < e.size(); E++)
                    for (int S = 0; S < s.size(); S++)
                        if((g.get(G)+o.get(O)+e.get(E)+s.get(S))%2==1)
                            o2++;
        for (int M = 0; M < m.size(); M++)
            if(m.get(M)%2==1)
                o3++;
        output.println(b.size()*e.size()*s.size()*i.size()*g.size()*o.size()*m.size()-(o1*o2*o3));
        output.close();

//        System.out.println(Arrays.toString(b.toArray()));
//        System.out.println(Arrays.toString(e.toArray()));
//        System.out.println(Arrays.toString(s.toArray()));
//        System.out.println(Arrays.toString(i.toArray()));
//        System.out.println(Arrays.toString(g.toArray()));
//        System.out.println(Arrays.toString(o.toArray()));
//        System.out.println(Arrays.toString(m.toArray()));
//total num = list length 1 * list length 2 etc
//        for (int B = 0; B < b.size(); B++)
//            for (int E = 0; E < e.size(); E++)
//                for (int S = 0; S < s.size(); S++)
//                    for (int I = 0; I < i.size(); I++)
//                        for (int G = 0; G < g.size(); G++)
//                            for (int O = 0; O < o.size(); O++)
//                                for (int M = 0; M < m.size(); M++)
//                                    if(!((b.get(B)+i.get(I))%2==1 && (g.get(G)+o.get(O)+e.get(E)+s.get(S))%2==1 && m.get(M)%2==1)) {
//                                        out++;
////                                        System.out.println((b.get(B)+2*e.get(E)+2*s.get(S)+i.get(I))*(g.get(G)+o.get(O)+e.get(E)+s.get(S))*(m.get(M)+2*o.get(O)));
//                                    }

//        output.println(out);


    }

//    static int next() throws IOException {
//        input.nextToken();
//        return (int) input.nval;
//    }
}

