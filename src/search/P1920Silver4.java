package search;
/*

N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.



예제 입력 1
5
4 1 5 2 3
5
1 3 7 9 5

예제 출력 1
1
1
0
0
1

*/
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class P1920Silver4 {
    static int N = 0;
    static int M = 0;
    static Scanner sc = new Scanner(System.in);
    static List<Integer> nums;
    static List<Integer> searchingTargetNums;

    public static void main(String[] args){
        N = sc.nextInt();
        nums = new ArrayList(N);
        for(int i = 0; i<N; i++){
            nums.add(sc.nextInt());
        }
        Collections.sort(nums);
        M = sc.nextInt();
        searchingTargetNums = new ArrayList(M);
        for (int i=0; i<M; i++){
            searchingTargetNums.add(sc.nextInt());
        }
        for(int i=0; i<M; i++){
            int targetNum = searchingTargetNums.get(i);
            if(nums.get(0) > targetNum){
                System.out.println(0);
                continue;
            }
            else if(nums.get(N-1) < targetNum){
                System.out.println(0);
                continue;
            }
            binarySearch(targetNum,0 ,N-1);

        }

    }
    private static void binarySearch(int targetNum ,int start, int end){

        if(start > end){
            System.out.println(0);
            return;
        }
        int pivot = start + (end - start) / 2;
        if(nums.get(pivot) == targetNum){
            System.out.println(1);
            return;
        }
        if(nums.get(pivot) > targetNum){
            binarySearch(targetNum, start, pivot-1);
        }
        else{
            binarySearch(targetNum, pivot+1, end);
        }


    }
}
