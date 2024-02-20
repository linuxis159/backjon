package math.numberTheory;

import java.util.Scanner;

public class P2960_에라토스테네스의체 {
    static Scanner sc = new Scanner(System.in);
    static int cnt = 0;
    static boolean[] check;
    public static void main(String[] args){
        int N = sc.nextInt();
        int K = sc.nextInt();
        check = new boolean[N+1];
        for(int i=2; i<=N; i++){
            if(!check[i]){
                for(int j=1; j*i<=N; j++){
                    if(!check[j*i]){
                        if(++cnt == K) {
                            System.out.print(j * i);
                            return;
                        }
                        check[j*i] = true;
                    }
                }
            }
        }


    }
}
