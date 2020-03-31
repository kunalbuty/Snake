import java.util.ArrayList;
import java.util.Random;

public class Snake {
    private int length;
    private int direction;
    private int up=0;
    private int right=1;
    private int left=2;
    private int down=3;
    private int HEIGHT,WIDTH;

    private int[] head;
    private int[] newHead;

    public ArrayList<int[]> snakeBody= new ArrayList<>();

    //functions
    public Snake(int boardWidth, int boardHeight) {
        WIDTH=boardWidth;
        HEIGHT=boardHeight;
        //add random numbers for snake spawn spot (-2 so no spawn at border)
        Random rand = new Random();
        int[] coordinates=new int[2];
        coordinates[0]=rand.nextInt(boardHeight-2)+1;
        coordinates[1]=rand.nextInt(boardWidth-2)+1;
        direction=1;//rand.nextInt(4);
        snakeBody.add(coordinates);
        head=snakeBody.get(0);
        length=1;
    }

    public void moveLeft(int grow) {
        if(direction==0) {
            direction=3;
        }
        else {
            direction--;
        }
        moveStraight(grow);
    }

    public void moveRight(int grow) {
        if(direction==3) {
            direction=0;
        }
        else {
            direction++;
        }
        moveStraight(grow);
    }

    public void moveStraight(int grow) {
        newHead=new int[2];
        if(direction==up) {
            newHead[0]=head[0]-1;
            System.out.println("newHead is: " + newHead[0] + ", head is: " + head[0]);

            newHead[1]=head[1];
        }
        else if(direction==down) {
            newHead[0]=head[0]+1;
            newHead[1]=head[1];
        }
        else if(direction==left) {
            newHead[0]=head[0];
            newHead[1]=head[1]-1;
        }
        else if(direction==right) {
            newHead[0]=head[0];
            newHead[1]=head[1]+1;
        }
        snakeBody.add(newHead);
        head=newHead;


        if(grow==0) {
            snakeBody.remove(0);
        }
        System.out.println("new head is: " + snakeBody.get(0)[0]);
    }

    public void grow() {

    }

    public int checkIfDead() {
        //if out of bounds
        if(this.getHead()[0]>=HEIGHT || this.getHead()[0]<0) {
            return 1;
        }
        if(this.getHead()[1]>=WIDTH || this.getHead()[1]<0) {
            return 1;
        }
        //if snake hits itself (not tested)
        for(int i=0;i<snakeBody.size()-1;i++) {
            if(this.getHead()[0]==snakeBody.get(i)[0] && this.getHead()[1]==snakeBody.get(i)[1]) {
                return 1;
            }
        }
        return 0;
    }

    public int getLength() {
        return length;
    }

    public int getSnakeBodyH(int i) {
        return snakeBody.get(i)[0];
    }

    public int getSnakeBodyW(int i) {
        return snakeBody.get(i)[1];
    }

    public int[] getHead() {
        return head;
    }
}
