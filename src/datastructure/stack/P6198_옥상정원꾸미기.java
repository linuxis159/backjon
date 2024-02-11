package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class P6198_옥상정원꾸미기 {
    static Scanner sc = new Scanner(System.in);
    static Stack<RoofTop> stack = new Stack<RoofTop>();

    static long result = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int height = sc.nextInt();
            RoofTop newRoofTop = new RoofTop(height);
            while(!stack.isEmpty()){
                if(stack.peek().height > newRoofTop.height){
                    result += stack.size();
                    break;
                }
                else{
                    stack.pop();
                }
            }
            stack.push(newRoofTop);
        }
        System.out.print(result);

    }
    static class RoofTop{
        int height;
        RoofTop(int height){
            this.height = height;
        }
    }
}
