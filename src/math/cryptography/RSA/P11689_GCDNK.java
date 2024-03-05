package math.cryptography.RSA;

import java.util.*;

public class P11689_GCDNK {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args){
        long N = sc.nextLong();
        long temp = N;
        for (long i = 2; (i * i) <= N; i++) {
            if (N % i == 0) {
                temp -= temp / i;
                while (N % i == 0) {
                    N /= i;
                }
            }
            else continue;
        }
        if(N > 1) temp -= temp / N;
        System.out.println(temp);

    }

}
