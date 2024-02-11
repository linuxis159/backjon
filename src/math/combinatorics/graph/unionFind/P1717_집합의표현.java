package math.combinatorics.graph.unionFind;


import java.io.*;
import java.util.*;

public class P1717_집합의표현 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] parent;

        public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        Arrays.fill(parent, -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (parent[a] == -1) parent[a] = a;
            if (parent[b] == -1) parent[b] = b;

            int aParentIndex = findParentIndex(a);
            int bParentIndex = findParentIndex(b);
            if (flag == 0) {
                if (aParentIndex > bParentIndex) {
                    parent[aParentIndex] = bParentIndex;
                }

                else if (aParentIndex < bParentIndex) {
                    parent[bParentIndex] = aParentIndex;
                }

            } else {
                sb.append((aParentIndex == bParentIndex ? "YES" : "NO") + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }



    static int findParentIndex(int index){
        if(parent[index] == index)
            return index;
        return findParentIndex(parent[index]);
    }


}
