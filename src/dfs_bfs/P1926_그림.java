package dfs_bfs;

import java.util.Scanner;

public class P1926_그림 {
    static int painting[][];
    private static Scanner sc = new Scanner(System.in);
    static int paintCnt = 0;
    static int paintingArea = 0;
    static int paintingMaxArea = 0;
    public static void main(String[] args){
        int height = sc.nextInt();
        int width = sc.nextInt();
        painting = new int[height][width];
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                painting[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(painting[i][j] != 0){
                    paintCnt++;
                    paintingArea = 0;
                    dfs(i, j);
                    if(paintingArea > paintingMaxArea){
                        paintingMaxArea = paintingArea;
                    }
                }
            }
        }
        System.out.println(paintCnt);
        System.out.println(paintingMaxArea);
    }
    static void dfs(int y, int x){
        try {
            if(painting[y][x] == 0)
                return;
            paintingArea++;
            painting[y][x] = 0;
            dfs(y-1, x);
            dfs(y,x+1);
            dfs(y+1,x);
            dfs(y,x-1);

        } catch (ArrayIndexOutOfBoundsException e){
            return;
        }
    }
}
