package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P10828_스택 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder builder = new StringBuilder();
    private static Stack stack = new Stack();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "push" : ;
                    int data = Integer.parseInt(st.nextToken());
                    stack.push(data);
                    break;
                case "pop" :
                    stack.pop();
                    break;
                case "size" :
                    stack.size();
                    break;
                case "empty" :
                    stack.empty();
                    break;
                case "top" :
                    stack.top();
                    break;
            }
        }

    }
    private static class Stack{
        ArrayList<Integer> stackArray = new ArrayList();
        int stackCurrentPointer = -1;

        void push(int x){
            stackCurrentPointer++;
            stackArray.add(stackCurrentPointer, x);
        }
        void pop(){
            if(stackCurrentPointer == -1) System.out.println(-1);
            else {
                int popData = stackArray.get(stackCurrentPointer);
                stackCurrentPointer--;
                System.out.println(popData);
            }
        }
        void size(){
            System.out.println(stackCurrentPointer + 1);
        }
        void top(){
            if(stackCurrentPointer == -1) System.out.println(-1);
            else System.out.println(stackArray.get(stackCurrentPointer));
        }
        void empty(){
            if(stackCurrentPointer == -1) System.out.println(1);
            else System.out.println(0);
        }
    }
}
