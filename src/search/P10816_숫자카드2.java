package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.

예제 입력 1
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10

예제 출력 1
3 0 0 1 2 0 0 2
*/

public class P10816_숫자카드2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] card;
    static int[] target;
    static Map<Integer, Integer> map = new HashMap();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int[st.countTokens()];
        for(int i=0; st.hasMoreTokens(); i++){
            int value = Integer.parseInt(st.nextToken());
            if(map.containsKey(value)){
                int cnt = map.get(value);
                map.put(value, ++cnt);
            }
            else{
                map.put(value, 1);
            }
        }
        Arrays.sort(card);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; st.hasMoreTokens(); i++){
            int value = Integer.parseInt(st.nextToken());
            if(!map.containsKey(value)){
                 sb.append(0 + " ");
            }
            else {
                int cnt = map.get(value);
                sb.append(cnt + " ");
            }
        }
        System.out.print(sb);

    }
    static void binarySearch(int from, int to, int targetValue){

        if(from == to){
            if(card[from] == targetValue){
                int cnt = 1;
                if(from >= 1){
                    for(int i = from-1; i >= 0; i--){
                        if(card[i] == targetValue)
                            cnt++;
                        else
                            break;
                    }
                }
                if(from < card.length-1){
                    for(int i = from+1; i<card.length; i++){
                        if(card[i] == targetValue)
                            cnt++;
                        else
                            break;
                    }
                }
                sb.append(cnt +" ");
                return;
            }
        }
        else if(from > to) {
            sb.append(0 + " ");
            return;
        }

        int median = (from+to) / 2;

        if(card[median] == targetValue){
            int cnt = 1;
            if(median >= 1){
                for(int i = median-1; i >= 0; i--){
                    if(card[i] == targetValue)
                        cnt++;
                    else
                        break;
                }
            }
            if(median < card.length-1){
                for(int i = median+1; i<card.length; i++){
                    if(card[i] == targetValue)
                        cnt++;
                    else
                        break;
                }
            }
            sb.append(cnt +" ");
            return;
        }
        else if(card[median] < targetValue)
            binarySearch(median+1, to, targetValue);
        else
            binarySearch(from, median-1, targetValue);

    }

}
