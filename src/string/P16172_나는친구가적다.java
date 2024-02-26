package string;

import java.util.Scanner;

public class P16172_나는친구가적다 {
    static Scanner sc = new Scanner(System.in);
    static int[] patternJumpTable;
    public static void main(String[] args){
        String target = sc.next();
        String pattern = sc.next();
        patternJumpTable = new int[pattern.length()];

        int j =0;
        for(int i=1; i<patternJumpTable.length; i++){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = patternJumpTable[j-1];
            }
        }
    }

}
