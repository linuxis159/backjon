package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P4179_불 {
    private static Scanner sc = new Scanner(System.in);
    static String[][] maze;
    static int firePositionX;
    static int firePositionY;
    static int humanPositionX;
    static int humanPositionY;
    static Queue<Position> humanQueue = new LinkedList();
    static Queue<Position> fireQueue = new LinkedList();
    boolean success = false;
    static int min = 0;

    public static void main(String[] args){
        int R = sc.nextInt();
        int C = sc.nextInt();
        maze = new String[C][R];
        for(int i=0; i<C; i++){
            for(int j=0; j<R; j++){
                String input = sc.next();
                maze[i][j] = input;
                if(input.equals("J")){
                    humanPositionX = j;
                    humanPositionY = i;
                }
                else if(input.equals("F")){
                    firePositionX = j;
                    firePositionY = i;
                }
            }
        }
        humanQueue.add(new Position(humanPositionX, humanPositionY, "Human"));
        humanQueue.add(new Position(firePositionX, firePositionY, "Fire"));
        bfs();
    }
    static void bfs(){
        while(true){
            min++;
            Position humanPosition = humanQueue.poll();
            isExit(humanPosition.x, humanPositionY);
            //위로
            if(!maze[humanPosition.y-1][humanPosition.x].equals("#") &&
            !maze[humanPosition.y-1][humanPosition.x].equals("F") ){
                maze[humanPosition.y-1][humanPosition.x] = "J";
                humanQueue.add(new Position(humanPosition.x, humanPosition.y-1, "Human"));
            }
            //오른쪽
            if(maze[humanPosition.y][humanPosition.x+1].equals("#") &&
            !maze[humanPosition.y][humanPosition.x+1].equals("F")){
                maze[humanPosition.y][humanPosition.x+1] = "J";
                humanQueue.add(new Position(humanPosition.x+1, humanPosition.y, "Human"));
            }

            //아래
            if(maze[humanPosition.y+1][humanPosition.x].equals("#") &&
            !maze[humanPosition.y+1][humanPosition.x].equals("F")){
                maze[humanPosition.y+1][humanPosition.x] = "J";
                humanQueue.add(new Position(humanPosition.x, humanPosition.y+1, "Human"));
            }
            //왼쪽
            if(maze[humanPosition.y][humanPosition.x-1].equals("#") &&
            !maze[humanPosition.y][humanPosition.x-1].equals("F")){
                maze[humanPosition.y][humanPosition.x-1] = "J";
                humanQueue.add(new Position(humanPosition.x-1, humanPosition.y, "Human"));
            }
        }

    }
    static boolean isExit(int x, int y){
        try {
            String a = maze[y-1][x];
            String b = maze[y+1][x];
            String c = maze[y][x+1];
            String d = maze[y][x-1];
        }catch(Exception e){
            return true;
        }
        return false;
    }
    static class Position{
        String humanOrFire;
        int x;
        int y;
        Position(int x, int y, String humanOrFire){
            this.x = x;
            this.y = y;
            this.humanOrFire = humanOrFire;
        }
    }
}
