package math.statistics.standard_deviation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Scanner;

public class P17357_자동차가김준표의편을들면 {
    static Scanner sc = new Scanner(System.in);
    static int sequence[];
    public static void main(String[] args){
        int N = sc.nextInt();
        sequence = new int[N];
        double medium = 0;
        int sum = 0;
        for(int i=0; i<N; i++){
            sequence[i] = sc.nextInt();
            sum +=  sequence[i];
        }
        medium = sum / N;

        for (int i = 0; i < N; i++) {
            BigDecimal max = new BigDecimal(0);
            int index = 0;
            for(int j=0; j+i<N; j++){
                if(i == 0)
                    break;
                int cnt = 0;
                BigDecimal cur = new BigDecimal(0);
                BigDecimal temp[] = new BigDecimal[i+1];
                int sumtemp = 0;
                for(int k=j; cnt<=i && k<N; k++){
                    sumtemp += sequence[k];
                    temp[cnt] = BigDecimal.valueOf(sequence[k]);
                    cnt++;
                }
                BigDecimal tempMedium = new BigDecimal(sumtemp/(i+1));
                for(int p=0; p<cnt; p++){
                    cur = cur.add(temp[p].subtract(tempMedium).pow(2));
                }
                if(cur.divide(BigDecimal.valueOf(i+1), 10000,RoundingMode.HALF_DOWN).compareTo(max) == 1) {
                    //System.out.println(cur/(i+1));
                    max = cur.divide(BigDecimal.valueOf(i+1),10000,RoundingMode.HALF_DOWN);
                    index = j;
                }
            }
            if(i == 0)
                System.out.println(1);
            else
                System.out.println(index+1);

        }
    }
}
