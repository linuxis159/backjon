package datastructure.queue.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1655_가운데를말해요 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder builder = new StringBuilder();
    static Queue<Integer> priorityQueue = new PriorityQueue();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

        }
    }
/*    private static class NumWrapper implements Comparable<NumWrapper>{
        int num

        @Override
        public int compareTo(NumWrapper o) {
            return
        }
    }*/
}
