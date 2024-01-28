package datastructure.queue.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1927_최소힙 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder builder = new StringBuilder();
    private static MinHeap minHeap = new MinHeap();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
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
                swap(0, list.size() - 1);
                int removed = list.remove(list.size() - 1);
                heapifyDown(0);return removed;
            }
        }
        void heapifyDown(int index){
            int leftIndex = (index * 2) + 1;
            int rightIndex = (index * 2) + 2;
            if(list.size() <= leftIndex)
                return;
            else if(list.get(leftIndex) < list.get(index)){
                swap(leftIndex, index);
                heapifyDown(leftIndex);
            }
            if(list.size() <= rightIndex)
                return;
            else if(list.get(rightIndex) < list.get(index)){
                swap(rightIndex, index);
                heapifyDown(rightIndex);
            }
        }
    }
}
