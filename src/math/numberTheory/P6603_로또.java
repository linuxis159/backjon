package math.numberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class P6603_로또 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            int N = sc.nextInt();
            if(N == 0 ) return;
            else{
                int arr[] = new int[N];
                boolean visit[] = new boolean[N];
                for(int i=0; i<N; i++){
                    arr[i] = sc.nextInt();
                }
                Arrays.sort(arr);

            }
        }
    }
}
