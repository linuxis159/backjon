package dp;

import java.util.Scanner;

public class P12852_1로만들기2 {
    static Scanner sc = new Scanner(System.in);
    static int dp[];
    static int dp2[];
    public static void main(String[] args){
        int N = sc.nextInt();
        if(N == 1){
            System.out.println(0);
            return;
        }
        else if(N == 2){
            System.out.println(1);
            return;
        }
        else if(N == 3){
            System.out.println(1);
            return;
        }
        dp = new int[N+1];
        dp2 = new int[N+1];
        dp[1] = 0;
        dp2[1] = 0;
        dp[2] = 1;
        dp2[2] = 1;
        dp[3] = 1;
        dp2[3] = 1;
        for(int i=4; i<=N; i++){
            int resultOne = 9000000;
            int resultTwo = 9000000;
            int resultThree = 9000000;
            int resultFour =9999999;
            if(i % 2 == 0){
                if(dp[i / 2] > dp[i-1]){
                    dp[i] = dp[i-1] + 1;
                    dp2[i] = i-1;
                }
                else{
                    dp[i] = dp[i / 2] + 1;
                    dp2[i] = i/2;
                }
            }
            if(i % 3 == 0){
                if(dp[i / 3] > dp[i-1]){
                    dp[i] = dp[i-1] + 1;
                    dp2[i] = i-1;
                }
                else{
                    dp[i] = dp[i / 3] + 1;
                    dp2[i] = i/3;
                }
            }



        }
        System.out.println(dp[N]);
    }
}
