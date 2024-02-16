package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P4179_불 {
    private static Scanner sc = new Scanner(System.in);
    static char[][] maze;
    static int firePositionX;
    static int firePositionY;
    static int humanPositionX;
    static int humanPositionY;
    static Queue<Position> humanQueue = new LinkedList();
    static Queue<Position> fireQueue = new LinkedList();
    static Queue<Position> fireTempQueue = new LinkedList();
    static Queue<Position> tempQueue = new LinkedList();
    static boolean success = false;
    static int min = 0;

    public static void main(String[] args){
        int R = sc.nextInt();
        int C = sc.nextInt();
        maze = new char[C][R];
        for(int i=0; i<C; i++){
            String input = sc.next();
            for(int j=0; j<R; j++){
                maze[i][j] = input.charAt(j);
                if(maze[i][j] == 'J'){
                    humanPositionX = j;
                    humanPositionY = i;
                }
                else if(maze[i][j] == 'F'){
                    firePositionX = j;
                    firePositionY = i;
                }
            }
        }
        humanQueue.add(new Position(humanPositionX, humanPositionY));
        fireQueue.add(new Position(firePositionX, firePositionY));
        bfs();
        if(!success)
            System.out.println("IMPOSSIBLE");
    }
    static void bfs(){
        while(!humanQueue.isEmpty()){
            while(!humanQueue.isEmpty()) {
                Position humanPosition = humanQueue.poll();
                if (!(maze[humanPosition.y][humanPosition.x] == 'J'))
                    continue;
                if (isExit(humanPosition.x, humanPosition.y)) {
                    System.out.println(humanPosition.cnt+1);
                    success = true;
                    return;
                }
                //위로
                if (maze[humanPosition.y - 1][humanPosition.x] == '.') {
                    maze[humanPosition.y - 1][humanPosition.x] = 'J';
                    Position newPosition = new Position(humanPosition.x,humanPosition.y - 1);
                    newPosition.cnt = humanPosition.cnt + 1;
                    tempQueue.add(newPosition);
                }
                //오른쪽
                if (maze[humanPosition.y][humanPosition.x + 1] == '.') {
                    maze[humanPosition.y][humanPosition.x + 1] = 'J';
                    Position newPosition = new Position( humanPosition.x + 1,humanPosition.y);
                    newPosition.cnt = humanPosition.cnt + 1;
                    tempQueue.add(newPosition);
                }

                //아래
                if (maze[humanPosition.y + 1][humanPosition.x] == '.') {
                    maze[humanPosition.y + 1][humanPosition.x] = 'J';
                    Position newPosition = new Position(humanPosition.x, humanPosition.y + 1);
                    newPosition.cnt = humanPosition.cnt + 1;
                    tempQueue.add(newPosition);
                }
                //왼쪽
                if (maze[humanPosition.y][humanPosition.x - 1] == '.') {
                    maze[humanPosition.y][humanPosition.x - 1] = 'J';
                    Position newPosition = new Position(humanPosition.x - 1, humanPosition.y);
                    newPosition.cnt = humanPosition.cnt + 1;
                    tempQueue.add(newPosition);
                }
            }
            while (!tempQueue.isEmpty()){
                humanQueue.add(tempQueue.poll());
            }
            while(!fireQueue.isEmpty()) {
                Position firePosition = fireQueue.poll();

                if(!fireException(firePosition.x, firePosition.y - 1)) {
                    if (!(maze[firePosition.y - 1][firePosition.x] == '#')
                    && !(maze[firePosition.y - 1][firePosition.x] == 'F')) {
                        maze[firePosition.y - 1][firePosition.x] = 'F';
                        fireTempQueue.add(new Position(firePosition.x, firePosition.y - 1));
                    }
                }
                //오른쪽
                if(!fireException(firePosition.x+1, firePosition.y)) {
                    if (!(maze[firePosition.y][firePosition.x + 1] == '#')
                            && !(maze[firePosition.y][firePosition.x+1] == 'F')) {
                        maze[firePosition.y][firePosition.x + 1] = 'F';
                        fireTempQueue.add(new Position(firePosition.x + 1, firePosition.y));
                    }
                }

                //아래
                if(!fireException(firePosition.x, firePosition.y+1)) {
                    if (!(maze[firePosition.y + 1][firePosition.x] == '#')
                            && !(maze[firePosition.y+1][firePosition.x] == 'F')) {
                        maze[firePosition.y + 1][firePosition.x] = 'F';
                        fireTempQueue.add(new Position(firePosition.x, firePosition.y + 1));
                    }
                }
                //왼쪽
                if(!fireException(firePosition.x-1, firePosition.y)){
                    if (!(maze[firePosition.y][firePosition.x - 1] == '#')
                            && !(maze[firePosition.y][firePosition.x-1] == 'F')) {
                        maze[firePosition.y][firePosition.x - 1] = 'F';
                        fireTempQueue.add(new Position(firePosition.x - 1, firePosition.y));
                    }
                }
                }

            while (!fireTempQueue.isEmpty()){
                fireQueue.add(fireTempQueue.poll());
            }

        }

    }
    static boolean isExit(int x, int y){
        try {
            char a = maze[y-1][x];
            char b = maze[y+1][x];
            char c = maze[y][x+1];
            char d = maze[y][x-1];
        }catch(Exception e){
            return true;
        }
        return false;
    }
    static boolean fireException(int x, int y){
        try {
            char a = maze[y][x];

        }catch(Exception e){
            return true;
        }
        return  false;
    }
    static class Position{

        int x;
        int y;
        int cnt = 0;
        Position(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
}
