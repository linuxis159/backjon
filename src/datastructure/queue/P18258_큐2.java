package datastructure.queue;

import datastructure.stack.P10828_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P18258_큐2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder builder = new StringBuilder();
    private static Queue stack = new Queue();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int result;
            switch (command){
                case "push" :
                    int data = Integer.parseInt(st.nextToken());
                    stack.push(data);
                    break;
                case "pop" :
                    result = stack.pop();
                    builder.append(result).append("\n");
                    break;
                case "size" :
                    result = stack.size();
                    builder.append(result).append("\n");
                    break;
                case "empty" :
                    result = stack.empty();
                    builder.append(result).append("\n");
                    break;
                case "front" :
                    result = stack.front();
                    builder.append(result).append("\n");
                    break;
                case "back" :
                    result = stack.back();
                    builder.append(result).append("\n");
                    break;
            }
        }
        System.out.println(builder);

    }
    private static class Queue{
        ArrayList<Integer> queueArray = new ArrayList();
        int queueCurrentPointer = -1;

        void push(int x){
            if(queueCurrentPointer == -1
                    || queueCurrentPointer > queueArray.size())
                queueCurrentPointer++;
            queueArray.add(x);
        }
        int pop(){
            if(queueCurrentPointer == queueArray.size()
            || queueArray.size() == 0) return -1;
            else {
                int popData = queueArray.get(queueCurrentPointer);
                queueCurrentPointer++;
                return popData;
            }
        }
        int size(){
            if(queueArray.size() == 0)
                return 0;
            else return queueArray.size() - queueCurrentPointer;
        }
        int front(){
            if(queueCurrentPointer >= queueArray.size()
                    || queueArray.size() == 0) return -1;
            else return queueArray.get(queueCurrentPointer);
        }
        int back(){
            if(queueCurrentPointer >= queueArray.size()
                    || queueArray.size() == 0) return -1;
            else return queueArray.get(queueArray.size()-1);
        }
        int empty(){
            if(queueCurrentPointer == queueArray.size()
                    || queueArray.size() == 0) return 1;
            else return 0;
        }
    }
}
