import java.awt.*;

public class Main {
    private static final int WIDTH=20;
    private static final int HEIGHT=25;
    private static final int SQUARE_SIZE=30;
    public static void main(String[] args) {
        Game game=new Game(WIDTH,HEIGHT,SQUARE_SIZE);
        int result=game.startGame();
    }
}
