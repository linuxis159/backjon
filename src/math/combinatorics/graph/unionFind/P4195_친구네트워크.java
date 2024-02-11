package math.combinatorics.graph.unionFind;

import java.util.*;

public class P4195_친구네트워크 {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int T = sc.nextInt();
        for(int i=0; i<T ;i++){
            int F = sc.nextInt();
            Map<String, Set<String>> setMap = new HashMap();
            for(int j=0; j<F; j++){
                String first = sc.next();
                String second = sc.next();
                boolean flag = false;
                Set<String> firstSet = null;
                Set<String> secondSet = null;
                Set<String> targetSet = null;

                if(setMap.containsKey(first))
                    firstSet = setMap.get(first);


                if(setMap.containsKey(second))
                    secondSet = setMap.get(second);

                if(firstSet == null && secondSet == null){
                    Set<String> newSet = new HashSet();
                    newSet.add(first);
                    newSet.add(second);
                    setMap.put(first, newSet);
                    setMap.put(second, newSet);
                    targetSet = newSet;
                }
                else if(firstSet == null) {
                    targetSet = secondSet;
                    secondSet.add(first);
                    setMap.put(first, secondSet);
                }
                else if(secondSet == null){
                    targetSet = firstSet;
                    firstSet.add(second);
                    setMap.put(second, firstSet);
                }
                else{
                    for(String name : secondSet){
                        setMap.put(name, firstSet);
                        firstSet.add(name);
                    }
                    targetSet = firstSet;
                }

                System.out.println(targetSet.size());
            }
        }
    }
}
