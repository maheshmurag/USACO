import java.io.*;
import java.lang.Integer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class piggyback {
    static int b, e, p, n, m;
    static int[][] connections;
    static LinkedList<Integer> queue;

    static boolean[] visited;
    static int[] previous;
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
        visited = new boolean[n + 1];
        previous = new int[n + 1];
        queue = new LinkedList<Integer>();

        for (int i = 0; i < connections.length; i++)
            for (int j = 0; j < connections[0].length; j++)
                connections[i][j] = 0;

        for (int i = 0; i < m; i++) {
            input.nextToken();
            x = (int) input.nval;
            input.nextToken();
            y = (int) input.nval;
            connections[x][y] = 1;
            connections[y][x] = 1;
        }
        int[][] d = new int[3][n + 1];//0=1,1=2,2=n
        for (int i = 3; i < n; i++) {
            d[0][i] = bfs(1, i);
            d[1][i] = bfs(2, i);
            d[2][i] = bfs(n, i);
            System.out.println("fdsa: " + i);
        }
        int tmp = 0, min = Integer.MAX_VALUE;

        for (int i = 3; i < n; i++) {
            //if (connections[1][i] != 0 && connections[2][i] != 0 && connections[i][n] != 0)
            {
                tmp = d[0][i] * b + d[1][i] * e + d[2][i] * p;
//                tmp = bfs(1, i) * b + bfs(2, i) * e + bfs(i, n) * p;
//                tmp = Dijkstra(1, i) * b + Dijkstra(2, i) * e + Dijkstra(i, n) * p;
                if (tmp < min)
                    min = tmp;
            }
        }
        output.println(min);
        output.close();
    }

    static int Dijkstra(int source, int goal) {
        boolean failed = false;
        int previous[] = new int[n + 1];
        LinkedList<Integer> S = new LinkedList<Integer>();
        int d[] = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[source] = 0;

        int indexOfShortest;
        while (S.size() != n) {
            indexOfShortest = goal;
            for (int i = 1; i < d.length; i++) {
                if (d[i] < d[indexOfShortest] && !Scontains(S, i))
                    indexOfShortest = i;
            }
            if (indexOfShortest == goal && d[goal] == Integer.MAX_VALUE) {
                failed = true;
                break;
            }
            S.add(indexOfShortest);
            for (int i = 1; i < connections[indexOfShortest].length; i++) {
                if (connections[indexOfShortest][i] != 0 && (d[i] > d[indexOfShortest] + connections[indexOfShortest][i])) {
                    d[i] = d[indexOfShortest] + connections[indexOfShortest][i];
                    previous[i] = indexOfShortest;
                }
            }
        }
        if (failed)
            return -1;
        int j = goal;
        int count = 0;
        while (j != source) {
            count++;
            j = previous[j];
        }
        return count;
    }

    static boolean Scontains(LinkedList<Integer> S, int a) {
        for (Integer x : S)
            if (x.intValue() == a)
                return true;
        return false;
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
                return count;
            }
            for (int i = 1; i < connections[top].length; i++) {
                int a = connections[top][i];
                if (a != 0) {
                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                        previous[i] = top;
                    }
                }
            }
        }

        return -1;
    }


}

