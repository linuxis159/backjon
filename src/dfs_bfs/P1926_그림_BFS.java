package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1926_그림_BFS {
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
                    bfs(i, j);
                    if(paintingArea > paintingMaxArea){
                        paintingMaxArea = paintingArea;
                    }
                }
            }
        }
        System.out.println(paintCnt);
        System.out.println(paintingMaxArea);
    }
    static void bfs(int y, int x){
        Queue<Coordinate> queue = new LinkedList();
        queue.add(new Coordinate(y, x));
        while (!queue.isEmpty()){
            Coordinate coordinate = queue.poll();
            if(painting[coordinate.y][coordinate.x] == 0)
                continue;
            paintingArea++;
            painting[coordinate.y][coordinate.x] = 0;

            if(coordinate.y-1 != -1) {
                if (painting[coordinate.y - 1][coordinate.x] != 0)
                    queue.add(new Coordinate(coordinate.y - 1, coordinate.x));
            }
            if(coordinate.x+1 < painting[0].length) {
                if (painting[coordinate.y][coordinate.x+1] != 0)
                    queue.add(new Coordinate(coordinate.y, coordinate.x + 1));
            }

            if(coordinate.y+1 < painting.length) {
                if(painting[coordinate.y+1][coordinate.x] != 0)
                queue.add(new Coordinate(coordinate.y + 1, coordinate.x));
            }
            if(coordinate.x-1 != -1) {
                if(painting[coordinate.y][coordinate.x-1] != 0)
                    queue.add(new Coordinate(coordinate.y, coordinate.x - 1));
            }

        }
    }
    private static class Coordinate{
        int y;
        int x;
        Coordinate(int y, int x){
            this.y = y;
            this.x = x;
        }

    }
}
