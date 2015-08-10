import java.util.LinkedList;
public class bfsattempt {
    public static void main(String[] args) {
        //        graph = {
        //                '1': ['2', '3', '4'],
        //                '2': ['5', '6'],
        //                '5': ['9', '10'],
        //                '4': ['7', '8'],
        //                '7': ['11', '12']
        //        }
        LinkedList<Node> graph = new LinkedList<Node>();
        graph.add(new Node(0));
        graph.add(new Node(1));
        graph.add(new Node(2));
        graph.add(new Node(3));
        graph.add(new Node(4));
        graph.add(new Node(5));
        graph.add(new Node(6));
        graph.add(new Node(7));
        graph.add(new Node(8));
        graph.add(new Node(9));
        graph.add(new Node(10));
        graph.add(new Node(11));
        graph.add(new Node(12));
        graph.get(1).adj.add(2);
        graph.get(1).adj.add(3);
        graph.get(1).adj.add(4);
        graph.get(2).adj.add(6);
        graph.get(2).adj.add(5);
        graph.get(5).adj.add(10);
        graph.get(5).adj.add(9);
        graph.get(4).adj.add(8);
        graph.get(4).adj.add(7);
        graph.get(7).adj.add(12);
        graph.get(7).adj.add(11);

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.push(graph.get(1));
        boolean visited[] = new boolean[13];
        int previous[] = new int[13];
        while (!queue.isEmpty()) {
            Node top = queue.getFirst();
            queue.removeFirst();
            if (top.index == 11) {
                int x = 11;
                String str = "";
                while (x != 1) {
                    str += " " + x;
                    x = previous[x];
                }
                str += " " + x;
                str = new StringBuilder(str).reverse().toString();
                System.out.println(str);
                break;
            }
            for (Integer a : top.adj) {
                if (!visited[a]) {
                    queue.add(graph.get(a));
                    visited[a] = true;
                    previous[a] = top.index;
                }
            }
        }
    }
}

class Node {
    LinkedList<Integer> adj = new LinkedList<Integer>();
    int index = -1;
    public Node(int index) {
        this.index = index;
    }
}
