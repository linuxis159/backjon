package graph.dijkstra;
import java.util.*;

public class P11779_최소비용구하기2 {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Integer, Node> allNodeMap = new HashMap();
    private static int[] pathValue;
    private static Queue<Node> priorityQueue = new PriorityQueue();
    private static boolean[] visit;

    private static Stack<Integer> routeStack = new Stack();
    public static void main(String[] args){
        int N = sc.nextInt();
        int M = sc.nextInt();
        pathValue = new int[N+1];
        visit = new boolean[N+1];
        Arrays.fill(pathValue,100000000);
        Arrays.fill(visit, false);
        for(int i=0; i<M; i++){
            int from    = sc.nextInt();
            int to      = sc.nextInt();
            int weight  = sc.nextInt();

            Node fromNode;
            Node toNode;
            if(allNodeMap.get(from) == null){
                fromNode = new Node(from);
                allNodeMap.put(from, fromNode);
            }
            else fromNode = allNodeMap.get(from);

            if(allNodeMap.get(to) == null){
                toNode = new Node(to);
                allNodeMap.put(to, toNode);
            }
            else toNode = allNodeMap.get(to);

            fromNode.addEdge(to, weight);
            toNode.addRequiredNodeMap(from,weight);
        }
        int from = sc.nextInt();
        int to = sc.nextInt();

        priorityQueue.add(allNodeMap.get(from));
        pathValue[from] = 0;
        visit[from] = true;

        travel();
        track(to, from);
        System.out.println(pathValue[to]);
        System.out.println(routeStack.size());
        while(!routeStack.empty()){
            System.out.print(routeStack.pop()+" ");
        }




    }
    static void travel(){
        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            Set<Integer> nodeNumSet = node.edgeMap.keySet();
            for (int edgeNodeNum : nodeNumSet) {
                if (pathValue[node.nodeNum] + node.edgeMap.get(edgeNodeNum) < pathValue[edgeNodeNum]) {
                    pathValue[edgeNodeNum] = pathValue[node.nodeNum] + node.edgeMap.get(edgeNodeNum);
                    if (!visit[edgeNodeNum]) {
                        priorityQueue.add(allNodeMap.get(edgeNodeNum));
                        visit[edgeNodeNum] = true;
                    }
                }
            }
        }}

    static void track(int nodeNum, int from){
        routeStack.push(nodeNum);
        if(nodeNum == from){
            return;
        }
        Node node = allNodeMap.get(nodeNum);
        int min = 100000000;
        int minNodeNum = -1;
        for(int edgeNum : node.requiredNodeMap.keySet()){
            if(min > pathValue[allNodeMap.get(edgeNum).nodeNum] + node.requiredNodeMap.get(edgeNum)){
                min = pathValue[allNodeMap.get(edgeNum).nodeNum] + node.requiredNodeMap.get(edgeNum);
                minNodeNum = edgeNum;
            }
        }
        track(minNodeNum, from);
    }

    static private class Node implements Comparable<Node>{
        int nodeNum;
        Map<Integer, Integer> edgeMap = new HashMap();
        Map<Integer, Integer> requiredNodeMap = new HashMap();
        private Node(int nodeNum){
            this.nodeNum = nodeNum;
        }
        void addEdge(int to, int cost){
            if(edgeMap.get(to) != null){
                if(edgeMap.get(to) > cost){
                    edgeMap.put(to, cost);
                }
            }
            else edgeMap.put(to, cost);
        }
        void addRequiredNodeMap(int from, int cost){
            if(requiredNodeMap.get(from) != null){
                if(requiredNodeMap.get(from) > cost){
                    requiredNodeMap.put(from, cost);
                }
            }
            else requiredNodeMap.put(from, cost);
        }
        @Override
        public int compareTo(Node o) {
            return pathValue[this.nodeNum] - pathValue[o.nodeNum];
        }
    }
}
