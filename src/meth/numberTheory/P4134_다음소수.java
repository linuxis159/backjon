package meth.numberTheory;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P4134_다음소수 {
    private static Scanner sc = new Scanner(System.in);
    private static Set<Long> primeNumSet = new HashSet();
    private static Set<Long> compositNumSet = new HashSet();
    public static void main(String[] args){
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            long num = sc.nextLong();
            if(num == 0 || num == 1 || num == 2){
                System.out.println(2);
                continue;
            }

            loopOut:
            for(long j=num;;j++){
                int numSqrt = (int)Math.sqrt(j) + 1;
                for(long k=2; k<=numSqrt; k++){
                    if(k == numSqrt) {
                        System.out.println(j);
                        break loopOut;
                    }
                    if(numSqrt % k == 0) {
                        break;
                    }
                }
            }
        }

    }
}
