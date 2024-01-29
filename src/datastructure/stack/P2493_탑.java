package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2493_탑 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder builder = new StringBuilder();
    static Stack<Integer> topStack = new Stack();
    static int[] result;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        result = new int[N];
        for(int i=0; i<N; i++){
            int topHeight = Integer.parseInt(st.nextToken());
            topStack.push(topHeight);
        }

        for(int i=0; i<N; i++){
            int currentTopIndex = N-1-i;
            boolean flag = false;
            int currentTopHeight = topStack.pop();
            for(int j=topStack.size()-1; j > 0; j--){
                int topHeight = topStack.get(j);
                if(currentTopHeight < topHeight){
                    result[currentTopIndex] = j+1;
                    flag = true;
                    break;
                }
            }
            if(flag == false)
                result[currentTopIndex] = 0;
        }

        for(int result : result){
            System.out.print(result + " ");
        }
    }
    private static class Top{
        int topNum;
        int topHeight;

        private Top(int topNum, int topHeight){
            this.topNum = topNum;
            this.topHeight = topHeight;

        }
    }
}
