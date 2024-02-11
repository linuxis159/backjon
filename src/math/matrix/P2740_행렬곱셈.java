package math.matrix;

import java.util.Arrays;
import java.util.Scanner;

public class P2740_행렬곱셈 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int M;
    static int K;
    static int[][] A;
    static int[][] B;
    static int[][] result;
    public static void main(String[] args){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                A[i][j] = sc.nextInt();
            }
        }

        M = sc.nextInt();
        K = sc.nextInt();
        B = new int[M][K];

        for(int i=0; i<M; i++){
            for(int j=0; j<K; j++){
                B[i][j] = sc.nextInt();
            }
        }

        result= new int[N][K];

        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                for(int k=0; k<M; k++){
                    result[i][j] = result[i][j] + A[i][k] * B[k][j];
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
