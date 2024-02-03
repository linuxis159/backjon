package math.numberTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P6603_로또 {
    private static Scanner sc = new Scanner(System.in);
    static List<Integer> numList;
    static int[] result;
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
/*                if(numList.size() == 6){
                    numList.stream().forEach(num -> System.out.print(num + " "));
                    System.out.println();
                    return;
                }*/
                for (int i = 0; i <= numList.size() - 6; i++) {
                    result = new int[6];
                    visit = new boolean[N];
                    dfs(i);
                }
                System.out.println();

            }
        }
    }
        private static void dfs(int start){
            for(int i=0; i<5; i++){
                int exclude = -1;
                if(i != 0) {
                    exclude = 5-i+start;
                }
                int k = 0;
                for(int j=start; j<numList.size(); j++){
                    if (exclude != j) {
                        result[k] = numList.get(j);
                        k++;
                        if (k == 6) {
                            String resultString = Arrays.stream(result)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining(" "));
                            System.out.println(resultString);
                            k--;
                        }
                    }
                }
            }



        }
/*    private static void dfs(int start, int depth){
        if (depth == 6) {
            Arrays.stream(result).forEach(num -> System.out.print(num + " "));
            System.out.println();
            return;
        }

        for (int i = start; i < numList.size(); i++) {
            if (visit[i] == false) {
                visit[i] = true;
                result[depth] = numList.get(i);
                dfs(start, depth + 1);
            }
        }



    }*/

}