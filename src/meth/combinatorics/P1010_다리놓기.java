package meth.combinatorics;

import java.math.BigInteger;
import java.util.Scanner;

public class P1010_다리놓기 {
        private static Scanner sc = new Scanner(System.in);
        public static void main(String[] args){
            int N = sc.nextInt();
            for(int i=0; i<N; i++){
                int west = sc.nextInt();
                int east = sc.nextInt();
                if( west == 0  || east == west){
                    System.out.println(1);
                    continue;
                }
                BigInteger denominator = getFactorial(BigInteger.valueOf(east-west)).multiply(getFactorial(BigInteger.valueOf(west)));
                BigInteger molecule = getFactorial(BigInteger.valueOf(east));
                System.out.println(molecule.divide(denominator));
            }
        }
        static BigInteger getFactorial(BigInteger number){
            if(number.compareTo(BigInteger.valueOf(1)) == 0)  return number;
            return number.multiply(getFactorial(number.subtract(BigInteger.valueOf(1))));
        }

}
