package GameObjects.Grid;

import GameObjects.Grid.Position.GridPosition;

public interface Grid {

    //Initialzes the grid
    void init();

    //number of cols
    double getCols();

    //number of rows
    double getRows();

    GridPosition makeGridPosition();

    /**
     * Creates a a grid position in a specific column and row
     *
     * @param col   the position column
     * @param row   the position row
     * @return the new grid position
     */
    GridPosition makeGridPosition(double col, double row);

}
