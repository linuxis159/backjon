package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class P15651_N과M3 {
    private static Scanner sc = new Scanner(System.in);
    private static int resultArr[];
    private static int M;
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        N = sc.nextInt();
        M = sc.nextInt();
        resultArr = new int[M];

        dfs(0);
        System.out.print(sb);

    }

    static void dfs(int depth){
        if(depth == M) {
            Arrays.stream(resultArr).forEach(num ->
                    sb.append(num).append(" ")
            );
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            resultArr[depth] = i+1;
            dfs(depth + 1);
        }
    }
}

