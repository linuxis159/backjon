package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1786_찾기 {
    static String target = "";
    static String pattern = "";
    static int cnt = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        target = br.readLine();
        pattern = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<target.length() && i+pattern.length() <= target.length(); i++){
            String matching = "";
            for(int j=0; j<pattern.length(); j++){
                if(target.charAt(i+j) == pattern.charAt(j)){
                    matching += pattern.charAt(j);
                }
                else{
                    int jumpIndex = getJumpIndex(matching + pattern.charAt(j));
                    i += jumpIndex;
                    break;
                }
            }
            if(matching.equals(pattern)){
                ++cnt;
                sb.append(i+1 +" ");
            }
        }
        System.out.println(cnt);
        System.out.print(sb);
    }
    static int getJumpIndex(String readingPattern){
        int max = 0;
        int index = 0;
        int j=0;
        if(readingPattern.length() <= 1){
            return 0;
        }

        for(int i=1; i<readingPattern.length(); i++){
            if(readingPattern.charAt(i) == readingPattern.charAt(j)){
                j++;
                if(j > max){
                    max = j;
                    index = i;
                }
            }
            else {
                if(j != 0)
                    j--;
            }

        }
        return index - max;
    }
}
