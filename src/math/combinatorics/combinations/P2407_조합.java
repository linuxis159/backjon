package math.combinatorics.combinations;

import java.math.BigInteger;
import java.util.Scanner;

public class P2407_조합 {
    static BigInteger[] dp;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        int M = sc.nextInt();

        BigInteger result = getFactorial(N).divide(getFactorial(N-M).multiply(getFactorial(M)));
        System.out.println(result);


    }

    static BigInteger getFactorial(int number){
        dp = new BigInteger[number+1];
        dp[1] = BigInteger.valueOf(1);
        for(int i=2; i<=number; i++){
            dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
        }

        return dp[number];
    }
}
