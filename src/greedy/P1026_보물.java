package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P1026_보물 {
    static Scanner sc = new Scanner(System.in);
    static int A[];
    static Integer B[];
    static int result = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        A = new int[N];
        B = new Integer[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++){
            B[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        for(int i=0; i<N; i++){
            result += A[i] * B[i];
        }
        System.out.print(result);
    }
}
