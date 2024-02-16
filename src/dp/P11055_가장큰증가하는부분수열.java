package dp;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11055_가장큰증가하는부분수열 {

static Scanner sc = new Scanner(System.in);
    static int N;
    static int[][] dp;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new int[2][N];
         StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num =  Integer.parseInt(st.nextToken());
            dp[1][i] = num;
            dp[0][i] = num;
            boolean flag = false;
            int repre = 0;
            int max = num;
            for(int j=i-1; j>=0; j--){
                if(num > dp[1][j] && repre < dp[1][j]){
                    flag = true;
                    repre = dp[1][j];
                    if(dp[0][j] + num > max)
                        max = dp[0][j] + num;
                    }
            }
            dp[0][i] = max;
            if(dp[0][i] > result)
                result = dp[0][i];

        }
        bw.write(String.valueOf(result));

        bw.close();
        br.close();
    }

}
