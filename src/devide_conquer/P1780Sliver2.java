package devide_conquer;
/*
N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 우리는 이 행렬을
다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.

만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
(1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

출력
첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
*/
import java.util.Arrays;
import java.util.Scanner;
public class P1780Sliver2 {
    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] paper = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        recursive(paper,1,1, N);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }
    static void recursive(int[][] paper,int xStart, int yStart, int size){
        // 어디상 쪼개질 수 없음
        if(size == 1){
            if(paper[yStart][xStart] == -1){
                minusOne++;
                return;
            }
            else if(paper[yStart][xStart] == 0){
                zero++;
                return;
            }
            else {
                one++;
                return;
            }
        }

        // 모든 값이 같아야 하므로 첫번째 값 과 모든 값 비교해서 모두 같으면
        int firstValue = paper[yStart][xStart];
        loopOut:
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int current = paper[yStart+i][xStart+j];
                // 다른 값 있음
                if (firstValue != current) {
                    break loopOut;
                }
            }
            if (i+1 == size) {
                //-1 값으로 모두 같을 때
                if (firstValue == -1) {
                    minusOne++;
                    return;
                //0 값으로 모두 같을 때
                } else if (firstValue == 0) {
                    zero++;
                    return;
                //1 값으로 모두 같을 때
                } else {
                    one++;
                    return;
                }
            }
        }

        recursive(paper, xStart, yStart, size/3 ); //
        recursive(paper, xStart+(size/3),yStart,size/3); //
        recursive(paper, xStart+((size/3)*2),yStart,size/3);

        recursive(paper,xStart,yStart+(size/3),size/3);
        recursive(paper,xStart+(size/3),yStart+(size/3),size/3);
        recursive(paper,xStart+((size/3)*2),yStart+(size/3),size/3);

        recursive(paper, xStart, yStart+((size/3)*2), size/3); // 1 -> 19
        recursive(paper, xStart+(size/3),yStart+((size/3)*2),  size/3);
        recursive(paper, xStart+((size/3)*2), yStart+((size/3)*2), size/3);



    }

}
