package graph;

import dfs_bfs.P1260Silver2;

import java.nio.file.WatchEvent;
import java.util.*;

/*
문제

방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력

첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다.
셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력

첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다.
시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.

5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/
public class P1753_최단경로 {
    public static Scanner sc = new Scanner(System.in);
    static int[] shortestPathValue;
    static boolean[] visit;

    public static void main(String[] args) {


        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int startVertexNum = sc.nextInt();
        shortestPathValue = new int[vertexCount+1];
        visit = new boolean[vertexCount+1];
        for (int i = 1; i <shortestPathValue.length; i++) {
            shortestPathValue[i] = 999999;
            visit[i] = false;
        }

        for (int i = 0; i < edgeCount; i++) {
            int fromVertexNum = sc.nextInt();
            int toVertexNum = sc.nextInt();
            int weight = sc.nextInt();
            Vertex fromVertex = Vertex.vertexMap.get(fromVertexNum);
            Vertex toVertex = Vertex.vertexMap.get(toVertexNum);

            if (fromVertex == null) fromVertex = new Vertex(fromVertexNum);

            if (toVertex == null) toVertex = new Vertex(toVertexNum);

            fromVertex.addToVertex(toVertex, weight);
        }

        Vertex travelStartVertex = Vertex.vertexMap.get(startVertexNum);
        shortestPathValue[startVertexNum] = 0;
        travelStartVertex.travel();
        for(int i=1; i<shortestPathValue.length; i++){
            if(shortestPathValue[i] == 999999){
                System.out.println("INF");
            }
            else{
                System.out.println(shortestPathValue[i]);
            }
        }

    }

    private static class Vertex {

        int vertexNum;
        static Map<Integer, Vertex> vertexMap = new HashMap();
        List<Vertex> toVertexList = new ArrayList();
        Map<Integer, Integer> edgeMap = new HashMap();

        public Vertex(int vertexNum) {
            this.vertexNum = vertexNum;
            vertexMap.put(vertexNum, this);
        }

        public void addToVertex(Vertex toVertex, int weight) {
            if(toVertexList.contains(toVertex)){
                if(edgeMap.get(toVertex.vertexNum) > weight){
                    edgeMap.put(toVertex.vertexNum, weight);
                }
                return;
            }

            this.toVertexList.add(toVertex);
            this.edgeMap.put(toVertex.vertexNum, weight);
        }


        public void travel() {
            visit[this.vertexNum] = true;
            Integer[] toVertexNumArr = Arrays.stream(edgeMap.keySet().toArray())
                    .map(o -> (Integer) o)
                    .toArray(Integer[]::new);


            for(int vertexNum : toVertexNumArr){
                if(shortestPathValue[vertexNum] > shortestPathValue[this.vertexNum] + edgeMap.get(vertexNum)){
                    shortestPathValue[vertexNum] = shortestPathValue[this.vertexNum] + edgeMap.get(vertexNum);
                }
            }
            while(true) {
                int selectedVertexNum = getMinWeightVertexNum(toVertexNumArr);
                if (selectedVertexNum == -9) {
                    return;
                }
                Vertex nextVertex = vertexMap.get(selectedVertexNum);
                nextVertex.travel();

            }
        }




        int getMinWeightVertexNum(Integer[] vertexNumArr){
            int selectedVetexNum = -9;
            int minWeight = 99999;
            for (int vertexNum : vertexNumArr) {
                if(visit[vertexNum] == false) {
                    int weight = shortestPathValue[vertexNum];
                    if (minWeight > weight) {
                        minWeight = weight;
                        selectedVetexNum = vertexNum;
                    }
                }else{
                    continue;
                }
            }
            return selectedVetexNum;
        }
        void visit(Vertex vertex){

        }
    }
}
