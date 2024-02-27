package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10816_숫자카드2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] card;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int[st.countTokens()];
        for(int i=0; st.hasMoreTokens(); i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; st.hasMoreTokens(); i++){
            binarySearch(0, N-1, Integer.parseInt(st.nextToken()));
        }

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
                    for(int i = from; i<card.length; i++){
                        if(card[i] == targetValue)
                            cnt++;
                        else
                            break;
                    }
                }
                System.out.print(cnt +" ");
                return;
            }
        }
        if(from > to) {
            System.out.print(0 + " ");
            return;
        }
        int median = (from+to) / 2;
        if(card[median] == targetValue){
            int cnt = 0;
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
            System.out.print(cnt +" ");
            return;
        }
        else if(card[median] <= targetValue)
            binarySearch(median+1, to, targetValue);
        else
            binarySearch(from, median-1, targetValue);


    }
}
