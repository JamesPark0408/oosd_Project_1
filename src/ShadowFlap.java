import bagel.*;
import bagel.util.Rectangle;

/**
 *
 * Please filling your name below
 * @author: Park Chang Whan
 */
public class ShadowFlap extends AbstractGame {

    // All my variables go here
    private final Image BACKGROUND = new Image("res/background.png");
    private static final int WINDOW_WIDTH = 1024;
    private static final int WINDOW_HEIGHT = 768;

    private boolean start;
    private boolean end;
    private boolean win;

    private Text text;
    private Bird bird;
    private Pipes pipes;
    private int score;


    /**
     * Constructor
     */
    public ShadowFlap() {
        super(WINDOW_WIDTH, WINDOW_HEIGHT, "Shadow Flap");

        bird = new Bird();
        pipes = new Pipes(WINDOW_WIDTH, WINDOW_HEIGHT);
        text = new Text();
        start = true;
        end = false;
        win = false;
        score = 0;

    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        ShadowFlap game = new ShadowFlap();
        game.run();
    }

    /**
     * Performs a state update.
     * allows the game to exit when the escape key is pressed.
     */
    @Override
    public void update(Input input){
        BACKGROUND.drawFromTopLeft(0,0);

        // Starting screen
        if(start){

            // Show the instructions at the start (centered)
            text.start();

            if(input.wasPressed(Keys.SPACE)){
                start = false;
            }
        }

        // Let the game begin
        else if(!end){

            // Flying the bird
            if(input.wasPressed(Keys.SPACE)){
                bird.fly();
            }

            bird.drawBird();
            pipes.drawPipes();
            text.scoring(score);

            //Out-of-Bounds, Collision, Win Detections
            detection();
        }


// MAKE NEW METHOD FOR win_or_lose
        // Game ended and lost
        else if(!win){
            text.lose(score);
        }

        // Game ended and won
        else{
            text.win(score);
        }

        // Exit Game
        if (input.wasPressed(Keys.ESCAPE)) {
            Window.close();

        }
    }

    /**
     * Detects for:
     *      Out-of-Bound --> bird leaves window
     *      Collision --> bird collides with pipes
     *      Win --> bird passes the pipes
     */
    public void detection(){

        // Out of Bounds Detection
        Rectangle birdRectangle = bird.getRectangle();
        if(birdRectangle.bottom() > WINDOW_HEIGHT
                || birdRectangle.top() < 0){
            end = true;
        }

        // Collision Detection
        Rectangle[] pipeRectangles = pipes.getRectangle();
        if(birdRectangle.intersects(pipeRectangles[0])
                || birdRectangle.intersects(pipeRectangles[1])){
            end = true;
        }

        // Win Detection
        if(birdRectangle.centre().x > pipeRectangles[0].right()){
            end = true;
            win = true;
            score ++;
        }
    }
}
