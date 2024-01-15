package sort;


import java.util.Scanner;

public class P2750_Bubble {
    private static int[] numberArr;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        numberArr = new int[N];
        for(int i=0; i<N; i++){
            numberArr[i] =  sc.nextInt();
        }
        for(int i=0; i<N;i++){
            for(int j=i; j<N-1; j++){
                if(numberArr[j] > numberArr[j+1]){
                    int temp = numberArr[j+1];
                    numberArr[j+1] = numberArr[j];
                    numberArr[j] = temp;
                }
            }
        }
    }
}
