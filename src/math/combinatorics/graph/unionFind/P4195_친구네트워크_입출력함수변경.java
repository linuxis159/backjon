package math.combinatorics.graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P4195_친구네트워크_입출력함수변경 {

    public static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T ;i++){
            int F = Integer.parseInt(br.readLine());
            Map<String, Set<String>> setMap = new TreeMap();
            for(int j=0; j<F; j++){
                st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();
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
                else if(firstSet == secondSet){
                    targetSet = firstSet;
                }
                else{
                    for(String name : secondSet){
                        setMap.put(name, firstSet);
                        firstSet.add(name);
                    }
                    targetSet = firstSet;
                }
                sb.append(targetSet.size()+"\n");
            }
        }
        System.out.print(sb);
    }
}
