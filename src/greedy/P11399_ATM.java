package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P11399_ATM {
    static Scanner sc = new Scanner(System.in);
    static int[] arr;
    public static void main(String[] args){
        int N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int result = 0;
        for(int i=0; i<N; i++){
            result += arr[i];
            for(int j=0; j<i; j++){
                result += arr[j];
            }
        }
        System.out.print(result);

    }
}
