package sort;

import java.io.*;
import java.util.Scanner;

public class P2750_Quick {
    private static int[] numberArr;
    private static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static DataOutputStream dataOutputStream = new DataOutputStream(System.out);
    public static void main(String[] args) throws IOException {
        int N = sc.nextInt();
        numberArr = new int[N];
        for(int i=0; i<N; i++){
            numberArr[i] =  sc.nextInt();
        }
        quickSort(numberArr, 0, numberArr.length -1);
        for(int value : numberArr) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }

    static void quickSort(int numberArr[], int start, int end){
        if(start < end){
            int pivotIndex = partition(numberArr, start, end);
            quickSort(numberArr, start, pivotIndex-1);
            quickSort(numberArr, pivotIndex, end);
        }
    }
    static int partition(int numberArr[], int start, int end){
        int pivotIndex = end;
        int i = start - 1;

        for(int j=start; j<end; j++){
            if(numberArr[pivotIndex] >= numberArr[j]){
                i++;
                arraySwap(i, j);
            }
        }
        arraySwap(pivotIndex, i+1);
        return i+1;
    }

    static void arraySwap(int left, int right){
        int temp = numberArr[right];
        numberArr[right] = numberArr[left];
        numberArr[left] = temp;
    }
}
