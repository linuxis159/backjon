package datastructure.hash;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P14425_문자열집합 {
    private static Scanner sc = new Scanner(System.in);
    private static Set<String> stringSet = new HashSet();
    public static void main(String[] args){
        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 0;
        for(int i=0; i<N; i++){
            stringSet.add(sc.next());
        }
        for(int i=0; i<M; i++){
            if(stringSet.contains(sc.next())) result++;
        }
        System.out.println(result);

    }
}
