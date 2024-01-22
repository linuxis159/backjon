package sort;

import java.util.Scanner;

public class P11931_Merge {
    private static int[] numberArr;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N= sc.nextInt();
        numberArr = new int[N];
        for(int i=0; i<N; i++){
            numberArr[i] = sc.nextInt();
        }

        mergeSort(0, numberArr.length-1);

        for(int number : numberArr)
            System.out.println(number);
    }

    static void mergeSort(int left, int right){
        int middle = (left + right) / 2;
        if(left >= right)
            return;
        mergeSort(left, middle);
        mergeSort(middle+1, right);
        merge(left, right);
    }
    static void merge(int left, int right){
        int middle = (left + right) / 2;

        int[] leftArray = new int[middle - left + 1];
        int[] rightArray = new int[right - middle];

        for(int i=0; i<leftArray.length; i++){
            leftArray[i] = numberArr[left+i];
        }
        for(int i=0; i<rightArray.length; i++){
            rightArray[i] = numberArr[middle+i+1];
        }
        int leftArrayIndex=0;
        int rightArrayIndex=0;
        int numberArrayIndex=left;

        while(leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length){
            if(leftArray[leftArrayIndex] > rightArray[rightArrayIndex]) {
                numberArr[numberArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            }
            else {
                numberArr[numberArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            numberArrayIndex++;
        }

        while(leftArrayIndex < leftArray.length){
            numberArr[numberArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            numberArrayIndex++;
        }
        while(rightArrayIndex < rightArray.length){
            numberArr[numberArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            numberArrayIndex++;
        }
    }
}
