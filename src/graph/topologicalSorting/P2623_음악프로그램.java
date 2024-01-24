package graph.topologicalSorting;

import java.util.*;

public class P2623_음악프로그램 {
       private static Scanner sc = new Scanner(System.in);
       private static Map<Integer,Node> allNode = new HashMap();
       private static Queue<Integer> queue = new LinkedList();
       public static void main(String[] args){
           int singerCnt = sc.nextInt();
           int PDcnt = sc.nextInt();

           int from = sc.nextInt();
           int to = 0;
           while(sc.hasNext()) {
               to = sc.nextInt();
               System.out.println(from+","+to);
               Node fromNode;
               Node toNode;
               if (allNode.get(from) == null) {
                   fromNode = new Node(from);
                   allNode.put(from, fromNode);
               } else fromNode = allNode.get(from);
               if (allNode.get(to) == null) {
                   toNode = new Node(to);
                   allNode.put(to, toNode);
               } else toNode = allNode.get(to);

               fromNode.edgeNodeNumList.add(to);
               toNode.requiredNodeNumList.add(from);
               from = to;
           }


           for(int nodeNum : allNode.keySet()){
               Node node = allNode.get(nodeNum);
               if(node.requiredNodeNumList.size() == 0) {
                   queue.add(node.nodeNum);
                   node.visit = true;
               }
           }

           while(queue.size() != singerCnt){
               int nodeNum = queue.peek();
               Node thisNode =  allNode.get(nodeNum);
               thisNode.visit = true;
               for(int edgeNodeNum : thisNode.edgeNodeNumList){
                   Node edgeNode = allNode.get(edgeNodeNum);
                   edgeNode.requiredNodeNumList.remove(thisNode.nodeNum);
                   if(edgeNode.requiredNodeNumList.size() == 0 && edgeNode.visit == false){
                       queue.add(edgeNodeNum);
                   }
               }
           }

           for(int num : queue)
               System.out.println(num);


       }
       private static class Node{
           int nodeNum;
           boolean visit = false;
           private List<Integer> edgeNodeNumList = new ArrayList();
           private List<Integer> requiredNodeNumList = new ArrayList();
           private Node(int nodeNum){
               this.nodeNum = nodeNum;
           }
       }
}
