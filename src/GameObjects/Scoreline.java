package GameObjects;

import GameObjects.Grid.SimpleGxGrid;
import GameObjects.Structures.Tubes;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Scoreline {


    private final Rectangle line;
    private final Tubes tube;
    private double x;
    private final double y;
    private final double padding;
    private boolean reset;
    private boolean canScore;

    private static boolean scored;


    public Scoreline(SimpleGxGrid grid, Tubes tube) {
        this.tube = tube;
        padding = 50;
        x = tube.getXTop() + padding;
        y = tube.getYTop();
        reset = false;
        canScore = true;
        line = new Rectangle(x, y, 0, grid.getHeight());
    }


    public void moveLeft() {
        if (tube.getXTop() > 0) {
            this.line.translate(tube.getSpeed(), 0);
            x = x + tube.getSpeed();
        } else {
            setPosition();
            reset = true;
        }
    }


    public void show() {
        line.draw();
    }

    public void hide() {
        line.delete();
    }

    public void setPosition() {
        this.line.translate(tube.getInitialX(), 0);
        x = tube.getInitialX();
        canScore = true;
    }

    public void setCanScore(boolean canScore) {
        this.canScore = canScore;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public boolean isReset() {
        return reset;
    }

    public boolean canScore() {
        return !scored;
    }

    public static void resetScoreline(){
        scored = false;
    }

    public double getX() {
        return x;
    }

    public void setScored(){
        canScore = false;
        scored = true;
    }
}