package sort;

import java.util.Scanner;

public class P2750_Heap {
    private static int[] numberArr;
    static StringBuilder sb = new StringBuilder();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        N += 1;
        numberArr = new int[N];
        for(int i=1; i<N; i++){
            numberArr[i] =  sc.nextInt();
        }

        for(int value : numberArr) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);

    }
}
