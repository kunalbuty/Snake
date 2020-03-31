public class Game {
    private Snake snake;
    private int[][] board;
    private MainWindow window;
    public Game(int WIDTH,int HEIGHT,int SQUARE_SIZE) {
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
            @Override
            public void run() {
                System.out.println("made it here;");

                int temp=5;
                while(temp>0) {
                    temp--;
                    snake.moveStraight(0);
                    head=snake.getHead();
                    board[head[0]][head[1]]=2;
                    try {
                        Thread.sleep(1000);
                    }
                    catch (Exception e) {
                        System.out.println("Thread  interrupted.");
                    }
                    System.out.println("made it here;");
                    window.refresh(board);
                    window.repaint();

                }
            }
        }).start();
        return 0;
    }
}
