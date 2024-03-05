package dp;

import java.util.Scanner;

public class P1149_RGB거리 {
    static Scanner sc = new Scanner(System.in);
    static int[][] dp;
    public static void main(String[] args){
        int N = sc.nextInt();
        dp = new int[N][3];
        dp[0][0] = sc.nextInt();
        dp[0][1] = sc.nextInt();
        dp[0][2] = sc.nextInt();
        for(int i=1; i<N; i++){
            int red = sc.nextInt();
            int green = sc.nextInt();
            int blue = sc.nextInt();
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + red;
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + green;
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + blue;
        }
        System.out.println(Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]));
    }
}
