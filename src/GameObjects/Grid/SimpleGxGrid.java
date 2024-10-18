package GameObjects.Grid;

import GameObjects.Mario;
import GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class SimpleGxGrid implements Grid {

    public static final int PADDING = 5;
    public static final int FLOPPYPAD = 40;

    private final double cellSize = 15;
    private final double cols;
    private final double rows;

    private final Rectangle field;


    public SimpleGxGrid(double cols, double rows) {
        this.cols = cols;
        this.rows = rows;
        this.field = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        field.setColor(Color.BLUE);
    }

    @Override
    public void init() {
        this.field.draw();

    }

    public double getCellSize() {
        return cellSize;
    }

    @Override
    public double getCols() {
        return this.cols;
    }

    @Override
    public double getRows() {
        return this.rows;
    }

    public double getWidth() {
        return this.field.getWidth();
    }

    public double getHeight() {
        return this.field.getHeight();
    }

    public double getX() {
        return this.field.getX();
    }


    public double getY() {
        return this.field.getY();
    }

    @Override
    public GridPosition makeGridPosition() {
        return null;
    }

    @Override
    public GridPosition makeGridPosition(double col, double row) {
        return null;
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     *
     * @param row index
     * @return y pixel value
     */
    public double rowToY(double row) {
        return PADDING + cellSize * row;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     *
     * @param column index
     * @return x pixel value
     */
    public double columnToX(double column) {
        return PADDING + cellSize * column;
    }


    /**
     *
     * FLOPPYPAD is used here to compensate for the differences between the position of the picture Floppy with its rectangle representation
     *
     */
    public boolean isOutOfBoundsTop(Mario mario){

        return  mario.getY() - 5 <= PADDING || mario.getX() <= PADDING;
    }
    public boolean isOutOfBoundsBot(Mario mario){
        return mario.getY()+ FLOPPYPAD  >= getHeight() || mario.getX() >= getWidth();
    }

}

