package math.numberTheory;

import java.util.Scanner;

public class P2609_최대공약수와최대공배수 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        int M = sc.nextInt();
        int bigger = 0;
        int smaller = 0;
        int LCD = 0;
        if(N > M) {
            bigger = N;
            smaller = M;
        }
        else {
            bigger = M;
            smaller = N;
        }
        while(bigger % smaller != 0){
            bigger %= smaller;
            if(bigger < smaller){
                int temp = bigger;
                bigger = smaller;
                smaller = temp;
            }
        }
        LCD = smaller;
        System.out.println(LCD);
        System.out.println((N * M) / LCD);

    }
}
