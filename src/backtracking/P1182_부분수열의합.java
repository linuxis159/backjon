package backtracking;

import javax.naming.ServiceUnavailableException;
import java.util.Scanner;

public class P1182_부분수열의합 {
    static Scanner sc = new Scanner(System.in);
    static boolean visit[];
    static int num[];
    static int S;
    static int cnt = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        S = sc.nextInt();
        num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }
        for(int i=0; i<N ; i++){
                visit = new boolean[N];
                dfs(0, i, 0, 0);
        }
        System.out.println(cnt);
    }

    static void dfs(int depth, int maxdepth, int sum, int startIndex){
        if(depth > maxdepth){
            //System.out.println(sum);
            if(sum == S) cnt++;
            return;
        }
        for(int i=startIndex; i<num.length; i++){
            if(!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, maxdepth, sum + num[i], i+1);
                visit[i] = false;
            }
        }

    }
}
