package greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class P11501_주식 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int j=0; j<N; j++){
                int stock = sc.nextInt();
                arr[j] = stock;
            }
            int max = arr[arr.length-1];
            long result = 0;
            for(int j=arr.length-2; j>=0; j--){
                if(max >= arr[j]){
                    result += max - arr[j];
                }
                else {
                    max = arr[j];
                }
            }
            System.out.println(result);
        }

    }
}
