package dp;

import java.util.Scanner;

public class P11055_가장큰증가하는부분수열 {
    static Scanner sc = new Scanner(System.in);
    static int dp[][];
    static int result = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        dp = new int[N][N];
        for(int i=0; i<N; i++){
            int num = sc.nextInt();
            for(int j=0; j<=i; j++){
                dp[j][j]
            }

        }
        System.out.println(result);
    }
}
