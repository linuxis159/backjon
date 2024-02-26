package string;

import java.util.Scanner;

public class P16172_나는친구가적다 {
    static Scanner sc = new Scanner(System.in);
    static int[] patternJumpTable;
    static char[] skipChar = {
            '0','1','2','3','4','5','6','7','8','9'
    };
    public static void main(String[] args){
        String target = sc.next();
        String pattern = sc.next();
        patternJumpTable = new int[pattern.length()];

        int j =0;
        for(int i=1; i<patternJumpTable.length; i++){

            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = patternJumpTable[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)){
                patternJumpTable[j] = ++j;
            }
        }
        j = 0;

        for(int i=0; i<target.length(); i++){
            boolean flag = false;

            if(48 <= target.charAt(i) && target.charAt(i) <= 57)
                continue;


            while(j > 0 && target.charAt(i) != pattern.charAt(j)){
                j = patternJumpTable[j-1];
            }

            if(pattern.length()-1 == j){
                System.out.println(1);
                return;
            }
            else if(target.charAt(i) == pattern.charAt(j)){
                 ++j;
            }
        }
        System.out.println(0);
    }

}
