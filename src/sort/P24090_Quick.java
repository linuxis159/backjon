package sort;

import java.util.Scanner;

public class P24090_Quick {
    private static int[] numberArr;
    private static Scanner sc = new Scanner(System.in);
    static int swapCount = 0;
    static int K = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        K = sc.nextInt();
        numberArr = new int[N];
        for(int i=0; i<N; i++){
            numberArr[i] = sc.nextInt();
        }
        quickSort(0, numberArr.length-1);
        if(swapCount < K)
            System.out.println(-1);

    }
    static void quickSort(int left, int right){
        if(left > right)
            return;
        int pivot = getPivot(left, right);
        quickSort(left, pivot-1);
        quickSort(pivot+1, right);
    }
    static int getPivot(int left, int right){
        int pivot = right;
        int i = left - 1;
        while(left < right){
            if(numberArr[left] <= numberArr[pivot])
                swap(left, ++i);
            left++;
        }
        if(i + 1 != right)
            swap(i + 1, right);
        return i+1;
    }
    static void swap(int leftIndex, int rightIndex){
        swapCount++;
        if(swapCount == K){
            if( numberArr[leftIndex] < numberArr[rightIndex]){
                System.out.println(numberArr[leftIndex] + " " +numberArr[rightIndex]);
            }
            else{
                System.out.println(numberArr[rightIndex] + " " +numberArr[leftIndex]);
            }
        }
        int temp = numberArr[leftIndex];
        numberArr[leftIndex] = numberArr[rightIndex];
        numberArr[rightIndex] = temp;

    }
}
