/*
TASK: cowroute
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.io.IOException;
import java.lang.Comparable;
import java.lang.Integer;
import java.util.Arrays;
import java.util.LinkedList;


public class cowroute {
    static StreamTokenizer input;
    static Thing[][] cost;
    static int len = 1010;

    public static void main(String[] args) throws IOException {
        String prob = "cowroute";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        int a = next(), b = next(), n = next();
        cost = new Thing[len][len];
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[0].length; j++) {
                if (i != j) cost[i][j] = new Thing(Integer.MAX_VALUE, Integer.MAX_VALUE);
                else cost[i][j] = new Thing(0, 0);
            }
        }
        for (int i = 0; i < n; i++) {
            long routeCost = (long) next();
            int[] route = new int[next()];
            for (int j = 0; j < route.length; j++) {
                route[j] = next();
                for (int k = 0; k < j; k++) {
                    Thing tmp = new Thing(routeCost, j - k);
                    if (tmp.compareTo(cost[route[k]][route[j]]) < 0)
                        cost[route[k]][route[j]] = tmp;//cost,#cities inbetween
                }
            }
        }
        output.println(Dijkstra(a, b));
//        output.println(cost[a][b].routeCost + " " + cost[a][b].numCities);
//        print2Arr(cost);
        output.close();

    }

    static void print2Arr(Thing[][] arrrr) {
        for (int i = 0; i < arrrr.length; i++) {
            for (int j = 0; j < arrrr.length; j++) {
                System.out.print((arrrr[i][j].routeCost != Integer.MAX_VALUE ? arrrr[i][j] : 99) + " ");
            }
            System.out.println();
        }
    }

    static String Dijkstra(int source, int goal) {
        Thing d[] = new Thing[len];
        boolean[] vis = new boolean[len];
        for (int i = 0; i < d.length; i++)
            d[i] = new Thing(Integer.MAX_VALUE, Integer.MAX_VALUE);
        d[source] = new Thing(0, 0);
        for (int g = 0; g < len; g++) {
            int indexOfShortest = -1;
            for (int i = 0; i < len; i++)
                if (!vis[i])
                    if (indexOfShortest == -1 || d[i].compareTo(d[indexOfShortest]) < 0)
                        indexOfShortest = i;
            if (indexOfShortest == -1) continue;
            vis[indexOfShortest] = true;
            for (int i = 0; i < len; i++) {
                Thing t = new Thing(cost[i][indexOfShortest].routeCost + d[indexOfShortest].routeCost,
                        cost[i][indexOfShortest].numCities + d[indexOfShortest].numCities);
                if (t.compareTo(d[i]) < 0)
                    d[i] = t;
            }
        }
//        System.out.println(Arrays.toString(d));
        String out = "";
        if (d[goal].numCities <= len)
        {
            System.out.println(d[goal].routeCost + " " + d[goal].numCities);
            out+=(""+d[goal].routeCost + " " + d[goal].numCities);
        }
        else
        {
            System.out.println("-1 -1");
            out+=("-1 -1");
        }
        return out;
    }


    static int next() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }

    static class Thing implements Comparable<Thing> {
        long routeCost;
        int numCities;

        public Thing(long c, int n) {
            routeCost = c;
            numCities = n;
        }

        public int compareTo(Thing t) {
            if (routeCost != t.routeCost) {
                if (routeCost - t.routeCost > 0) return 1;
                else if (routeCost - t.routeCost < 0) return -1;
            }
            return numCities - t.numCities;
        }

        public String toString() {
            return routeCost + ":" + numCities;
        }
    }
}

