package tree;

import java.util.*;

public class P1068_트리 {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Integer, Node> nodeMap = new HashMap();
    private static int removeNodeNum;
    private static int leafNodeCnt = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        int rootNodeNum = -1;
        for(int i=0; i<N; i++){
            Node node;
            if(nodeMap.get(i) == null) {
                node = new Node(i);
                nodeMap.put(i, node);
            } else node = nodeMap.get(i);

            int parentNodeNum = sc.nextInt();
            if(parentNodeNum == -1) {
                rootNodeNum = i;
                continue;
            }
            else{
                Node parentNode = null;
                if(nodeMap.get(parentNodeNum) == null) {
                    parentNode = new Node(parentNodeNum);
                    nodeMap.put(parentNodeNum, parentNode);
                }
                else parentNode = nodeMap.get(parentNodeNum);
                parentNode.addChildrenNode(node);
            }
        }

        removeNodeNum = sc.nextInt();
        if(rootNodeNum == removeNodeNum)
            nodeMap.put(rootNodeNum, null);
        travelForRemove(nodeMap.get(rootNodeNum));
        travel(nodeMap.get(rootNodeNum));
        System.out.println(leafNodeCnt);


    }
    private static void travelForRemove(Node node){
        if(node == null)
            return;
        for(Node leafNode : node.children){
            if(leafNode.nodeNum == removeNodeNum){
                node.children.remove(leafNode);
                return;
            }
        }

        for(Node leafNode : node.children) {
            travelForRemove(leafNode);
        }
    }
    private static void travel(Node node){
        if(node == null) return;
        if(node.children.size() == 0){
            leafNodeCnt++;
            return;
        }
        for(Node leaftNode : node.children) {
            travel(leaftNode);
        }
    }

    private static class Node{
        int nodeNum;
        int parentNodeNum;
        List<Node> children = new ArrayList();

        Node(int nodeNum){
            this.nodeNum = nodeNum;
        }

        public void addChildrenNode(Node node) {
            children.add(node);
        }
    }

}
