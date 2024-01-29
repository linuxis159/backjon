package tree;

import java.util.Scanner;

public class P2263_트리의순회 {
    static int[] inorder;
    static int[] postorder;
    static int[] preorder;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        inorder = new int[N];
        postorder = new int[N];
        postorder = new int[N];
        for(int i=0; i<2; i++){
            for(int j=0; j<N; j++){
                inorder[j] = sc.nextInt();
                postorder[j] = sc.nextInt();
            }
        }
    }
    static class Node{
        int nodeNum;
        Node leftNode;
        Node rightNode;
    }
}
