package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1786_찾기 {
    static String target = "";
    static String pattern = "";
    static int cnt = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] patternJumpTable;
    public static void main(String[] args) throws IOException {
        target = br.readLine();
        pattern = br.readLine();
        patternJumpTable = new int[pattern.length()];
        Arrays.fill(patternJumpTable, 0);
        createPatternTable();
        StringBuilder sb = new StringBuilder();

        int j=0;
        for(int i=0; i<target.length(); i++){
            while(target.charAt(i) != pattern.charAt(j) && j > 0){
                j = patternJumpTable[j-1];
            }

            if(target.charAt(i) == pattern.charAt(j)){
                if(j == pattern.length() -1) {
                    cnt++;
                    sb.append(i - pattern.length() + 2 + " ");
                    j = patternJumpTable[j];
                }
                else j++;
            }
        }
        System.out.println(cnt);
        System.out.print(sb);
    }
    static void createPatternTable(){
        int j=0;
        for(int i=1; i<pattern.length(); i++){
            while(pattern.charAt(i) != pattern.charAt(j) && j > 0){
                j = patternJumpTable[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j))
                patternJumpTable[i] = ++j;

        }
    }
}
