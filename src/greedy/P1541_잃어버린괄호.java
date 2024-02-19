package greedy;

import java.util.*;

public class P1541_잃어버린괄호 {
    static Scanner sc = new Scanner(System.in);
    static List<Character> expression = new ArrayList();
    static List<Integer> number = new ArrayList();
    public static void main(String[] args){
        String expression = sc.next();
        boolean zeroSkipFlag = true;
        boolean startMinusFlag = false;
        for(int i=0; i<expression.length(); i++){
            char charecter = expression.charAt(i);
            if(charecter == '0' && zeroSkipFlag)
                continue;
            else if(charecter == '-' && !startMinusFlag){

            }
            else if(charecter == '+' && startMinusFlag){
                
            }
            else if(charecter == '+'){

            }


        }
    }
}
