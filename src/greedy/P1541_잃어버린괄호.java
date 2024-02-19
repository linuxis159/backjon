package greedy;

import java.util.*;

public class P1541_잃어버린괄호 {
    static Scanner sc = new Scanner(System.in);
    static List<Character> expression = new ArrayList();
    static List<Integer> number = new ArrayList();
    static int minusValue = 0;
    static int plusValue = 0;
    public static void main(String[] args){
        String expression = sc.next();
        boolean zeroSkipFlag = true;
        boolean metMinusFlag = false;
        String numberString = "";
        for(int i=0; i<expression.length(); i++){
            char charecter = expression.charAt(i);
            if(charecter == '0' && zeroSkipFlag)
                continue;
            else if(charecter == '+' && !metMinusFlag){
                plusValue += Integer.parseInt(numberString);
                zeroSkipFlag = true;
                numberString = "";
            }
            else if(charecter == '+' && metMinusFlag){
                minusValue += Integer.parseInt(numberString);
                zeroSkipFlag = true;
                numberString = "";
            }
            else if(charecter == '-' && !metMinusFlag){
                plusValue += Integer.parseInt(numberString);
                metMinusFlag = true;
                zeroSkipFlag = true;
                numberString = "";
            }
            else if(charecter == '-' && metMinusFlag){
                minusValue += Integer.parseInt(numberString);
                zeroSkipFlag = true;
                numberString = "";
            }
            else if(i+1 == expression.length() && metMinusFlag){
                minusValue += Integer.parseInt(numberString + charecter);
            }
            else if(i+1 == expression.length() && !metMinusFlag){
                plusValue += Integer.parseInt(numberString + charecter);
            }
            else {
                zeroSkipFlag = false;
                numberString += charecter;
            }
        }
        System.out.println(plusValue - minusValue);
    }
}
