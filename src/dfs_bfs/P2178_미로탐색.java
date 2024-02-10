package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178_미로탐색 {
    static int maze[][];
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int height = sc.nextInt();
        int width = sc.nextInt();
        maze = new int[height][width];
        for(int i=0; i<height; i++){
            String row = sc.next();
            for(int j=0; j<width; j++){
                maze[i][j] = row.charAt(j) - '0';
            }
        }
        bfs(0,0);


    }
    static void bfs(int y, int x){
        Queue<Coordinate> queue = new LinkedList();
        queue.add(new Coordinate(y, x, 1));
        while (!queue.isEmpty()){
            Coordinate coordinate = queue.poll();
            if(coordinate.y == maze.length-1 && coordinate.x == maze[0].length -1){
                System.out.println(coordinate.cnt);
                return;
            }
            if(maze[coordinate.y][coordinate.x] == 0) {
                continue;
            }
            maze[coordinate.y][coordinate.x] = 0;

            if(coordinate.y-1 != -1) {
                if (maze[coordinate.y - 1][coordinate.x] != 0)
                    queue.add(new Coordinate(coordinate.y - 1, coordinate.x, coordinate.cnt+1));
            }
            if(coordinate.x+1 < maze[0].length) {
                if (maze[coordinate.y][coordinate.x+1] != 0)
                    queue.add(new Coordinate(coordinate.y, coordinate.x + 1, coordinate.cnt+1));
            }

            if(coordinate.y+1 < maze.length) {
                if(maze[coordinate.y+1][coordinate.x] != 0)
                    queue.add(new Coordinate(coordinate.y + 1, coordinate.x, coordinate.cnt+1));
            }
            if(coordinate.x-1 != -1) {
                if(maze[coordinate.y][coordinate.x-1] != 0)
                    queue.add(new Coordinate(coordinate.y, coordinate.x - 1, coordinate.cnt+1));
            }

        }
    }
    private static class Coordinate{
        int y;
        int x;
        int cnt;
        Coordinate(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

    }

}
