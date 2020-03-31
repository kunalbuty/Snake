import java.awt.*;
import javax.swing.JFrame;


public class MainWindow extends Canvas {
    private int[][] board;
    private final int WIDTH=10;
    private final int HEIGHT=15;
    private final int SQUARE_SIZE=30;

    public MainWindow() {

        board=new int[HEIGHT][WIDTH];
        for(int i=0; i<HEIGHT;i++) {
            for(int j=0;j<WIDTH;j++) {
                board[i][j]=0;
            }
        }
        board[0][0]=1;
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas =this;
        canvas.setSize(1000, 1000);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    public void paint(Graphics g) {
        for(int i=0; i<HEIGHT;i++) {
            for (int j = 0; j < WIDTH; j++) {
                if(board[i][j]==1) {
                    g.setColor(Color.YELLOW);
                }
                else if(board[i][j]==0){
                    g.setColor(Color.BLACK);
                }
                else {
                    g.setColor(Color.RED);
                }
                g.fillRect(j*SQUARE_SIZE,i*SQUARE_SIZE,SQUARE_SIZE,SQUARE_SIZE);
                //g.fillOval(100, 100, 200, 200);
            }
        }
    }
}
