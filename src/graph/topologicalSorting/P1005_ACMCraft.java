package graph.topologicalSorting;

import java.util.Scanner;

public class P1005_ACMCraft {
    public static Scanner sc = new Scanner(System.in);
    public static int[] buildingTime;
    public static int[][] buildingRule;
    public static void main(String[] args){
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            buildingTime = new int[N];
            buildingRule = new int[K][2];
            for(int j=0; j<N; j++){
                buildingTime[j] = sc.nextInt();
            }
            for(int k=0; k<K; k++){
                buildingRule[k][0] = sc.nextInt();
                buildingRule[k][1] = sc.nextInt();
            }
        }

    }
}
