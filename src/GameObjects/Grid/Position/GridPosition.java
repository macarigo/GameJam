package GameObjects.Grid.Position;

import GameObjects.Grid.GridDirection;

public interface GridPosition {

    /**
     * Gets the position column in the grid
     *
     * @return the position column
     */
    double getCol();

    /**
     * Gets the position row in the grid
     *
     * @return the position row
     */
    double getRow();

    /**
     * Updates the position column and row
     *
     * @param col the new position column
     * @param row the new position row
     */
    void setPos(double col, double row);

    /**
     * Displays the position in the grid
     */
    void show();

    /**
     * Hides the position in the grid
     */
    void hide();

    void moveLeft() throws InterruptedException;
    /**
     * Tests equality with another position
     *
     * @param position the position to test against
     * @return true if positions are equal
     */
    boolean equals(GridPosition position);

}
