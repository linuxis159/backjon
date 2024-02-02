package math.numberTheory.leastComnonMultiple;


import java.util.Scanner;

public class P1934_최소공배수 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int result = 1;
            int A = sc.nextInt();
            int B = sc.nextInt();
            int moreSmaller;
            if( A > B)
                moreSmaller = B;
            else
                moreSmaller = A;
            for(int j=2; j<=moreSmaller; j++){
                if(A % j == 0 && B % j == 0){
                    A = A / j;
                    B = B / j;
                    moreSmaller /= j;
                    result = j * result;
                    j=1;
                }
            }
            System.out.println(result * A * B);
        }
    }
}
