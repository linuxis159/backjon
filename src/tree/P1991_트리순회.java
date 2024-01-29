package tree;

import java.util.*;

public class P1991_트리순회 {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String,Node> allNodeMap = new HashMap();
    public static void main(String[] args){
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            String nodeName = sc.next();
            String leftNodeName = sc.next();
            String rightNodeName = sc.next();

            Node node;
            Node leftNode;
            Node rightNode;
            if(leftNodeName.equals(".")) leftNode = null;
            else if(allNodeMap.get(leftNodeName) == null) {
                leftNode = new Node(leftNodeName, null, null);
                allNodeMap.put(leftNodeName, leftNode);
            }
            else leftNode = allNodeMap.get(leftNodeName);

            if(rightNodeName.equals(".")) rightNode = null;
            else if(allNodeMap.get(rightNodeName) == null) {
                rightNode = new Node(rightNodeName, null, null);
                allNodeMap.put(rightNodeName, rightNode);
            }
            else rightNode = allNodeMap.get(rightNodeName);

            if(allNodeMap.get(nodeName) == null) {
                node = new Node(nodeName, leftNode, rightNode);
                allNodeMap.put(nodeName, node);
            }
            else node = allNodeMap.get(nodeName);

            node.leftNode = leftNode;
            node.rightNode = rightNode;

        }
        Node rootNode = allNodeMap.get("A");
        rootNode.travelPreorder(rootNode);
        System.out.println();
        rootNode.travelInorder(rootNode);
        System.out.println();
        rootNode.traverPostorder(rootNode);


    }
    private static class Node{
        String my;
        Node leftNode;
        Node rightNode;
        private Node(String my, Node leftNode, Node rightNode){
            this.my = my;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
        void travelPreorder(Node node){
            if(node == null)
                return;
            System.out.print(node.my);
            travelPreorder(node.leftNode);
            travelPreorder(node.rightNode);
        }
        void travelInorder(Node node){
            if(node == null)
                return;
            travelInorder(node.leftNode);
            System.out.print(node.my);
            travelInorder(node.rightNode);
        }
        void traverPostorder(Node node){
            if(node == null)
                return;
            traverPostorder(node.leftNode);
            traverPostorder(node.rightNode);
            System.out.print(node.my);
        }

    }
}
