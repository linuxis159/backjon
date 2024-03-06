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
            System.out.print(1);
            return;
        }
        else if(N == 2){
            System.out.println(1);
            System.out.print(2 + " " + 1);
            return;
        }
        else if(N == 3){
            System.out.println(1);
            System.out.print(3 + " " + 1);
            return;
        }
        dp = new int[N+1];
        dp2= new int[N+1];
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
            if(i % 2 == 0){
                resultOne = dp[i / 2] + 1;
            }
            if(i % 3 == 0){
                resultTwo = dp[i / 3] + 1;
            }

            resultThree = dp[i-1] + 1;
            dp[i] = Math.min(Math.min(resultOne, resultTwo),resultThree);
            if(dp[i] == resultOne){
                dp2[i] = i/2;
            }
            else if(dp[i] == resultTwo){
                dp2[i] = i/3;
            }
            else{
                dp2[i] = i-1;
            }
        }
        System.out.println(dp[N]);
        for(int i = N; i != 1; ){
            System.out.print(i +" ");
            i = dp2[i];
        }
        System.out.print(1);

    }
}
