package graph.unionFind;

import java.util.*;

public class P1717_집합의표현 {
    public static Scanner sc = new Scanner(System.in);
    static Map<Integer, Integer> elementMap;
    public static void main(String[] args){
        int N = sc.nextInt();
        int M = sc.nextInt();
        elementMap = new HashMap(N);
        for(int i=0; i<M; i++){
            int flag = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int aValue;
            int bValue;
            if(elementMap.containsKey(a)) aValue = elementMap.get(a);
            else {
                elementMap.put(a, a);
                aValue = a;
            }
            if(elementMap.containsKey(b)) bValue = elementMap.get(b);
            else {
                elementMap.put(b, b);
                bValue = b;
            }

            if(flag == 0){

            }
            else{
                if(aValue == bValue)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }
}
