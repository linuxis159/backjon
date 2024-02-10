package math.encrypyion;

import java.math.BigInteger;
import java.util.Scanner;

public class p3734_RSA인수분해 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        BigInteger N = sc.nextBigInteger();
        int K = sc.nextInt();
        BigInteger p = null;
        BigInteger q = null;

        BigInteger NSqurt = N.sqrt().add(BigInteger.valueOf(1));
        for(BigInteger i = BigInteger.valueOf(2); i.compareTo(NSqurt) == -1; i = i.nextProbablePrime()){
            if(N.mod(i).compareTo(BigInteger.valueOf(0)) == 0) {
                p = i;
                break;
            }
        }
        for(BigInteger i = p.nextProbablePrime(); BigInteger.valueOf(100000).compareTo(p.multiply(BigInteger.valueOf((K))).abs()) == 1; i.nextProbablePrime()){
            if(N.mod(i).compareTo(BigInteger.valueOf(0)) == 0) {
                q = i;
                break;
            }
        }
        System.out.println(p + " * " + q);


    }
}
