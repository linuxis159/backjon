package graph.topologicalSorting;

import java.util.*;

public class P2623_음악프로그램 {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Integer,Node> allNode = new HashMap();
    private static Queue<Integer> queue = new LinkedList();
    private static Queue<Integer> resultQueue = new LinkedList();
    public static void main(String[] args){
        int singerCnt = sc.nextInt();
        int PDcnt = sc.nextInt();

        for(int i=0; i<singerCnt; i++){
            allNode.put(i+1, new Node(i+1));
        }

        for(int i=0; i<PDcnt; i++){
            int cnt = sc.nextInt();
            int from = sc.nextInt();
            for(int j=0; j<cnt-1; j++) {
                int to = sc.nextInt();

                Node fromNode = allNode.get(from);
                Node toNode = allNode.get(to);

                fromNode.edgeNodeNumList.add(to);
                toNode.requiredNodeNumList.add(from);
                from = to;
            }
        }



        for(int nodeNum : allNode.keySet()){
            Node node = allNode.get(nodeNum);
            if(node.requiredNodeNumList.size() == 0) {
                queue.add(node.nodeNum);
                node.visit = true;
            }
        }

        while(!queue.isEmpty()){
            int nodeNum = queue.poll();
            resultQueue.add(nodeNum);
            Node thisNode =  allNode.get(nodeNum);
            for(int edgeNodeNum : thisNode.edgeNodeNumList){
                Node edgeNode = allNode.get(edgeNodeNum);
                edgeNode.requiredNodeNumList.remove(thisNode.nodeNum);
                if(edgeNode.requiredNodeNumList.size() == 0){
                    if(edgeNode.visit) continue;
                    else{
                        edgeNode.visit = true;
                        queue.add(edgeNodeNum);
                    }
                }
            }
        }

        if(resultQueue.size() != singerCnt){
            System.out.println(0);
        }

        else {
            for (int num : resultQueue)
                System.out.println(num);
        }


    }
    private static class Node{
        int nodeNum;
        boolean visit = false;
        private List<Integer> edgeNodeNumList = new ArrayList();
        private Set<Integer> requiredNodeNumList = new HashSet();
        private Node(int nodeNum){
            this.nodeNum = nodeNum;
        }
    }
}
