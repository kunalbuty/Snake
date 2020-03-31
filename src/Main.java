import java.awt.*;

public class Main {
    private static final int WIDTH=10;
    private static final int HEIGHT=15;
    private static final int SQUARE_SIZE=50;
    public static void main(String[] args) {
        Game game=new Game(WIDTH,HEIGHT,SQUARE_SIZE);
        int result=game.startGame();
    }
}
