package math.combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class P1759_암호만들기 {
    static Scanner sc = new Scanner(System.in);
    static char[] passCombination;
    static char[] result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean visit[];

    static int L;
    static int C;
    static Set<Character> voweis = new HashSet();
    public static void main(String[] args) throws IOException {
        voweis.addAll(Arrays.asList('a','e','i','o','u'));
        L = sc.nextInt();
        C = sc.nextInt();
        passCombination = new char[C];
        result = new char[L];
        visit = new boolean[C];

        for(int i=0; i<C; i++){
            sb.append(sc.next());
        }
        passCombination = sb.toString().toCharArray();
        Arrays.sort(passCombination);
        dfs(0, 0);
    }

    static void dfs(int depth, int startIndex){
        if(depth == L) {
            int cnt = 0;
            for(char charecter : result){
                if(voweis.contains(charecter)) cnt++;
            }
            if(cnt <= 0 || L-cnt <= 1)
                return;
            System.out.println(result);
            return;
        }
        for(int i=startIndex; i<C; i++){
            visit[i] = true;
            result[depth] = passCombination[i];
            dfs(depth+1, i+1);
            visit[i] = false;
        }
    }
}
