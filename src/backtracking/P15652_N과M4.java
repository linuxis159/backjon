package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class P15652_N과M4 {
    private static Scanner sc = new Scanner(System.in);
    static int N;
    static int M;
    static int[] result;
    public static void main(String[] args){
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];
        dfs(0, 0);
    }
    static void dfs(int depth, int startIndex){
        if(depth == M){
            Arrays.stream(result).forEach(
                    num -> System.out.print(num + " ")
            );
            System.out.println();
            return;
        }
        for(int i=startIndex; i<N; i++){
            result[depth] = i+1;
            dfs(depth+1, i);
        }
    }
}
