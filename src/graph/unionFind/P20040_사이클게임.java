package graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20040_사이클게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] cycle;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cycle = new int[N+1];
        for(int i=1; i<=N; i++){
            cycle[i] = i;
        }
        int check = 0;
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int leftParent   = getParent(left);
            int rightParent  = getParent(right);
            if(leftParent == rightParent){
                check = i;
                break;
            }
            if(leftParent > rightParent)
                cycle[leftParent] = right;
            else
                cycle[rightParent] = left;
        }
        System.out.println(check);

    }
    static int getParent(int index){
        if(cycle[index] == index){
            return index;
        }

        return cycle[index] = getParent(cycle[index]);
    }
}
