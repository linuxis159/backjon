package sort;

import java.util.Scanner;

public class P2750_Selection {
    private static int[] numberArr;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        numberArr = new int[N];
        for(int i=0; i<N; i++){
            numberArr[i] =  sc.nextInt();
        }
        for(int i=0; i<N; i++){
            int min=99999;
            int hasMinValueArrIndexNum = 0;
            for(int j=i; j<N; j++){
                if(min > numberArr[j]){
                    min = numberArr[j];
                    hasMinValueArrIndexNum = j;
                }
            }
            int temp = numberArr[i];
            numberArr[i] = numberArr[hasMinValueArrIndexNum];
            numberArr[hasMinValueArrIndexNum] = temp;
        }
        for(int i=0; i<N; i++){
            System.out.println(numberArr[i]);
        }
    }
}
