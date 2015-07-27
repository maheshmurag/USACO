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
        connections = new int[n + 1][n + 1];
        int x, y;

        d = new int[n + 1][n + 1];

        visited = new boolean[n + 1];
        previous = new int[n + 1];
        queue = new LinkedList<Integer>();

        for (int i = 0; i < connections.length; i++) {
            for (int j = 0; j < connections[0].length; j++) {
                connections[i][j] = 0;
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
//        int[][] d = new int[3][n + 1];//0=1,1=2,2=n
        for (int i = 3; i < n; i++) {
//            d[0][i] = bfs(1, i);
//            d[1][i] = bfs(2, i);
//            d[2][i] = bfs(n, i);
            System.out.println("1fdsa: " + i);
            if(d[1][i] == -1)bfs(1, i);
            System.out.println("2fdsa: " + i);
            if(d[2][i] == -1)bfs(2, i);
            System.out.println("3fdsa: " + i);
            if(d[n][i] == -1)bfs(n, i);

        }
        int tmp = 0, min = Integer.MAX_VALUE;
        for (int i = 3; i < n; i++) {
            tmp = d[0][i] * b + d[1][i] * e + d[2][i] * p;
            if (tmp < min)
                min = tmp;
        }
        output.println(min);
        output.close();
    }

    static int bfs(int source, int goal) {
        queue.clear();
        Arrays.fill(visited, false);
        Arrays.fill(previous, 0);
        queue.push(source);
        int count = 0;
        while (!queue.isEmpty()) {
            int top = queue.getFirst().intValue();
            queue.removeFirst();
            if (top == goal) {
                int x = goal;
                while (x != source) {
                    count++;
                    x = previous[x];
                }
                d[goal][source] = count;
                d[source][goal] = count;

                return count;
            }
            for (int i = 1; i < connections[top].length; i++) {
                int a = connections[top][i];
                if (a != 0) {
                    if (!visited[i]) {
                        if ((d[source][i] == -1)) {
//                            System.out.println("unknown " + source + ":" + i);
                            queue.add(i);
                            visited[i] = true;
                            previous[i] = top;
                        } else {
//                            System.out.println("known " + source + ":" + i);
                            int thing = i, counter = 0;
                            while (thing != source) {
                                counter++;
                                thing = previous[thing];
                            }
                            d[source][i] = count;
                            d[i][source] = count;
                        }
                    }
                }
            }
        }

        return -1;
    }


}

