package datastructure.queue.priorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1927_최소힙 {
    private static Scanner sc = new Scanner(System.in);
    private static MinHeap minHeap = new MinHeap();
    public static void main(String[] args){
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int num = sc.nextInt();
            if(num == 0) System.out.println(minHeap.pop());
            else minHeap.addNode(num);

        }
    }
    private static class MinHeap{
        List<Integer> list = new ArrayList();

        void addNode(int x){
            list.add(x);
            int addedIndex = list.size() - 1;
            heapify(addedIndex, getParentIndex(addedIndex));
        }
        void heapify(int index, int parentIndex){
            if(index == 0)
                return;
            else if(list.get(index) >= list.get(parentIndex)) return;
            else{
                swap(index, parentIndex);
                heapify(parentIndex, getParentIndex(parentIndex));
            }
        }
        int getParentIndex(int index){
            if(index % 2 == 0) return (index / 2) -1;
            else return index / 2;
        }


        void swap(int leftIndex, int rightIndex){
            int temp = list.get(leftIndex);
            list.set(leftIndex, list.get(rightIndex));
            list.set(rightIndex, temp);
        }


        public int pop() {
            if(list.isEmpty()) return 0;
            else {

            }
        }
    }
}
