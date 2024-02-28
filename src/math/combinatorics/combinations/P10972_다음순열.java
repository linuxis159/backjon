package math.combinatorics.combinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*문제
1부터 N까지의 수로 이루어진 순열이 있다. 이때,
사전순으로 다음에 오는 순열을 구하는 프로그램을 작성하시오.

사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고,
가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.

N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.

1, 2, 3
1, 3, 2
2, 1, 3
2, 3, 1
3, 1, 2
3, 2, 1
입력
첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.

출력
첫째 줄에 입력으로 주어진 순열의 다음에 오는 순열을 출력한다. 만약, 사전순으로 마지막에 오는 순열인 경우에는 -1을 출력한다.

예제 입력 1
4
1 2 3 4
예제 출력 1
1 2 4 3
예제 입력 2
5
5 4 3 2 1
예제 출력 2

5 3 4 2 1
5 3 4 1 2
4
1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2

-1*/
public class P10972_다음순열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set set = new HashSet();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList();
        boolean[] visit = new boolean[list.size()];
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        int targetIndex = -1;

        for(int i=list.size()-1; i>=1; i--){
            if(list.get(i) > list.get(i-1)){
                targetIndex = i-1;
                break;
            }
        }
        if(targetIndex == -1){
            System.out.println(-1);
            return;
        }


        for(int i=list.size()-1; i>=1; i--){
            if(list.get(i) > list.get(targetIndex)){
                int temp = list.get(targetIndex);
                list.set(targetIndex, list.get(i));
                list.set(i, temp);
                break;
            }
        }

        List<Integer> subList = list.subList(targetIndex+1, list.size());
        Collections.sort(subList);
        int k = 0;
        for(int i=1; i<subList.size(); i++){
            list.set(targetIndex+i, subList.get(k));
            k++;
        }
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) +" ");
        }
    }
}
