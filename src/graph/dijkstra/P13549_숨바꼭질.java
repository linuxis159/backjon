package graph.dijkstra;
/*문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고,
동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
수빈이는 걷거나 순간이동을 할 수 있다.
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때,
수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.*/


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*예제 입력 1
5 17
예제 출력 1
2*/

/*입력 : 100000 0
출력 : -1
정답 : 100000*/

public class P13549_숨바꼭질 {
    static Scanner sc = new Scanner(System.in);
    static Queue<Integer> queue = new PriorityQueue();
    public static void main(String[] args){
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[100000+1];
        Arrays.fill(arr, 1000000);
        arr[N] = 0;
        queue.add(N);
        while(!queue.isEmpty()){
            int pulled = queue.poll();
            try {
                if (arr[pulled] + 1 < arr[pulled + 1]) {
                    arr[pulled + 1] = arr[pulled] + 1;
                    queue.add(pulled + 1);
                }
                if (arr[pulled] + 1 < arr[pulled - 1]) {
                    arr[pulled - 1] = arr[pulled] + 1;
                    queue.add(pulled - 1);
                }
                if (arr[pulled] < arr[pulled * 2]) {
                    arr[pulled * 2] = arr[pulled];
                    queue.add(pulled * 2);
                }
            } catch(ArrayIndexOutOfBoundsException e){
                continue;
            }
        }
        System.out.println(arr[K]);
    }
}
