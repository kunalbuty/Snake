import java.util.ArrayList;
import java.util.Random;

public class Snake {
    private int length;
    private int direction;
    private int up=0;
    private int right=1;
    private int left=2;
    private int down=3;

    private int[] head;

    private ArrayList<int[]> snakeBody= new ArrayList<>();

    //functions
    public Snake(int boardWidth, int boardHeight) {
        //add random numbers for snake spawn spot (-2 so no spawn at border)
        Random rand = new Random();
        int[] coordinates=new int[2];
        coordinates[0]=rand.nextInt(boardHeight-2)+1;
        coordinates[1]=rand.nextInt(boardWidth-2)+1;
        direction=0;//rand.nextInt(4);
        snakeBody.add(coordinates);
        head=coordinates;
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
        if(direction==up) {
            head[0]--;
        }
        else if(direction==down) {
            head[0]++;
        }
        else if(direction==left) {
            head[1]--;
        }
        else if(direction==right) {
            head[1]++;
        }
        if(grow==0) {
        //    snakeBody.remove(0);
        }
    }

    public void grow() {

    }

    public void checkAlive() {

    }

    public int getLength() {
        return length;
    }

    public ArrayList<int[]> getSnakeBody() {
        return snakeBody;
    }

    public int[] getHead() {
        return head;
    }
}
