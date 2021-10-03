import bagel.*;

/**
 * Creation of Text class which will draw and
 * keep track of all texts that are needed throughout the game
 */
public class Text {

    private Font font = new Font("res/slkscr.ttf", 48);
    private final String BEGINNING_TEXT = "PRESS SPACE TO START";
    private final String LOSE = "GAME OVER";
    private final String SCORE = "FINAL SCORE: ";
    private final String WIN = "CONGRATULATIONS!";

    /**
     * Empty Constructor for clarity
     */
    public Text(){
    }

    /**
     * Draws the necessary text for the start of game
     */
    public void start(){
        font.drawString(BEGINNING_TEXT,
                Window.getWidth()/2.0 - font.getWidth(BEGINNING_TEXT)/2.0,
                Window.getHeight()/2.0 - TEXT_HEIGHT/2);
    }

    /**
     * Draws the score counter
     */
    public void scoring(int score){
        font.drawString("SCORE: " + score, 100, 100);
    }

    /**
     * Draws the losing message on screen with correct score
     */
    public void lose(int score){
        font.drawString(LOSE,
                Window.getWidth()/2.0 - font.getWidth(LOSE)/2.0,
                Window.getHeight()/2.0 - TEXT_HEIGHT/2);
        font.drawString(SCORE + score,
                Window.getWidth()/2.0 - font.getWidth(SCORE + score)/2.0,
                Window.getHeight()/2.0 - TEXT_HEIGHT/2 + 75);
    }

    /**
     * Draws the winning message on screen with correct score
     */
    public void win(int score){
        font.drawString(WIN,
                Window.getWidth()/2.0 - font.getWidth(WIN)/2.0,
                Window.getHeight()/2.0 - TEXT_HEIGHT/2);
        font.drawString(SCORE + score,
                Window.getWidth()/2.0 - font.getWidth(SCORE + score)/2.0,
                Window.getHeight()/2.0 - TEXT_HEIGHT/2 + 75);
    }
}
