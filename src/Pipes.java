import bagel.DrawOptions;
import bagel.Image;
import bagel.util.*;

/**
 * Creation of Pipes class which will draw and
 * keep track of both the top and bottom pipes
 * throughout the game
 */
public class Pipes {

    // point array will have
        // point[0] = x-coordinate for both pipes (top left)
        // point[1] = y-coordinate of top pipe (top left)
        // point[2] = y-coordinate of bottom pipe (top left)
    private double [] point;
    private double speed;
    private final DrawOptions ROTATE = new DrawOptions().setRotation(Math.PI);
    private final double GAP = 168;
    private Image PIPE = new Image("res/pipe.png");

    /**
     * Constructor given Window size
     */
    public Pipes(int windowWidth, int windowHeight){

        // For reference: 65x768 size

        point = new double[3];

        // Spawning pipes at right border of window
            // right end of pipe is touching the right border of window
        // Get centre x-coordinate of pipes
        point[0] = windowWidth - PIPE.getWidth();


        // Gap of 168 pixels and centered on y-axis (84 pixels up and down from centre)
        point[1] = -(PIPE.getHeight()/2 + GAP/2);
        point[2] = windowHeight/2 + GAP/2;

        speed = 3.0;

    }

    /**
     * Draws the pipes on the Window
     *  - moves to the left 5 pixels per frame
     */
    public void drawPipes(){

        PIPE.drawFromTopLeft(point[0], point[1]);
        PIPE.drawFromTopLeft(point[0], point[2], ROTATE);

        // pipes move left every frame
        point[0] -= speed;

    }


    /**
     * Gets the Rectangle objects for both pipes for detections
     */
    public Rectangle[] getRectangle(){
        Rectangle[] rec = new Rectangle[2];

        rec[0] = new Rectangle(point[0], point[1],
                PIPE.getWidth(), PIPE.getHeight());
        rec[1] = new Rectangle(point[0], point[2],
                PIPE.getWidth(), PIPE.getHeight());

        return rec;
    }
}
