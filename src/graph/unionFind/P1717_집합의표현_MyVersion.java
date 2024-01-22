package graph.unionFind;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1717_집합의표현_MyVersion {
    public static Scanner sc = new Scanner(System.in);
    public static Map<Integer, Node> allNode = new HashMap();
    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int flag = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            Node aNode;
            Node bNode;

            if (allNode.containsKey(a)) aNode = allNode.get(a);
            else {
                aNode = new Node(a);
                allNode.put(a, aNode);
            }

            if (allNode.containsKey(b)) bNode = allNode.get(b);
            else {
                bNode = new Node(b);
                allNode.put(b, bNode);
            }

            if (flag == 0) {
                if (aNode.parentIndex > bNode.parentIndex) {
                    for (Integer childrenIndex : aNode.childrenIndex) {
                        allNode.put(childrenIndex, bNode);
                    }
                    bNode.merge(aNode.childrenIndex);
                }

                else if (aNode.parentIndex < bNode.parentIndex) {
                    for (Integer childrenIndex : bNode.childrenIndex) {
                        allNode.put(childrenIndex, aNode);
                    }
                    aNode.merge(bNode.childrenIndex);
                }

            } else {
                if (aNode.parentIndex == bNode.parentIndex)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }

    static private class Node {
        int parentIndex;
        List<Integer> childrenIndex = new ArrayList();

        private Node(int myIndex) {
            this.parentIndex = myIndex;
            childrenIndex.add(myIndex);
        }

        void merge(List<Integer> indexList) {
            childrenIndex.addAll(indexList);
        }

        void merge(int parentIndex) {
            this.parentIndex = parentIndex;
        }

    }
}
