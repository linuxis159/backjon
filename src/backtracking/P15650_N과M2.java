package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class P15650_N과M2 {
    private static Scanner sc = new Scanner(System.in);
    private static boolean visit[];
    private static int arr[];
    private static int resultArr[];
    private static int M;
    private static int N;

    public static void main(String[] args){
        N = sc.nextInt();
        M = sc.nextInt();
        resultArr = new int[M];
        visit = new boolean[N];
        Arrays.fill(visit, false);

        dfs(0,0);
    }

    static void dfs(int depth, int startIndex){
        if(depth == M) {
            Arrays.stream(resultArr).forEach(num ->
                    System.out.print(num + " ")
            );
            System.out.println();
            return;
        }

        for(int i=startIndex; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                resultArr[depth] = i+1;
                dfs(depth + 1, i+1);
                visit[i] = false;
            }
        }
    }
}
