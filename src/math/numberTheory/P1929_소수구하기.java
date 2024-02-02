package math.numberTheory;

import java.util.Scanner;

public class P1929_소수구하기 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int from = sc.nextInt();
        int to = sc.nextInt();
        for(; from <=to; from++){
            if( from == 1 ) continue;
            else if(from == 2) {
                System.out.println(from);
                continue;
            }
            int squareRoot = (int)Math.sqrt(from) + 1;
            for(int k = 2; k<=squareRoot; k++){
                if(from % k == 0) {
                    break;
                }
                if(k == squareRoot) {
                    System.out.println(from);
                    break;
                }
            }

        }
    }
}
