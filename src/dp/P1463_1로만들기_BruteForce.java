package dp;


import java.util.*;

/*정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.*/
public class P1463_1로만들기_BruteForce {
    static Scanner sc = new Scanner(System.in);
    static Queue<Integer> queue = new LinkedList();
    static int cnt = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        queue.add(N);
        for(int i=0; ;i++){
            List<Integer> arr = new ArrayList();
            while(!queue.isEmpty()){
                int num = queue.poll();
                if(num == 1){
                    System.out.println(cnt);
                    return;
                }
                if(num % 3 == 0) arr.add(num / 3);
                if(num % 2 == 0) arr.add(num / 2);
                arr.add(num - 1);

            }
            for(int j=0; j<arr.size(); j++)
                queue.add(arr.get(j));
            cnt++;
        }
    }
}
