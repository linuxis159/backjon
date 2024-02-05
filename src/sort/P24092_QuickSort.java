package sort;

import java.util.Scanner;

public class P24092_QuickSort {
    private static Scanner sc = new Scanner(System.in);
    private static int firstArr[];
    private static int secondArr[];
    private static int diff = -999;
    static int flag = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        firstArr = new int[N];
        secondArr = new int[N];
        for(int i=0; i<N; i++){
            firstArr[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++){
            secondArr[i] = sc.nextInt();
        }
        diff = checkEqual();
        quickSort(0, N-1);

        System.out.println(flag);

    }
    static void quickSort(int left, int right){
        if(left >= right)
            return;
        int pivotIndex = getPivotIndex(left, right);
        quickSort(left, pivotIndex-1);
        quickSort(pivotIndex+1, right);
    }
    static int getPivotIndex(int left, int right){
        int pivotIndex = right;
        int leftNum = left -1;
        for(int i=left; i<right; i++){
            if(firstArr[i] <= firstArr[pivotIndex]){
                leftNum++;
                swap(leftNum, i);
            }
        }
        swap(++leftNum, pivotIndex);
        return leftNum;
    }
    static void swap(int left, int right){
        int temp = firstArr[left];
        firstArr[left] = firstArr[right];
        firstArr[right] = temp;
        if(left == diff || right == diff)
            diff = checkEqual();
    }
    static int checkEqual(){
        for(int i=0; i<=firstArr.length; i++){
            if(firstArr[i] != secondArr[i])
                return i;
        }

        flag = 1;
        return -1;
    }

}
