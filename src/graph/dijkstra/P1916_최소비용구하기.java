package graph.dijkstra;

import java.util.*;

public class P1916_최소비용구하기 {
    private static Scanner sc = new Scanner(System.in);
    private static boolean visit[];
    private static int pathValue[];
    private static Queue<Node> queue = new PriorityQueue();
    private static Map<Integer, Node> allNode = new HashMap();
    public static void main(String[] args){
        int N = sc.nextInt();
        int M = sc.nextInt();
        visit = new boolean[N];
        pathValue = new int[N];
        Arrays.fill(pathValue, 100000000);
        Arrays.fill(visit, false);

        for(int i=0; i<M; i++){
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();
            Node fromNode;
            Node toNode;
            if(allNode.get(from) == null) {
                fromNode = new Node(from);
                allNode.put(from, fromNode);
            }
            else fromNode = allNode.get(from);
            if(allNode.get(to) == null) {
                toNode = new Node(to);
                allNode.put(to, toNode);
            }
            else toNode = allNode.get(to);
            fromNode.addEdge(to, cost);

        }

        int startNodeNum = sc.nextInt() - 1;
        int endNodeNum = sc.nextInt() - 1;
        pathValue[startNodeNum] = 0;
        Node startNode = allNode.get(startNodeNum);
        queue.add(startNode);
        travel();

        System.out.println(pathValue[endNodeNum]);


    }
    private static class Node implements Comparable<Node>{
        int NodeNum;
        Map<Integer, Integer> edgeMap = new HashMap();

        private Node(int nodeNum){
            this.NodeNum = nodeNum;
        }
        void addEdge(int to, int cost){
            if(edgeMap.get(to) != null){
                if(edgeMap.get(to) > cost){
                    edgeMap.put(to, cost);
                }
            }
            else edgeMap.put(to, cost);

        }

        @Override
        public int compareTo(Node o) {
            return pathValue[this.NodeNum] - pathValue[o.NodeNum];
        }
    }

    static void travel(){
        while(!queue.isEmpty()) {
            Node thisNode = queue.poll();
            if(visit[thisNode.NodeNum])
                continue;
            visit[thisNode.NodeNum] = true;
            for (int edgeNodeNum : thisNode.edgeMap.keySet()) {
                if (pathValue[edgeNodeNum] > pathValue[thisNode.NodeNum] + thisNode.edgeMap.get(edgeNodeNum)) {
                    pathValue[edgeNodeNum] = pathValue[thisNode.NodeNum] + thisNode.edgeMap.get(edgeNodeNum);
                    queue.add(allNode.get(edgeNodeNum));
                }
            }
        }


    }
}
