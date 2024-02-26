package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
/*
    첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.

    출력
    총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.

    예제 입력 1
    4
    3 5 2 7

    예제 출력 1
    5 7 7 -1

   예제 입력 2
    4
    9 5 4 8

    예제 출력 2
    -1 8 8 -1

*/
public class P17298_오큰수 {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Node> stack = new Stack();
    static Stack<Node> tempStack = new Stack();
    static int result[];
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        result = new int[N];
        for(int i=0;st.hasMoreTokens();i++){
            int num = Integer.parseInt(st.nextToken());
            Node newNode = new Node(i, num);
            while(!stack.empty()){
                Node poped = stack.pop();
                if(newNode.value <= poped.value) {
                    tempStack.push(poped);
                }
                else {
                    result[poped.index] = newNode.value;
                }
            }
            while(!tempStack.isEmpty()){
                stack.push(tempStack.pop());
            }
            stack.push(newNode);
            result[i] = -1;
        }
        for(int i=0; i < result.length; i++){
            if( i == result.length)
                sb.append(result[i]);

            sb.append(result[i] +" ");
        }
        System.out.print(sb);

    }

    static class Node{
        int index = 0;
        int value = 0;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
