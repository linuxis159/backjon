package dp;

import java.util.Scanner;
public class P9095{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            int dp[] = new int[N+1];
            dp[1] = 1;
            if(N >= 2)
                dp[2] = 2;
            if(N >= 3)
                dp[3] = 4;
            for(int j=4; j<=N; j++){
                dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
            }
            System.out.println(dp[N]);
        }

    }
}