package math.combinatorics;

import java.util.Scanner;

public class P11050_이항계수 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        int K = sc.nextInt();
        if( K == 0  || N == K){
            System.out.println(1);
            return;
        }
        int denominator = getFactorial(N-K) * getFactorial(K);
        int molecule = getFactorial(N);
        System.out.println(molecule / denominator);


    }
    static int getFactorial(int number){
        if(number == 1 || number == 0)  return number;
        return number * getFactorial(number -1);
    }
}
