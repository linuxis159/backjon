package math.numberTheory.leastComnonMultiple;


import java.util.Scanner;

public class P13241_최소공배수 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        long A = sc.nextInt();
        long B = sc.nextInt();
        long moreBigger;
        long moreSmaller;
        long leastCommonDivisor = 0;
        if(A < B) {
            moreBigger = B;
            moreSmaller = A;
        }
        else {
            moreBigger = A;
            moreSmaller = B;
        }
        while(true){
            if(moreBigger % moreSmaller == 0){
                leastCommonDivisor = moreSmaller;
                break;
            }

            moreBigger %= moreSmaller;
            if(moreBigger < moreSmaller) {
                long temp = moreBigger;
                moreBigger = moreSmaller;
                moreSmaller = temp;
            }
        }
        System.out.println((A * B) / leastCommonDivisor);
    }
}
