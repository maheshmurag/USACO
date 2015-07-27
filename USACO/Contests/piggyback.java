import java.io.*;
import java.lang.Integer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
when you bfs you clear the visited array so you retrack a lot of nodes
you shouldn't be setting it all to false every time
before it would be n^2
because each bfs has individually the chance to go up to n
if you remember what you've visited b4 you should be able to save work
you need to memoize then
you already calculate d[0][i]
you can use that in your bfs
if its something you've already visited, just add the d value for that
i'd recommend writing one bfs function that generates the shortest distance to all fields from a given source
and then use that bfs function for 0, 1, and the last one to find the distances
your problem is that you're trying to combine bfs and a for loop, so you waste effort
along the way in the bfs to find the distance from node 5 for example, you also find the distance for node 4 and node 6, so you should somehow store that
 */
public class piggyback {
    static int b, e, p, n, m;
    static int[][] connections;
    static LinkedList<Integer> queue;

    static boolean[] visited;
    static int[] previous;
    static int[][] d;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "piggyback";
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));

        input.nextToken();
        b = (int) input.nval;//bessie's energy per connection
        input.nextToken();
        e = (int) input.nval;//elsie's energy per connection
        input.nextToken();
        p = (int) input.nval;//energy when piggybacking
        input.nextToken();
        n = (int) input.nval;//which field the barn is in
        input.nextToken();
        m = (int) input.nval;//num total connections
        connections = new int[n+1][n+1];
        int x, y;

        d = new int[4][n + 1];

        visited = new boolean[n + 1];
        previous = new int[n + 1];
        queue = new LinkedList<Integer>();

        for (int i = 0; i < connections.length; i++) {
            for (int j = 0; j < connections[0].length; j++) {
                connections[i][j] = 0;

            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n+1; j++) {
                d[i][j] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            input.nextToken();
            x = (int) input.nval;
            input.nextToken();
            y = (int) input.nval;
            connections[x][y] = 1;
            connections[y][x] = 1;
        }
        bfs2(1);
        bfs2(2);
        bfs2(n);
        int tmp = 0, min = Integer.MAX_VALUE;
        for (int i = 3; i < n; i++) {
            tmp = d[1][i] * b + d[2][i] * e + d[3][i] * p;
            if (!(d[1][i] <= 0 || d[2][i] <= 0 || d[3][i] <= 0) && tmp < min)
            {
                min = tmp;
                System.out.println("tmp: " + tmp + " for i: " + i);
            }
        }
        System.out.println("min: " + min);
//        System.out.println("___________________________________");
//        print2Arr(d);
        output.println(min);
        output.close();
    }

    static void print2Arr(int[][] arrrr) {
        for (int i = 0; i < arrrr.length; i++) {
            for (int j = 0; j < arrrr.length; j++) {
                if (arrrr[i][j] >= 0) System.out.print(arrrr[i][j] + " ");
                else System.out.print("");
            }
            System.out.println();
        }
    }

    static int bfs2(int source) {
        queue.clear();
        Arrays.fill(visited, false);
        Arrays.fill(previous, 0);
        queue.push(source);
        int count = 0;
        while (!queue.isEmpty()) {
            int top = queue.getFirst().intValue();
            queue.removeFirst();
            for (int i = 3; i < n; i++) {
                int a = connections[top][i];
                if (a != 0) {
                    if (!visited[i] && source!=i) {
                        queue.add(i);
                        visited[i] = true;
                        previous[i] = top;
                        int bfs2tmp = i, counter = 0;
                        while (bfs2tmp != source) {
                            counter++;
                            bfs2tmp = previous[bfs2tmp];
                        }
                        if (d[(source==n?3:source)][i] == -1) {
                            d[(source==n?3:source)][i] = counter;
//                            d[i][source] = counter;
//                            System.out.println("Distance from " + source + " to "+i+" is " + counter +". " + Arrays.toString(previous)+ ". top is " + top);//+":"+Arrays.deepToString(d));
                        }
                    }
                }
            }
        }

        return -1;
    }

}

