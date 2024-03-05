package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P2579_계단오르기 {
    static Scanner sc = new Scanner(System.in);
    static int[] dp;
    static int[] num;
    public static void main(String[] args){
        int N = sc.nextInt();
        num = new int[N+1];
        dp = new int[N+1];
        for(int i=1; i<=N; i++){
            num[i] = sc.nextInt();
        }
        if(N == 1){
            System.out.println(num[1]);
            return;
        }
        else if(N == 2){
            System.out.println(num[1] + num[2]);
            return;
        }
        else if(N == 3){
            int result = 0;
            if(num[1] > num[2]){
                result= num[1] + num[3];
            }
            else
                result = num[2] + num[3];
            System.out.println(result);
            return;
        }
        dp[1] = num[1];
        dp[2] = num[1] + num[2];
        if(num[1] > num[2]){
            dp[3] = num[1] + num[3];
        }
        else
            dp[3] = num[2] + num[3];

        for(int i = 4; i<=N; i++){
            if(dp[i-3] + num[i-1] > dp[i-2]){
                dp[i] = dp[i-3] + num[i-1] + num[i];
            }
            else
                dp[i] = dp[i-2] + num[i];
        }
        System.out.println(dp[N]);

    }
}
