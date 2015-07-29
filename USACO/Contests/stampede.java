import java.io.*;
import java.lang.Comparable;
import java.lang.Integer;
import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;


public class stampede {
    public static void main(String[] args) throws java.io.IOException {
        String prob = "stampede";
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        input.nextToken();
        int n = (int) input.nval;
        Event[] events = new Event[n * 2];
        int tmp1, tmp2, tmp3;
        for (int i = 0; i < events.length; i += 2) {
            input.nextToken();
            tmp1 = (int) input.nval;
            input.nextToken();
            tmp2 = (int) input.nval;
            input.nextToken();
            tmp3 = (int) input.nval;
            tmp1 *= -1 * tmp3;
            events[i] = new Event(tmp1 - tmp3, tmp2);
            events[i + 1] = new Event(tmp1, -1 * tmp2);
        }
        Arrays.sort(events);
        ArrayList<Integer> seen = new ArrayList<Integer>();
        ArrayList<Integer> active = new ArrayList<Integer>();
        for (int i = 0; i < events.length; ) {
            int j;
            for (j = i; j < events.length && events[i].time == events[j].time; j++) {
                if (events[j].y > 0)
                    active.add(events[j].y);
                else
                    active.remove(new Integer(-1 * events[j].y));
            }
            if (active.size() != 0)
                if(!seen.contains(active.get(0)))
                    seen.add(new Integer(active.get(0)));
            i = j;
        }
        output.println(seen.size());
        output.close();
    }

    static class Event implements Comparable<Event> {
        int time;
        int y;

        public Event(int t, int y) {
            this.time = t;
            this.y = y;
        }

        public String toString() {
            return time + ":" + y;
        }

        public int compareTo(Event o2) {//returns -1 if o1<o2
            return this.time-o2.time;

        }
    }
}

