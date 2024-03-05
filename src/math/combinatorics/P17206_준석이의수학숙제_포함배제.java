package math.combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class P17206_준석이의수학숙제_포함배제 {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] result;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        result = new int[T];
        st =  new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(st.nextToken());
            int excludeValue = 0;
            int resultOne = 0;
            int resultTwo = 0;
            int cnt = 1;
            for(int j=3; j<=N; j+=3){
                if(j % 21 == 0){
                    excludeValue += j;
                }
                else if((j+cnt) % 7 == 0 && (j+cnt) <=N){
                    if(cnt < 3){
                        resultOne += (j + cnt);
                        cnt++;
                    }
                    else{
                        resultOne += (j + cnt);
                        cnt = 1;
                    }

                }
                resultTwo += j;
            }
            result[N] = resultOne + resultTwo - excludeValue;
            sb.append(resultOne + resultTwo - excludeValue + "\n");
        }
        System.out.print(sb);
    }
}
