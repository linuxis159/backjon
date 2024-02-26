package dp;

import java.util.Scanner;

public class P9095_1_2_3_더하기{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            int dp[] = new int[N+1];
            dp[1] = 1;
            if(N >= 2)
                dp[2] = 1;
            if(N >= 3)
                dp[3] = 4;
            if(N >= 4)
                dp[4] = 7;
            for(int j=4; j<=N; j++){
                dp[j] = (dp[j-1] * 2) -2;
            }
            System.out.println(dp[N]);
        }

    }
}
