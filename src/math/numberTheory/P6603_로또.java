package math.numberTheory;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;


public class P6603_로또 {
    private static Scanner sc = new Scanner(System.in);
    static List<Integer> numList;
    static List<Integer> result;
    static boolean[] visit;
    static int N;
    static int seq = 5;

    public static void main(String[] args) {
        while (true) {
            N = sc.nextInt();
            numList = new ArrayList();
            if (N == 0) return;
            else {
                visit = new boolean[N];
                for (int i = 0; i < N; i++) {
                    numList.add(sc.nextInt());
                }
               // for (int i = 0; i <= numList.size() - 6; i++) {
                    result = new Stack();
                    visit = new boolean[N];
                    dfs(0);
                //}
            }
        }
    }
    private static void dfs(int start){
        if (result.size() == 6) {
            String resultString = result.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(resultString);
            return;
        }

        for (int i = start; i < numList.size(); i++) {
            if (visit[i] == false) {
                visit[i] = true;
                result.add(numList.get(i));
                dfs(i + 1);
                result.remove(result.size()-1);
                visit[i] = false;
            }
        }
    }

}