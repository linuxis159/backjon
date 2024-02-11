package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P2217_로프 {
    static Scanner sc = new Scanner(System.in);
    static int[] rope;
    static int max = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        rope = new int[N];
        for(int i=0; i<N; i++){
            rope[i] = sc.nextInt();
        }
        Arrays.sort(rope);
        for(int i=0; i<N; i++){
            int weight = rope[i] * (N-i);
            if(weight > max) max = weight;
        }
        System.out.println(max);
    }
}
