package datastructure.queue.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1715_카드정렬하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder builder = new StringBuilder();
    static Queue<Integer> priorityQueue = new PriorityQueue();
    public static void main(String[] args) throws IOException {
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            priorityQueue.add(Integer.parseInt(st.nextToken()));
        }
        if( N == 1) {
            System.out.println(0);
            return;
        }
        else if( N == 2){
            System.out.println(priorityQueue.poll() + priorityQueue.poll());
            return;
        }


        while(priorityQueue.size() != 1){
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            int result = first + second;
            sum += result;
            priorityQueue.add(result);
        }
        System.out.println(sum);
    }
}
