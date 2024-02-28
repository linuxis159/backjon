package math.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P14492_부울행렬의부울곱 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        boolean[][] matrixA = new boolean[N][N];
        boolean[][] matrixB = new boolean[N][N];
        boolean[][] matrixC = new boolean[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 1)
                    matrixA[i][j] = true;
                else
                    matrixA[i][j] = false;
            }
        }
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 1)
                    matrixB[i][j] = true;
                else
                    matrixB[i][j] = false;
            }
        }
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                boolean flag = false;
                for (int k = 0; k < N; k++) {
                    if (matrixA[i][k] && matrixB[k][j]) {
                        flag = true;
                        break;
                    }
                }
                if(flag) cnt++;

            }
        }
        System.out.println(cnt);
    }
}

