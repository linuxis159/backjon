package graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P20040_사이클게임 {
    static int connectedCount = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<EdgeInfo> priorityQueue = new PriorityQueue();
    static int[] vertexUnionNum = new int[10001];
    static long totalWeight = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        for(int i=1; i<=10000; i++) vertexUnionNum[i] = i;
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            EdgeInfo edgeInfo = new EdgeInfo(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            priorityQueue.add(edgeInfo);
        }
        while(connectedCount != V-1){
            EdgeInfo edgeInfo = priorityQueue.poll();
            int V1Parent = getParent(edgeInfo.V1);
            int V2Parent = getParent(edgeInfo.V2);
            if(V1Parent == V2Parent)
                continue;
            else {
                if(V1Parent > V2Parent){
                    vertexUnionNum[V1Parent] = edgeInfo.V2;
                }
                else{
                    vertexUnionNum[V2Parent] = edgeInfo.V1;
                }
                connectedCount++;
                totalWeight += edgeInfo.weight;
            }

        }
        System.out.println(totalWeight);
    }
    static class EdgeInfo implements Comparable<EdgeInfo>{
        int num;
        int V1;
        int V2;
        int weight;
        EdgeInfo(int V1, int V2, int weight){
            this.V1 = V1;
            this.V2 = V2;
            this.weight = weight;
        }

        @Override
        public int compareTo(EdgeInfo o) {
            return this.weight - o.weight;
        }
    }


    static int getParent(int index){
        if(vertexUnionNum[index] == index)
            return index;
        else
            return getParent(vertexUnionNum[index]);
    }
}
