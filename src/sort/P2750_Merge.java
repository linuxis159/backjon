package sort;

import java.util.Scanner;

public class P2750_Merge {
    private static int[] numberArr;
    static StringBuilder sb = new StringBuilder();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        N += 1;
        numberArr = new int[N];
        for(int i=1; i<N; i++){
            numberArr[i] =  sc.nextInt();
        }
        mergeSort(numberArr, 1, numberArr.length-1);
        for(int value : numberArr) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);

    }
    public static void mergeSort(int[] numberArr, int left, int right){
        if(left < right){
            int middle = (left + right) / 2;
            System.out.println(left+","+middle+","+right);
            mergeSort(numberArr,left, middle);
            mergeSort(numberArr,middle+1, right);
            merge(numberArr,left, middle, right);
        }

    }
    public static void merge(int[] numberArr, int left, int middle ,int right){
        int leftArraySize  = middle - left + 1;
        int rightArraySize = right - middle;

        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];
        for(int i=0; i<leftArray.length; i++)
            leftArray[i] = numberArr[left+i];
        for(int i=0; i<rightArray.length; i++)
            rightArray[i] = numberArr[middle+i+1];

        int leftArrayIndex  = 0;
        int rightArrayIndex = 0;
        int i = left;
        while(leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize){
            if(leftArray[leftArrayIndex] < rightArray[rightArrayIndex]){
                numberArr[i] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            }
            else {
                numberArr[i] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            i++;
        }

        while(leftArrayIndex < leftArraySize){
            numberArr[i] = leftArray[leftArrayIndex];
            i++;
            leftArrayIndex++;
        }
        while(rightArrayIndex < rightArraySize){
            numberArr[i] = rightArray[rightArrayIndex];
            i++;
            rightArrayIndex++;
        }



    }
}
