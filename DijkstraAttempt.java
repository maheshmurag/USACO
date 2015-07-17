import java.lang.String;
import java.lang.System;
import java.util.Arrays;
import java.util.LinkedList;

public class DijkstraAttempt {
    public static void main(String[] args) {
        //based on this graph: https://en.wikipedia.org/wiki/File:Dijkstra_Animation.gif
        int source = 1, goal = 5;
        boolean failed = false;
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
        //initializes the graph with adjacency matrix (grid[x][y] = weight of edge between vertex x and vertex y
        int previous[] = new int[7];//initializes previous array
        LinkedList<Integer> S = new LinkedList<Integer>();//S array to store vertices whose distance has been calculated
        int d[] = new int[7];//d array to store vertices distances from source
        Arrays.fill(d, Integer.MAX_VALUE);//initializes d array with infinity, except for the source vertex
        d[source] = 0;

        int indexOfShortest;
        while (S.size() != 6) {//when everything has been processed
            indexOfShortest = goal;//initalize this with a big number, i.e. infinity (since d[goal] = infinity
            for (int i = 1; i < d.length; i++) {//find shortest d that hasnt already been processed (!S.contains(i))
                if (d[i] < d[indexOfShortest] && !Scontains(S, i))
                    indexOfShortest = i;
            }
            if(indexOfShortest == goal && d[goal] == Integer.MAX_VALUE){
                failed = true;
                break;
            }
            S.add(indexOfShortest);//adds it to S to signify its been processed
                for (int i = 1; i < grid[indexOfShortest].length; i++) {
            //relax:look through neighbors of u, see if you can shorten distance between source and i by going through u
                if (grid[indexOfShortest][i] != 0 && (d[i] > d[indexOfShortest] + grid[indexOfShortest][i])) {
                    d[i] = d[indexOfShortest] + grid[indexOfShortest][i];
                    previous[i] = indexOfShortest;
                }
            }
        }
        if(failed){
            System.out.println("No path found!");
        }
        else{
            System.out.println(Arrays.toString(d));
            int j = goal;
            String str = "";
            while (j != source) {
                str += (j + " ");
                j = previous[j];
            }
            str += source + " ";
            System.out.println(new StringBuilder(str).reverse().toString());

        }
    }

    public static boolean Scontains(LinkedList<Integer> S, int a) {
        for (Integer x : S)
            if (x.intValue() == a)
                return true;
        return false;
    }
}
