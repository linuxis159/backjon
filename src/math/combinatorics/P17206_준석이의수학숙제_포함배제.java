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
    public static void main(String[] args) throws IOException {
/*        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        st =  new StringTokenizer(br.readLine());*/
        for(int i=10; i<=80000; i++){
/*            int N = Integer.parseInt(st.nextToken());*/
            int N = i;
            int resultOne = 0;
            int resultTwo = 0;
            int resultThr
            int k = 1;
            for(int j=3; j<=N; j+=3){
                if(j % 21 == 0){
                    resultTwo += j;
                    continue;
                }

                else if((k-1) % 3 == 0){
                    if(resultOne == 0)
                        resultOne = 7;
                    else resultOne += resultOne + 7;
                }
                resultTwo += j;
            }

            int result = 0;
            for(int j=3; j<=N; j+=3){
                if(j % 21 == 0) continue;
                result += j;
            }
            for(int j=7; j<=N; j+=7){
                result += j;
            }


            if(N % 7 == 0 && N % 21 != 0) resultOne += resultOne + 7;
            else if(k % 3 == 0) resultOne += resultOne + 7;
            if(result != resultOne + resultTwo){
                System.out.println(result +", "+ resultOne + resultTwo);
            }
            sb.append(resultOne + resultTwo+"\n");
        }
       // System.out.print(sb);

    }
}
