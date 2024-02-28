package graph.unionFind;

import java.util.Scanner;

public class P1976_여행가자 {
    public static Scanner sc = new Scanner(System.in);
    public static int arr[];
    public static int plan[];
    public static void main(String[] args){
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N+1];
        plan = new int[M+1];
        for(int i=1; i<=N; i++){
            arr[i] = i;
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                int flag = sc.nextInt();
                if(flag == 1){
                    if(arr[i] < arr[j])
                        setParent(arr[j], arr[i]);
                    else if(arr[i] > arr[j])
                        setParent(arr[i], arr[j]);
                }
            }
        }

        int plan = sc.nextInt();
        int compareParent = getParent(plan);
        String yesOrNo = "YES";

        for(int i=2; i<=M; i++){
            plan = sc.nextInt();
            int parent = getParent(plan);
            if(compareParent != parent){
                yesOrNo = "NO";
            }
        }
        System.out.println(yesOrNo);
    }
    private static int getParent(int index){
        if(arr[index] == index)
            return index;
        else
            return getParent(arr[index]);
    }
    private static void setParent(int index, int newIndex){
        if(arr[index] == index) {
            arr[index] = newIndex;
            return;
        }
        else {
            int temp  = arr[index];
            arr[index] = newIndex;
            getParent(temp);
        }
    }
}
