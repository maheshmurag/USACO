
import java.lang.String;
import java.lang.System;
import java.util.Arrays;
import java.util.LinkedList;

public class DijkstraAttempt {
    public static void main(String[] args) {
        //based on this graph: https://en.wikipedia.org/wiki/File:Dijkstra_Animation.gif
        int source = 1, goal = 5;
        int[][] grid =
                {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 7, 9, 0, 0, 14},
                        {0, 7, 0, 10, 15, 0, 0},
                        {0, 9, 10, 0, 11, 0, 2},
                        {0, 0, 15, 11, 0, 6, 0},
                        {0, 0, 0, 0, 6, 0, 9},
                        {0, 14, 0, 2, 0, 9, 0},
                };
        //<editor-fold desc="comment for old graph">
        /*LinkedList<Node> graph = new LinkedList<Node>();*/
        /*graph.add(new Node(0, 0));
        graph.add(new Node(1, 0));
        graph.add(new Node(2, 0));
        graph.add(new Node(3, 0));
        graph.add(new Node(4, 0));
        graph.add(new Node(5, 0));
        graph.add(new Node(6, 0));
        graph.get(1).adj.add(new Node(6, 14));
        graph.get(1).adj.add(new Node(3, 9));
        graph.get(1).adj.add(new Node(2, 7));
        graph.get(2).adj.add(new Node(3, 10));
        graph.get(2).adj.add(new Node(4, 15));
        graph.get(2).adj.add(new Node(6, 14));
        graph.get(3).adj.add(new Node(6, 2));
        graph.get(3).adj.add(new Node(4, 11));
        graph.get(6).adj.add(new Node(5, 9));
        graph.get(4).adj.add(new Node(5, 6));*/

        /*TreeSet<Node> priQueue = new TreeSet<Node>();
        priQueue.add(graph.get(source));
*/


        /*for (Node x : graph.get(source).adj)
            d[x.index] = x.cost;*/
        /*System.out.print(Arrays.toString(d));
        System.out.println(Arrays.toString(priQueue.toArray()));
        */
        //</editor-fold>
        int previous[] = new int[7];
        LinkedList<Integer> S = new LinkedList<Integer>();
        int d[] = new int[7];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[source] = 0;

        int indexOfShortest;
        while (S.size() != 6) {
            indexOfShortest = goal;
            for (int i = 1; i < d.length; i++) {
                if (d[i] < d[indexOfShortest] && !Scontains(S, i)) {
                    indexOfShortest = i;
                }
            }
            S.add(indexOfShortest);
            //relax
            for (int i = 1; i < grid[indexOfShortest].length; i++) {
                if (grid[indexOfShortest][i] != 0 && (d[i] > d[indexOfShortest] + grid[indexOfShortest][i])) {
                    d[i] = d[indexOfShortest] + grid[indexOfShortest][i];
                    previous[i] = indexOfShortest;
                }
            }
        }
        int j = goal;
        String str = "";
        while (j != source) {
            str += (j + " ");
            j = previous[j];
        }
        str += source + " ";
        System.out.println(new StringBuilder(str).reverse().toString());
    }

    public static boolean Scontains(LinkedList<Integer> S, int a) {
        for (Integer x : S)
            if (x.intValue() == a)
                return true;
        return false;
    }
}
