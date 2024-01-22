package sort;

import java.util.Scanner;

public class P24090_Quick {
    private static int[] numberArr;
    private static Scanner sc = new Scanner(System.in);
    static int swapCount = 0;
    static int K = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        int K = sc.nextInt();
        numberArr = new int[N];
        for(int i=0; i<N; i++){
            numberArr[i] = sc.nextInt();
        }
        quickSort(0, numberArr.length-1);
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
        int pivot = left;
        int leftIndex = pivot+1;
        int rightIndex = right;
        while(leftIndex <= rightIndex){
            if(numberArr[leftIndex] > numberArr[pivot]){
                if(numberArr[rightIndex] <= numberArr[pivot]){
                    swap(leftIndex, rightIndex);
                    leftIndex++;
                    rightIndex--;
                }
                else rightIndex--;
            }
            else leftIndex++;
        }
        swap(pivot,rightIndex);
        return rightIndex;
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
