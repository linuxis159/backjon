package string;

import java.math.BigInteger;
import java.util.Scanner;

public class P3033_가장긴문자열_라빈카프 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        String string = sc.next();
        System.out.println(getHash(string).mod(BigInteger.valueOf(1234567891)));
    }
    static BigInteger getHash(String target){
        BigInteger result = BigInteger.valueOf(0);
        for(int i=0; i<target.length(); i++){
            int num = target.charAt(i);
            result = result.add(BigInteger.valueOf(num % 96).multiply(BigInteger.valueOf(31).pow(i)));
        }
        return result;

    }
}
