package GameObjects.Structures;

import GameObjects.Grid.Position.AbstractUnitPosition;
import GameObjects.Grid.SimpleGxGrid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Tubes extends AbstractUnitPosition{

    private final double x;
    private double x2;
    private final double y;
    private double y2;
    private final Rectangle rectangleTop;
    private final Rectangle rectangleBot;
    private final SimpleGxGrid simpleGxGrid;
    private double speed = -4d;
    private final double acceleration = 0.2;
    private final Picture picture;
    private final double initialX = 1000;
    private double startX;
    private double startY;
    private double startY2;
    private double height;
    private final double width;
    private final double gap = 150;
    private boolean isMoving;
    private final int[] heights = new int[]{430, 270, 150, 50};
    private final String[] pictures = new String[]{"resources/tube_low.png", "resources/tube_mid.png", "resources/tube_high.png", "resources/tube_vhigh.png"};

    public Tubes(double col, double row, double height, SimpleGxGrid grid) { //graphical constructor
        super(col, row, grid);
        simpleGxGrid = grid;
        width = 50;
        this.height = height;
        x = grid.columnToX(col);
        startX = grid.columnToX(col);
        y = grid.rowToY(row);
        startY = grid.rowToY(row);
        y2 = height - 40 + gap;
        startY2 = height + gap;
        rectangleTop = new Rectangle(x, y, width, this.height-20);
        rectangleBot = new Rectangle(x, y2, width, grid.getHeight() - y2);
        picture = new Picture(rectangleTop.getX()-6, rectangleTop.getY(), "resources/tube_high.png");
    }
    public Tubes(double col, double row, SimpleGxGrid grid) { // logical constructor, used for collider
        super(col, row, grid);
        simpleGxGrid = grid;
        width = 50;
        x = grid.columnToX(col);
        y = grid.rowToY(row);
        y2 = height -40 + gap;
        rectangleTop = new Rectangle(x, y, width, this.height-10);
        rectangleBot = new Rectangle(x, y2, width, grid.getHeight() - y2);
        picture = new Picture(rectangleTop.getX()-6, rectangleTop.getY(), "resources/tube_high.png");
        changeHeight();
    }


    public double getHeightTop() {
        return height;
    }


    public double getWidth() {
        return width;
    }

    public void render() {
        picture.draw();
    }

    public int getXTop() {
        return rectangleTop.getX();
    }

    public int getXBot() {
        return rectangleBot.getX();
    }

    public int getYTop() {
        return rectangleTop.getY();
    }

    public int getYBot() {
        return rectangleBot.getY();
    }

    public double getInitialX() {
        return initialX;
    }

    @Override
    public void show() {
        rectangleTop.draw();
        rectangleBot.draw();
        picture.draw();
    }


    public double getSpeed() {
        return speed;
    }

    public void setSpeed() {
        this.speed -= acceleration;
    }

    @Override
    public void hide() {
        rectangleTop.delete();
        rectangleBot.delete();
        picture.delete();
    }

    public void moveLeft() {
        if (this.rectangleTop.getX() > 5 && this.rectangleBot.getX() > 5) {
            isMoving = true;
            this.rectangleTop.translate(speed, 0);
            this.rectangleBot.translate(speed, 0);
            this.picture.translate(speed, 0);

        } else {
            this.rectangleTop.translate(initialX, 0);
            this.rectangleBot.translate(initialX, 0);
            this.picture.translate(initialX, 0);
            changeHeight();
        }
    }

    public void changeHeight() {
        int random = (int) Math.floor(Math.random() * heights.length);
        rectangleTop.setHeight(heights[random]);
        this.height = heights[random];
        y2 = height + gap;
        rectangleBot.setY(y2);
        rectangleBot.setHeight(simpleGxGrid.getHeight() - y2);
        picture.load(pictures[random]);
    }

}
