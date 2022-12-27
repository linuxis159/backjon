package tree.heap;
/*

배열에 자연수 x를 넣는다.
배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

입력
첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다.
다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
 x는 231보다 작은 자연수 또는 0이고, 음의 정수는 입력으로 주어지지 않는다.

출력
입력에서 0이 주어진 횟수만큼 답을 출력한다.
만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.



입력
9
0
12345678
1
2
0
0
0
0
32

0
1
2
12345678
0
출력*/

import java.util.Scanner;

public class P1927Silver2 {
    static private class Heap{
        int[] heap = new int[100001];
        int length = 0;
        public void add(int data){
            if(data == 0){
                if(length == 0)
                    System.out.println(0);
                else{
                    System.out.println(heap[1]);
                    heap[1] = heap[this.length--];
                    remove(1);
                }
                return;
            }
            heap[++this.length] = data;
            treeTravel(this.length);
        }
        private void treeTravel(int index){
            if(index == 1){
                return;
            }

            else if(index % 2 == 0){
                if(heap[index/2] >= heap[index]){
                    swap(index, index/2);
                    treeTravel(index/2);
                }
                return;
            }
            else{
                if(heap[(index-1)/2] >= heap[index]){
                    swap(index, (index-1)/2);
                    treeTravel((index-1)/2);
                }
                return;
            }

        }
        void remove(int index){
            int left = index * 2;
            int right = index * 2 + 1;
            if(left > length)
                return;
            else if(right > length){
                if(heap[left] > heap[index]){
                    return;
                }
                else{
                    swap(left, index);
                    remove(left);
                    return;
                }

            }
            else if(heap[left] < heap[right]){
                if(heap[left] > heap[index]){
                    return;
                }
                else{
                    swap(left, index);
                    remove(left);
                    return;
                }
            }

            else{
                if(heap[right] > heap[index]){
                    return;
                }
                else{
                    swap(right, index);
                    remove(right);
                    return;
                }
            }
        }

        private void swap(int left, int right){
            int temp = this.heap[left];
            this.heap[left] = this.heap[right];
            this.heap[right] = temp;
        }
    }
    static int N;
    static Scanner sc = new Scanner(System.in);
    static Heap heap = new Heap();
    public static void main(String[] args){
        N = sc.nextInt();
        for(int i=0; i<N; i++){
            int x = sc.nextInt();
            heap.add(x);
        }
    }
}
