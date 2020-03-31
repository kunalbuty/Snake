import java.util.ArrayList;

public class Game {
    private Snake snake;
    private int[][] board;
    private MainWindow window;
    private int HEIGHT,WIDTH;

    public Game(int WIDTH,int HEIGHT,int SQUARE_SIZE) {
        this.HEIGHT=HEIGHT;
        this.WIDTH=WIDTH;
        board=new int[HEIGHT][WIDTH];
        snake=new Snake(WIDTH,HEIGHT);
        for(int i=0; i<HEIGHT;i++) {
            for(int j=0;j<WIDTH;j++) {
                board[i][j]=0;
            }
        }
        int[] head=snake.getHead();
        board[head[0]][head[1]]=2;
        window=new MainWindow(board, SQUARE_SIZE,HEIGHT,WIDTH);

    }

    public int startGame() {

        new Thread(new Runnable() {
            int[] head;
            ArrayList<int[]> snakeBody;
            @Override
            public void run() {

                int gameOver=0;
                while(gameOver==0) {
                    //move snake
                    snake.moveStraight(0);
                    gameOver=snake.checkIfDead();
                    if (gameOver == 1) {
                        break;
                    }

                    snakeBody=snake.snakeBody;
                    //reset board to 0s
                    for(int i=0; i<HEIGHT;i++) {
                        for(int j=0;j<WIDTH;j++) {
                            board[i][j]=0;
                        }
                    }
                    //add 1s to board where snake is
                    if(snakeBody.size()>1) {
                        for (int i = 0; i < snakeBody.size(); i++) {

                            if(snake.getHead()[0]>HEIGHT || snake.getHead()[0]<0) {
                                gameOver=1;
                                break;
                            }
                            if(snake.getHead()[1]>WIDTH || snake.getHead()[1]<0) {
                                gameOver=1;
                                break;
                            }
                            board[snake.getSnakeBodyH(i)][snake.getSnakeBodyW(i)] = 1;

                        }
                    }
                    else {
                        board[snake.getSnakeBodyH(0)][snake.getSnakeBodyW(0)] = 1;
                    }

                    try {
                        Thread.sleep(500);
                    }
                    catch (Exception e) {
                        System.out.println("Thread  interrupted.");
                    }
                    System.out.println("made it here;");
                    window.refresh(board);
                    window.repaint();

                }
                System.out.println("Game Over");
            }
        }).start();
        return 0;
    }
}
