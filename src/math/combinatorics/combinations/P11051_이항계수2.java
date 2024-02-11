package math.combinatorics.combinations;

import java.math.BigInteger;
import java.util.Scanner;

public class P11051_이항계수2 {
    static BigInteger[] dp;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        int K = sc.nextInt();
        if( K == 0  || N == K){
            System.out.println(1);
            return;
        }
        BigInteger NFactorial = getFactorial(N);
        BigInteger KFactorial = getFactorial(K);
        BigInteger dominator = getFactorial(N-K).multiply(getFactorial(K));
        BigInteger molecule = getFactorial(N);
        System.out.println(molecule.divide(dominator).mod(BigInteger.valueOf(10007)));

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
