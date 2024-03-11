package string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P1316_그룹단어체커 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        int cnt = 0;
        for(int i=0; i<N; i++){
            String string = sc.next();
            if(checker(string)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static boolean checker(String target){
        Set<Character> set = new HashSet();
        char before = target.charAt(0);
        set.add(before);
        for(int i=1; i<target.length(); i++){
            char cur = target.charAt(i);
            if(before == cur)
                continue;
            else{
                if(set.contains(cur)){
                    return false;
                }
                set.add(cur);
                before = cur;
            }
        }
        return true;
    }
}
