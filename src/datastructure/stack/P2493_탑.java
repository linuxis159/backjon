package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2493_탑 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder builder = new StringBuilder();
    static Stack<Top> topStack = new Stack();
    static Stack<Top> tempStack = new Stack();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Top firstTop = new Top(1, Integer.parseInt(st.nextToken()));
        builder.append(0 + " ");
        topStack.push(firstTop);
        Top mostHighestTop = firstTop;
        for(int i=1; i<N; i++){
            int topHeight = Integer.parseInt(st.nextToken());
            Top newTop = new Top(i+1, topHeight);
            if(topHeight < mostHighestTop.height){
                while(!topStack.isEmpty()) {
                    Top top = topStack.pop();
                    if(top.height > topHeight){
                        builder.append(top.topNum + " ");
                        topStack.push(top);
                        topStack.push(newTop);
                        break;
                    }
                }
            }
            else{
                topStack.clear();
                builder.append(0 + " ");
                mostHighestTop = newTop;
            }
            topStack.push(newTop);
        }

        System.out.print(builder);


    }
    static class Top{
        int height;
        int topNum;
        Top(int topNum, int height){
            this.topNum = topNum;
            this.height = height;
        }
    }

}
