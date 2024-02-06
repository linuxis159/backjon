package sort;

import java.util.Scanner;

public class P24060_MergeSort {
    private static Scanner sc = new Scanner(System.in);
    private static int arr[];
    private static int cnt = 0;
    private static int K = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        mergeSort(0, arr.length-1);

        if(K > cnt)
            System.out.println(-1);


    }
    static void mergeSort(int left, int right){
        if(left >= right)
            return;
        int middle = (left+right) / 2;
        mergeSort(left, middle);
        mergeSort(middle+1, right);
        merge(left, right, middle);

    };
    static void merge(int left, int right, int middle){
        int leftArrSize  = middle - left + 1;
        int rightArrSize = right - middle;
        int leftArr[] = new int[leftArrSize];
        int rightArr[] = new int[rightArrSize];
        for(int i=0; i<leftArrSize; i++){
            leftArr[i] = arr[left+i];
        }
        for(int i=0; i<rightArrSize; i++){
            rightArr[i] = arr[middle+i+1];
        }
        int leftIndex = 0;
        int rightIndex = 0;

        int i = left;

        for(;leftIndex < leftArrSize && rightIndex < rightArrSize;){
            if(leftArr[leftIndex] > rightArr[rightIndex]){
                arr[i] = rightArr[rightIndex];
                rightIndex++;
            }
            else{
                arr[i] = leftArr[leftIndex];
                leftIndex++;
            }
            check(i);
            i++;
        }

        if(leftIndex < leftArrSize){
            for(;leftIndex < leftArrSize;)    {
                arr[i] = leftArr[leftIndex];
                check(i);
                leftIndex++;
                i++;
            }
        }
        else{
            for(;rightIndex < rightArrSize;)    {
                arr[i] = rightArr[rightIndex];
                check(i);
                rightIndex++;
                i++;
            }
        }

    }
    static void check(int i){
        cnt++;
        if(cnt == K){
            System.out.println(arr[i]);
        }
    }

}
