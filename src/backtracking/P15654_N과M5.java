package backtracking;

import java.util.Arrays;
import java.util.Scanner;

/*N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

N개의 자연수 중에서 M개를 고른 수열
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.*/
public class P15654_N과M5 {
    static Scanner sc = new Scanner(System.in);
    static int[] num;
    static boolean[] visit;
    static int result[];
    static int N;
    static int M;
    public static void main(String[] args){
        N = sc.nextInt();
        M = sc.nextInt();
        num = new int[N];
        visit = new boolean[N];
        result = new int[M];
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        dfs(0);
    }

    static void dfs(int depth){
        if(depth >= M){
            Arrays.stream(result).forEach(num ->
                    System.out.print(num +" "));
            System.out.println();
            return;
        }
        for(int i=0; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                result[depth] = num[i];
                dfs(++depth);
                visit[i] = false;
            }
        }
    }
}
