package string_process;
import java.util.Scanner;
public class P1152 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        if(sb.toString().equals(" ")){
            System.out.println(0);
            return;
        }
        if(sb.charAt(0) == ' '){
            sb.deleteCharAt(0);
        }
        if(sb.charAt(sb.length()-1) == ' ')
            sb.deleteCharAt(sb.length()-1);
        String processedSentence = sb.toString();
        String words[] = processedSentence.split(" ");

        System.out.println(words.length);
    }
}
